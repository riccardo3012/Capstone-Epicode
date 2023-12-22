package controllers;
import entities.User;
import exceptions.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import payload.NewUserDTO;
import payload.UserLoginDTO;
import payload.UtenteLoginSuccessDTO;
import services.AuthService;
import java.io.IOException;


@RestController
@RequestMapping("/auth")

public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public User saveUser(@RequestBody @Validated NewUserDTO body, BindingResult validation) {
        if (validation.hasErrors()) {
            throw new BadRequestException(validation.getAllErrors());
        } else {
            try {
                return authService.saveUser(body);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @PostMapping("/login")
    public UtenteLoginSuccessDTO login(@RequestBody UserLoginDTO body) {
        return new UtenteLoginSuccessDTO(authService.authenticateUser(body));
    }
}
