package org.example.cinemamilestone.DataAccessLayer;

import org.example.cinemamilestone.DataAccessLayer.Screen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScreenRepository extends JpaRepository<Screen, Long> {
    List<Screen> findByFilm_Id(Long filmId);
}

