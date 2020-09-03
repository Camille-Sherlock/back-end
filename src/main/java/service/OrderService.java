package service;

import domain.Order;
import org.springframework.web.client.HttpServerErrorException;
import repository.GoodsRepository;
import fun.hercules.order.order.common.exceptions.InternalServerError;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.Future;

public class OrderService {
    private final GoodsRepository goodsRepository;
    private final Order order;
    private Order saveOrder(Order order){
        return goodsRepository.save(order);
    }
    public OrderService(GoodsRepository goodsRepository, Order order) {
        this.goodsRepository = goodsRepository;
        this.order = order;
    }

    public Future<String> addOrder(Order order){
        Integer orderId = Integer.valueOf(order.getId());
        if(!goodsRepository.existsById(orderId)){
            goodsRepository.save(order);
        }
    }

    public Optional<Order> getOrder(Order order){
        Optional<Order> goods = goodsRepository.findById(order.getId());
        return goods;
    }

}
