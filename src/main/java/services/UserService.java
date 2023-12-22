package services;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import entities.User;
import exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import payload.NewUserDTO;
import repositories.UserRepository;
import java.io.IOException;

@Service

public class UserService {
    @Autowired
    private UserRepository utenteRepository;

    @Autowired
    private Cloudinary cloudinary;

    @Autowired
    private CloudinaryService cloudinaryService;

    public Page<User> findAll(int page, int size, String sortBy) {
        if (size < 0)
            size = 10;
        if (size > 100)
            size = 20;
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return utenteRepository.findAll(pageable);
    }


    public User findUtenteById(int id) throws NotFoundException {
        return utenteRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public User findByIdAndUpdate(int id, NewUserDTO u) throws NotFoundException {
        User foundUser = this.findUtenteById(id);
        foundUser.setId(id);
        foundUser.setUsername(u.username());
        foundUser.setNome(u.nome());
        foundUser.setCognome(u.cognome());
        foundUser.setEmail(u.email());
        return utenteRepository.save(foundUser);
    }

    public void findByIdAndDelete(int id) throws NotFoundException {
        User foundUtente = this.findUtenteById(id);
        if (!foundUtente.getAvatar().equals("https://ui-avatars.com/api/?name=" + foundUtente.getNome() + "+" + foundUtente.getCognome())) {
            cloudinaryService.deleteImageByUrl(foundUtente.getAvatar());
        }
        utenteRepository.delete(foundUtente);
    }

    public User findUtenteByEmail(String email) throws NotFoundException {
        return utenteRepository.findByEmail(email).orElseThrow(() -> new NotFoundException(email));
    }

    public void deleteAllUtenti() {
        utenteRepository.deleteAll();
    }

    public User uploadImg(MultipartFile file, int id) throws IOException {
        User u = utenteRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
        String url = (String) cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap()).get("url");
        if (!u.getAvatar().equals("https://ui-avatars.com/api/?name=" + u.getNome() + "+" + u.getCognome())) {
            cloudinaryService.deleteImageByUrl(u.getAvatar());
        }
        u.setAvatar(url);
        utenteRepository.save(u);
        return u;
    }
}
