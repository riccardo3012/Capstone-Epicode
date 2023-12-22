package services;
import entities.Poster;
import exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repositories.PosterRepository;
import java.util.List;

@Service
public class PosterService {

    @Autowired
    private PosterRepository posterRepository;


    public List<Poster> getAll() {
        return posterRepository.findAll();
    }

    public Poster findPosterById(long id) throws NotFoundException {
        return posterRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }
}
