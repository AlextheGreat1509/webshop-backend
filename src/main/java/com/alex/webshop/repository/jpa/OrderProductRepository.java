package com.alex.webshop.repository.jpa;

import com.alex.webshop.models.OrderProduct;
import com.alex.webshop.models.OrderProductPK;
import org.springframework.data.repository.CrudRepository;

public interface OrderProductRepository extends CrudRepository<OrderProduct, OrderProductPK> {
}
