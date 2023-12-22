package dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import utils.ErrorMessage;
import java.time.LocalDateTime;

@Data
public class OrderRequest {

    private Long id;
    private Double totalPrice;
    private LocalDateTime date = LocalDateTime.now();

    @NotBlank(message = ErrorMessage.FILL_IN_THE_INPUT_FIELD)
    private String firstName;
    @NotBlank(message = ErrorMessage.FILL_IN_THE_INPUT_FIELD)
    private String lastName;
    @NotBlank(message = ErrorMessage.FILL_IN_THE_INPUT_FIELD)
    private String citta;
    @NotBlank(message = ErrorMessage.FILL_IN_THE_INPUT_FIELD)
    private String indirizzo;
    @Email(message = ErrorMessage.INCORRECT_EMAIL)
    @NotBlank(message = ErrorMessage.EMAIL_CANNOT_BE_EMPTY)
    private String email;
    @NotBlank(message = ErrorMessage.EMPTY_PHONE_NUMBER)
    private String numeroCellulare;

}