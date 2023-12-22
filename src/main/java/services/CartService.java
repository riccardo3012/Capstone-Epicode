package services;
import entities.Prodotto;
import java.util.List;


public interface CartService {

    List<Prodotto> getPerfumesInCart();

    void addProdottoToCart(Long perfumeId);
    void removeProdottoFromCart(Long perfumeId);
}