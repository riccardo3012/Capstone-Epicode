package repositories;
import entities.Poster;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PosterRepository extends JpaRepository<Poster, Long> {

    List<Poster> findPosterById(long id);
}