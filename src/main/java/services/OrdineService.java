package services;
import dto.OrderRequest;
import entities.Ordine;
import entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface OrdineService {

    Ordine getOrdine(Long ordineId);
    List<Ordine> getOrdering();
    Page<Ordine> getUserOrdersList(Pageable pageable);
    Long postOrder(User user, OrderRequest orderRequest);
}