package repository;

import domain.*;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface goodsRepository extends CrudRepository<Order, Integer> {
List<Order> findAll();
Order findById();
}