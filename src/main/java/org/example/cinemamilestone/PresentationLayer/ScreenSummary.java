package org.example.cinemamilestone.PresentationLayer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.cinemamilestone.DataAccessLayer.Film;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ScreenSummary { //what the client will see (if this class is used)
    private int screenNum;
    private int availableSeats;
    private String screenType;
    private String screenDate;
    private String screenDescription;
    private Film filmAvailable;
}
