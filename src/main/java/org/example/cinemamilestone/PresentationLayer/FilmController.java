package org.example.cinemamilestone.PresentationLayer;

import jakarta.validation.Valid;
import org.example.cinemamilestone.BusinessLayer.FilmService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/film")
public class FilmController {

    private final FilmService filmService;

    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    // Get all films
    @GetMapping
    public ResponseEntity<List<FilmResponseModel>> getAllFilms() {
        return ResponseEntity.ok(filmService.getAllFilms());
    }

    // Get film by ID using path variable
    @GetMapping("/{id}")
    public ResponseEntity<FilmResponseModel> getFilmById(@PathVariable String id) {
        return ResponseEntity.ok(filmService.getFilmById(id));
    }

    // Get film summaries
    @GetMapping("/summaries")
    public ResponseEntity<List<FilmSummary>> getFilmSummaries() {
        return ResponseEntity.ok(filmService.getFilmSummaries());
    }

    @PostMapping
    public ResponseEntity<FilmResponseModel> addFilm(@Valid @RequestBody FilmRequestModel filmRequestModel) {
        FilmResponseModel filmResponseModel = this.filmService.addFilm(filmRequestModel);

        return ResponseEntity
                .created(URI.create("/film/" + filmResponseModel.getId()))
                .body(filmResponseModel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FilmResponseModel> updateFilm(@PathVariable long id, @Valid @RequestBody FilmRequestModel filmRequestModel) {
        FilmResponseModel filmResponseModel = this.filmService.updateFilm(id, filmRequestModel);
        return ResponseEntity.ok(filmResponseModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFilm(@PathVariable long id) {
        this.filmService.deleteFilm(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{id}/screens")
    public ResponseEntity<List<ScreenResponseModel>> getScreensByFilm(@PathVariable Long id) {
        return ResponseEntity.ok(filmService.getScreensByFilmId(id));
    }

}

