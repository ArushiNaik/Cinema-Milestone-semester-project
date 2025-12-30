package org.example.cinemamilestone.PresentationLayer;

import jakarta.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FilmRequestModel {

    @NotBlank(message = "Film name is required.")
    @Size(min = 2, max = 100, message = "Film name must be between 2 and 100 characters.")
    private String filmName;

    @NotBlank(message = "Film genre is required.")
    private String filmGenre;

    @Positive(message = "Film duration must be a positive number.")
    private int filmDuration;

    @NotBlank(message = "Film language cannot be blank.")
    private String filmLanguage;

    @DecimalMin(value = "0.0", inclusive = false, message = "Film rating must be greater than 0.")
    @DecimalMax(value = "10.0", message = "Film rating cannot exceed 10.")
    private double filmRating;

    @NotBlank(message = "Film description is required.")
    @Size(max = 500, message = "Film description cannot exceed 500 characters.")
    private String filmDescription;
}


