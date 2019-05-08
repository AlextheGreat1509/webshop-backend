package com.alex.webshop.repository.jpa;

import com.alex.webshop.models.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
