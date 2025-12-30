package org.example.cinemamilestone.MapLayer;

import org.example.cinemamilestone.DataAccessLayer.Film;
import org.example.cinemamilestone.DataAccessLayer.Screen;
import org.example.cinemamilestone.PresentationLayer.FilmRequestModel;
import org.example.cinemamilestone.PresentationLayer.FilmResponseModel;
import org.example.cinemamilestone.PresentationLayer.FilmSummary;
import org.example.cinemamilestone.PresentationLayer.ScreenResponseModel;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneId;

@Component
public class FilmMapper {

    public FilmResponseModel toResponseModel(Film film) {
        return new FilmResponseModel(
                film.getId(),
                film.getTitle(),
                film.getGenre(),
                film.getDurationMinutes(),
                film.getLanguage(),
                String.valueOf(film.getFilmRating()), // Convert double to string
                film.getFilmDescription()
        );
    }

    public Film toEntity(FilmRequestModel requestModel) {
        Film film = new Film();
        film.setTitle(requestModel.getFilmName());
        film.setGenre(requestModel.getFilmGenre());
        film.setDurationMinutes(requestModel.getFilmDuration());
        film.setLanguage(requestModel.getFilmLanguage());
        film.setFilmRating(requestModel.getFilmRating());
        film.setFilmDescription(requestModel.getFilmDescription());
        return film;
    }

    public FilmSummary toSummary(Film film) {
        return new FilmSummary(
                film.getId(),
                film.getTitle(),
                film.getGenre(),
                film.getFilmRating()
        );
    }

    public ScreenResponseModel toScreenResponse(Screen screen) {
        if (screen == null) return null;

        LocalDate localDate = null;
        if (screen.getScreenDate() != null) {
            localDate = screen.getScreenDate()
                    .toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();
        }

        // Use Film entity directly
        Film filmAvailable = screen.getFilm(); // can be null

        return new ScreenResponseModel(
                screen.getId(),
                screen.getScreenNum(),
                screen.getAvailableSeats(),
                screen.getScreenType(),
                localDate,
                screen.getScreenDescription(),
                filmAvailable
        );
    }

}
