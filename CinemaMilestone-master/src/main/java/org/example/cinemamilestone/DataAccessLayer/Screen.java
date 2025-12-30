package org.example.cinemamilestone.DataAccessLayer;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Screen {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="screen_number")
    private int screenNum;
    private int availableSeats;
    private String screenType;
    private Date screenDate;
    private String screenDescription;
    @OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="fk_filmid")
    private Film film;

    public Screen(int availableSeats, String screenType, int screenNum, LocalDate screenDate, String screenDescription, Film film) {
        this.availableSeats = availableSeats;
        this.screenType = screenType;
        this.screenNum = screenNum;
        this.screenDate = Date.from(screenDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        this.screenDescription = screenDescription;
        this.film = film;
    }

}
