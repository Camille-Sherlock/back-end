package api;

import domain.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import repository.GoodsRepository;
import service.OrderService;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@RestController
public class OrderController {
    private final OrderService orderService;
    private static final Integer OutOfAddOrderTime = 20;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/order")
    public ResponseEntity addOrder(Order order) throws InterruptedException, ExecutionException, TimeoutException {
        Future<String> newOrder = orderService.addOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("goods",newOrder.get(OutOfAddOrderTime, TimeUnit.SECONDS))
                .body(null);
    }
}
