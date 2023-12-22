package controllers;
import entities.Ordine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.OrdineService;


@RestController
@RequestMapping("/orders")

public class OrderController {

    @Autowired
    private OrdineService ordineService;

    @GetMapping("/{orderId}")
    public ResponseEntity<Ordine> getOrdine(@PathVariable Long orderId) {
        Ordine ordine = ordineService.getOrdine(orderId);
        return new ResponseEntity<>(ordine, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<Ordine>> getUserOrdersList(Pageable pageable) {
        Page<Ordine> userOrders = ordineService.getUserOrdersList(pageable);
        return new ResponseEntity<>(userOrders, HttpStatus.OK);
    }


}

