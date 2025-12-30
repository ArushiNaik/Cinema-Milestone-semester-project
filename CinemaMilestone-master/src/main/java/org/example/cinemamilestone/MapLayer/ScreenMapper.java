package org.example.cinemamilestone.MapLayer;

import org.example.cinemamilestone.DataAccessLayer.Film;
import org.example.cinemamilestone.DataAccessLayer.Screen;
import org.example.cinemamilestone.PresentationLayer.FilmSummary;
import org.example.cinemamilestone.PresentationLayer.ScreenRequestModel;
import org.example.cinemamilestone.PresentationLayer.ScreenResponseModel;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Component
public class ScreenMapper {
    public ScreenResponseModel toResponse(Screen screen) {
        if (screen == null) {
            return null;
        }
        Film film = screen.getFilm();
        // Convert java.util.Date to LocalDate
        Date screenDate = screen.getScreenDate();
        LocalDate localDate = null;
        if (screenDate != null) {
            localDate = screenDate.toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();
        }

        return new ScreenResponseModel(
                screen.getId(),
                screen.getScreenNum(),
                screen.getAvailableSeats(),
                screen.getScreenType(),
                localDate,
                screen.getScreenDescription(),
                film
        );
    }

    public Screen toEntity(ScreenRequestModel screenRequestModel) {
        if(screenRequestModel == null){
            return null;
        }
        Screen screen = new Screen();
        screen.setScreenNum(screenRequestModel.getScreenNum());
        screen.setAvailableSeats(screenRequestModel.getChosenSeats());
        screen.setScreenType(screenRequestModel.getScreenType());
        // Convert LocalDate to Date
        LocalDate screenDate = screenRequestModel.getScreenDate();
        if (screenDate != null) {
            Date utilDate = Date.from(screenDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
            screen.setScreenDate(utilDate);
        }
        screen.setFilm(screenRequestModel.getChosenFilm());
        return screen;

    }

}
