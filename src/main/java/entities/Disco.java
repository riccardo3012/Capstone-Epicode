package entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Disco")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Disco extends Prodotto {
    @Id
    @Column(name = "nome_disco")
    private String nomeDisco;
    @Column(name = "prezzo_disco")
    private double prezzoDisco;

    }
