package payload;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

public record UserLoginDTO(
        @NotEmpty(message = "Il campo email non può essere vuoto")
        @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Email non valida")
        String email,
        @NotEmpty(message = "Il campo password non può essere vuoto")
        String password
) {
}

