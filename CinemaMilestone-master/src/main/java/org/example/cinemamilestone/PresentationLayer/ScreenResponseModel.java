package org.example.cinemamilestone.PresentationLayer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.cinemamilestone.DataAccessLayer.Film;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ScreenResponseModel { //what we send back to the client
    private Long id;
    private int screenNum;
    private int availableSeats;
    private String screenType;
    private LocalDate screenDate;
    private String screenDescription;
    private Film filmAvailable;
}
