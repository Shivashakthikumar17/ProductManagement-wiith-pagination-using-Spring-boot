package com.crud.page.Repository;

import com.crud.page.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ProductRepo extends JpaRepository<Product,Integer> {
}
