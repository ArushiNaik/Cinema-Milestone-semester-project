package org.example.cinemamilestone.PresentationLayer;
import jakarta.validation.Valid;
import org.example.cinemamilestone.BusinessLayer.ScreenService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/screening")
public class ScreenController {
    private final ScreenService screenService;
    public ScreenController(ScreenService screenService) {
        this.screenService = screenService;
    }
    @GetMapping
    public ResponseEntity<List<ScreenResponseModel>> getAllScreens() {
        List<ScreenResponseModel> screens = this.screenService.getScreen();
        return ResponseEntity.ok(screens);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScreenResponseModel> getScreenById(@PathVariable String id) {
        ScreenResponseModel screenResponseModel = this.screenService.getScreenById(id);
        return ResponseEntity.ok(screenResponseModel);
    }

    @PostMapping
    public ResponseEntity<ScreenResponseModel> createScreen(@Valid @RequestBody ScreenRequestModel screenRequestModel) {
        ScreenResponseModel savedScreen = this.screenService.createScreen(screenRequestModel);
        return ResponseEntity.created(URI.create("/screening/" +savedScreen.getId())).body(savedScreen);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ScreenResponseModel> updateScreen(@PathVariable String id, @Valid @RequestBody ScreenRequestModel screenRequestModel) {
        ScreenResponseModel savedScreen = this.screenService.updateScreen(id, screenRequestModel);
        return ResponseEntity.ok(savedScreen);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deleteScreen(@PathVariable String id) {
        this.screenService.deleteScreen(id);
        return ResponseEntity.noContent().build(); //204 no content
    }
    @GetMapping("/{id}/film")
    public ResponseEntity<FilmResponseModel> getFilmByScreen(@PathVariable Long id) {
        return ResponseEntity.ok(screenService.getFilmByScreenId(id));
    }


}
