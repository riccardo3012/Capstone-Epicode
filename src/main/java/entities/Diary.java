package entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;


@Entity
@Table(name = "Diary")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class Diary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
private String titoloPost;
    @Column(name = "contenuto_post")
private String  contenutoPost;
    @Column(name = "dataPubblicazione")
private LocalDate dataPubblicazione;


}
