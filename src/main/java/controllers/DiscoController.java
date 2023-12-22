package controllers;
import entities.Disco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.DiscoService;
import java.util.List;

@RestController
@RequestMapping("/disco")

public class DiscoController {
    @Autowired
private DiscoService discoService;

    @GetMapping("/getall")
    public List<Disco> getAll(){
        return discoService.getAll();
    }

    @GetMapping("/{id}")
    public Disco findDiscoById(@PathVariable int id) {
        return discoService.findDiscoById(id);
    }


}
