package org.example.cinemamilestone.PresentationLayer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FilmResponseModel {
    private long id;
    private String filmName;
    private String filmGenre;
    private int filmDuration; // in minutes
    private String filmLanguage;
    private String filmRating; // e.g. PG-13, R
    private String filmDescription;
}
