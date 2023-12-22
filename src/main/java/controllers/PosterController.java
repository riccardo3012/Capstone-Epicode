package controllers;
import entities.Poster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.PosterService;

import java.util.List;

@RestController
@RequestMapping("/poster")
public class PosterController {

    @Autowired
    private PosterService posterService;

    @GetMapping("/getall")
    public List<Poster> getAll() {
        return posterService.getAll();
    }

    @GetMapping("/{id}")
    public Poster findPosterById(@PathVariable long id) {
        return posterService.findPosterById(id);
    }
}
