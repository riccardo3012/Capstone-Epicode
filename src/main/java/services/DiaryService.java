package services;
import entities.Diary;
import exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import repositories.DiaryRepository;
import java.util.List;

@Service
public class DiaryService {

    private final DiaryRepository diaryRepository;

    @Autowired
    public DiaryService(DiaryRepository diaryRepository) {
        this.diaryRepository = diaryRepository;
    }

    public List<Diary> getAllPosts() {
        return diaryRepository.findAll();
    }

    public Diary getPostById(Long id) {
        return diaryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Post not found"));
    }

    @PreAuthorize("hasRole('ADMIN')")
    public Diary createPost(Diary diary) {
        // creazione del post
        return diaryRepository.save(diary);
    }

    @PreAuthorize("hasRole('ADMIN')")
    public void deletePost(Long id) {
        //  per l'eliminazione del post
        diaryRepository.deleteById(id);
    }

}
