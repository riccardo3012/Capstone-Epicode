package entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Poster")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Poster extends Prodotto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomePoster;
    @Column(name = "contenuto_post")
    private double prezzoPoster;

}
