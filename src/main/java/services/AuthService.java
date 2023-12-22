package services;
import configuration.EmailSender;
import entities.User;
import exceptions.BadRequestException;
import exceptions.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import payload.NewUserDTO;
import payload.UserLoginDTO;
import repositories.UserRepository;
import security.JWTTools;
import utils.UserType;
import java.io.IOException;

@Service
public class AuthService {
    @Autowired
    PasswordEncoder bcrypt;
    @Autowired
    UserRepository userRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private JWTTools jwtTools;
    @Autowired
    EmailSender emailSender;

    public String authenticateUser(UserLoginDTO body) {
        User user = userService.findUtenteByEmail(body.email());
        if (bcrypt.matches(body.password(), user.getPassword())) {
            return jwtTools.createToken(user);

        } else {
            throw new UnauthorizedException("Invalid credentials");
        }
    }

    public User saveUser(NewUserDTO body) throws IOException {

        userRepository.findByEmail(body.email()).ifPresent(user -> {
            throw new BadRequestException("L'email " + user.getEmail() + " é giá stata utilizzata!");
        });

        User newUser = new User();
        newUser.setAvatar("https://ui-avatars.com/api/?name=" + body.nome() + "+" + body.cognome());
        newUser.setUsername(body.username());
        newUser.setNome(body.nome());
        newUser.setCognome(body.cognome());
        newUser.setRuolo(UserType.USER);
        newUser.setEmail(body.email());
        newUser.setPassword(bcrypt.encode(body.password()));
        User savedUser = userRepository.save(newUser);
        emailSender.sendRegistrationEmail(body.email());

        return savedUser;
    }
}

