package entities;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Data
@Entity
@Table(name = "ordini")

public class Ordine {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orders_seq")
    @SequenceGenerator(name = "orders_seq", sequenceName = "orders_seq", initialValue = 6, allocationSize = 1)
    private Long id;
    @Column(name = "total_price", nullable = false)
    private Double prezzoTotale;
    @Column(name = "date", columnDefinition = "timestamp default current_timestamp")
    private LocalDateTime dataOrdine = LocalDateTime.now();
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "city", nullable = false)
    private String citta;
    @Column(name = "address", nullable = false)
    private String indirizzo;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "phone_number", nullable = false)
    private String numeroCellulare;

    @ManyToMany
    private List<Prodotto> prodotto = new ArrayList<>();
    @ManyToOne
    private User user;
}
