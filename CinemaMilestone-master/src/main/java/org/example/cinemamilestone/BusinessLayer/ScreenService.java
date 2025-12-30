package org.example.cinemamilestone.BusinessLayer;

import jakarta.validation.Valid;
import org.example.cinemamilestone.DataAccessLayer.Film;
import org.example.cinemamilestone.DataAccessLayer.Screen;
import org.example.cinemamilestone.DataAccessLayer.ScreenRepository;
import org.example.cinemamilestone.MapLayer.FilmMapper;
import org.example.cinemamilestone.MapLayer.ScreenMapper;
import org.example.cinemamilestone.PresentationLayer.FilmResponseModel;
import org.example.cinemamilestone.PresentationLayer.ScreenRequestModel;
import org.example.cinemamilestone.PresentationLayer.ScreenResponseModel;
import org.example.cinemamilestone.utilities.FilmNotFoundException;
import org.example.cinemamilestone.utilities.InvalidDateException;
import org.example.cinemamilestone.utilities.ScreenNotFoundException;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ScreenService {
    private final ScreenRepository screenRepository;
    private final ScreenMapper screenMapper;
    private final FilmMapper filmMapper;


    public ScreenService(ScreenRepository screenRepository, ScreenMapper screenMapper, FilmMapper filmMapper) {
        this.screenRepository = screenRepository;
        this.screenMapper = screenMapper;
        this.filmMapper = filmMapper;
    }


    public List<ScreenResponseModel> getScreen() {
        List<Screen> screens = this.screenRepository.findAll();
        List<ScreenResponseModel> screenResponseModels = new ArrayList<>();
        for(Screen screen : screens) {
            screenResponseModels.add(this.screenMapper.toResponse(screen));
        }
        return screenResponseModels;
    }

    public ScreenResponseModel getScreenById(String id) {
        long longId = Long.parseLong(id);
        Optional<Screen> optionalScreen = this.screenRepository.findById(longId);

        if(optionalScreen.isPresent()) {
            Screen screen = optionalScreen.get();
            ScreenResponseModel screenResponseModel = this.screenMapper.toResponse(screen);
            return screenResponseModel;
        }else{
            throw new ScreenNotFoundException("Screen with this id:" + longId + " cannot be found.");
        }
    }

    public ScreenResponseModel createScreen(ScreenRequestModel screenData) {
        LocalDate currentDate = LocalDate.now();
        LocalDate screenDate = screenData.getScreenDate();
        if(screenDate.isBefore(currentDate)) {
            throw new InvalidDateException("Invalid date");
        }
        Screen savedScreen = this.screenRepository.save(this.screenMapper.toEntity(screenData));
        return this.screenMapper.toResponse(savedScreen);
    }

    public ScreenResponseModel updateScreen(String id, ScreenRequestModel screenRequestModel) {
        long longId = Long.parseLong(id);
        Optional<Screen> optionalScreen = this.screenRepository.findById(longId);
        if(optionalScreen.isPresent()) {
            Screen screen = optionalScreen.get();
        }else{
            throw new ScreenNotFoundException("This screen:" + longId + " does not exist.");
        }
        Screen newScreen = this.screenMapper.toEntity(screenRequestModel);
        newScreen.setId(longId);
        Screen updatedScreen = this.screenRepository.save(newScreen);
        return this.screenMapper.toResponse(updatedScreen);
    }

    public void deleteScreen(String id) {
        long longId = Long.parseLong(id);
        Optional<Screen> optionalScreen = this.screenRepository.findById(longId);
        if(optionalScreen.isPresent()) {
            Screen screen = optionalScreen.get();
        }
        this.screenRepository.deleteById(longId);
    }
    public FilmResponseModel getFilmByScreenId(Long screenId) {
        Screen screen = screenRepository.findById(screenId)
                .orElseThrow(() -> new ScreenNotFoundException("Screen not found with id: " + screenId));
        Film film = screen.getFilm();
        if (film == null) {
            throw new FilmNotFoundException("No film associated with screen id: " + screenId);
        }

        return filmMapper.toResponseModel(film);
    }

}
