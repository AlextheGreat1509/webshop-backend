package com.alex.webshop.repository.jpa;

import com.alex.webshop.models.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
