package org.example.cinemamilestone.BusinessLayer;
import org.example.cinemamilestone.DataAccessLayer.Screen;
import org.example.cinemamilestone.DataAccessLayer.ScreenRepository;
import org.example.cinemamilestone.MapLayer.FilmMapper;
import org.example.cinemamilestone.PresentationLayer.FilmSummary;
import org.example.cinemamilestone.DataAccessLayer.Film;
import org.example.cinemamilestone.DataAccessLayer.FilmRepository;
import org.example.cinemamilestone.PresentationLayer.FilmRequestModel;
import org.example.cinemamilestone.PresentationLayer.FilmResponseModel;
import org.example.cinemamilestone.PresentationLayer.ScreenResponseModel;
import org.example.cinemamilestone.utilities.ScreenNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.cinemamilestone.utilities.FilmNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FilmService {

    private final FilmRepository filmRepository;
    private final FilmMapper filmMapper;

    public FilmService(FilmRepository filmRepository, FilmMapper filmMapper) {
        this.filmRepository = filmRepository;
        this.filmMapper = filmMapper;
    }

    public List<FilmResponseModel> getAllFilms() {

        List<FilmResponseModel> responses = new ArrayList<>();
        for (Film film : filmRepository.findAll()) {
            responses.add(filmMapper.toResponseModel(film));
        }
        return responses;
    }
    public FilmResponseModel getFilmById(String id) {
        Long idLong = Long.parseLong(id);
        Optional<Film> optionalFilm = this.filmRepository.findById(idLong);

        if(optionalFilm.isPresent()) {
            Film film = optionalFilm.get();
            FilmResponseModel filmResponseModel = this.filmMapper.toResponseModel(film);
            return filmResponseModel;
        }else{
            throw new FilmNotFoundException("Film with this id:" + idLong + " cannot be found.");
        }
    }

    public FilmResponseModel addFilm(FilmRequestModel requestModel) {
        Film film = filmMapper.toEntity(requestModel);
        Film savedFilm = filmRepository.save(film);
        return filmMapper.toResponseModel(savedFilm);
    }
    public FilmResponseModel updateFilm(long id, FilmRequestModel requestModel) {
        Optional<Film> optionalFilm = filmRepository.findById(id);
        if(optionalFilm.isPresent()) {
            Film filmToUpdate = optionalFilm.get();
            filmToUpdate.setTitle(requestModel.getFilmName());
            filmToUpdate.setGenre(requestModel.getFilmGenre());
            filmToUpdate.setDurationMinutes(requestModel.getFilmDuration());
            filmToUpdate.setLanguage(requestModel.getFilmLanguage());
            filmToUpdate.setFilmRating(requestModel.getFilmRating());
            filmToUpdate.setFilmDescription(requestModel.getFilmDescription());

            Film savedFilm = filmRepository.save(filmToUpdate);
            return  filmMapper.toResponseModel(savedFilm);

        } else {
            throw new FilmNotFoundException("Film not found with id: " + id);
        }
    }

    public void deleteFilm(long id) {
        if (filmRepository.existsById(id)) {
            filmRepository.deleteById(id);
        } else {
            throw new FilmNotFoundException("Cannot delete. Film not found with id: " + id);
        }
    }

    public List<FilmSummary> getFilmSummaries() {
        List<FilmSummary> summaries = new ArrayList<>();
        for (Film film : filmRepository.findAll()) {
            summaries.add(filmMapper.toSummary(film));
        }
        return summaries;
    }
    @Autowired
    private ScreenRepository screenRepository;

    public List<ScreenResponseModel> getScreensByFilmId(Long filmId) {
        List<Screen> screens = screenRepository.findByFilm_Id(filmId);
        if (screens.isEmpty()) {
            throw new ScreenNotFoundException("No screens found for film with ID: " + filmId);
        }
        List<ScreenResponseModel> responses = new ArrayList<>();
        for (Screen screen : screens) {
            responses.add(filmMapper.toScreenResponse(screen));
        }
        return responses;
    }

}




