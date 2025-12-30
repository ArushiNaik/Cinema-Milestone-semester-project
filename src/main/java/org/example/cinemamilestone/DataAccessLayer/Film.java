package org.example.cinemamilestone.DataAccessLayer;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String title;
    private String genre;
    private String director;
    private String language;
    private int durationMinutes;
    private double filmRating; // Added this
    private String releaseDate;
    private String filmDescription;

    public Film(String title, String genre, String director, String language, int durationMinutes,
                double filmRating, String releaseDate, String filmDescription) {
        this.title = title;
        this.genre = genre;
        this.director = director;
        this.language = language;
        this.durationMinutes = durationMinutes;
        this.filmRating = filmRating;
        this.releaseDate = releaseDate;
        this.filmDescription = filmDescription;
    }
    public Film(String title){
        this.title = title;
    }
}

