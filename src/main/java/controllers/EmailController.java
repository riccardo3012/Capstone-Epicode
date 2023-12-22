package controllers;
import configuration.EmailSender;
import entities.User;
import exceptions.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import payload.NewEmailDTO;
import java.io.IOException;

public class EmailController {
    @Autowired
    EmailSender emailSender;

    @PostMapping("/send")
    @PreAuthorize("hasAuthority('ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    public void sendEmail(@RequestBody @Validated NewEmailDTO body, @AuthenticationPrincipal User currentUser, BindingResult validation) {
        if (validation.hasErrors()) {
            throw new BadRequestException(validation.getAllErrors());
        } else {
            try {
                emailSender.sendEmail(body, currentUser);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

