package payload;


import jakarta.validation.constraints.NotEmpty;

public record UtenteLoginSuccessDTO(
        @NotEmpty
        String accessToken
) {
}
