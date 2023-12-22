package controllers;
import entities.Diary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.DiaryService;
import java.util.List;

@RestController
@RequestMapping("/diaries")
public class DiaryController {

    private final DiaryService diaryService;

    @Autowired
    public DiaryController(DiaryService diaryService) {
        this.diaryService = diaryService;
    }

    @GetMapping
    public ResponseEntity<List<Diary>> getAllPosts() {
        List<Diary> diaries = diaryService.getAllPosts();
        return new ResponseEntity<>(diaries, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Diary> getPostById(@PathVariable Long id) {
        Diary diary = diaryService.getPostById(id);
        return new ResponseEntity<>(diary, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Diary> createPost(@RequestBody Diary diary) {
        Diary createdDiary = diaryService.createPost(diary);
        return new ResponseEntity<>(createdDiary, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        diaryService.deletePost(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
