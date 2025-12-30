package org.example.cinemamilestone.PresentationLayer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FilmSummary {
    private long id;
    private String filmName;
    private String filmGenre;
    private double filmRating;
}

