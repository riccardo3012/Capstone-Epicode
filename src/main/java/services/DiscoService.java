package services;
import entities.Disco;
import exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.DiscoRepository;
import java.util.List;

@Service
public class DiscoService {

@Autowired
private DiscoRepository discoRepository;


    public List<Disco> getAll() {
        return discoRepository.findAll();
    }

    public Disco findDiscoById(int id) throws NotFoundException {
        return discoRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }
}
