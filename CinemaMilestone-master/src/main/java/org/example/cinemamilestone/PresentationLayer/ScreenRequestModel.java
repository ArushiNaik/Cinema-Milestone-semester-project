package org.example.cinemamilestone.PresentationLayer;

import jakarta.validation.constraints.*;
import lombok.*;
import org.example.cinemamilestone.DataAccessLayer.Film;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class ScreenRequestModel {

    @Positive(message = "Screen number must be positive.")
    private int screenNum;

    @PositiveOrZero(message = "Chosen seats cannot be negative.")
    private int chosenSeats;

    @NotBlank(message = "Screen type is required.")
    private String screenType;

    @FutureOrPresent(message = "Screen date must be today or in the future.")
    private LocalDate screenDate;

    @NotNull(message = "A film must be assigned to the screen.")
    private Film chosenFilm;
}
