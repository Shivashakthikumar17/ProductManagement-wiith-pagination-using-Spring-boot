package com.crud.page.Service;

import com.crud.page.Repository.ProductRepo;
import com.crud.page.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductSevice {
    @Autowired
    private ProductRepo productRepo;

    public Product addProduct(Product product) {
        return productRepo.save(product);
    }

    public List<Product> getProduct() {
        return productRepo.findAll();
    }

    public Product updateProduct(Product product) {
        Product product1 = new Product();
        product1.setProductNumber(product.getProductNumber());
        product1.setProductName(product.getProductName());
        product1.setYearOfManufacture(product.getYearOfManufacture());
        return productRepo.save(product1);
    }

    public Product deleteProduct(int id) {
        productRepo.deleteById(id);
        return null;

    }

    public Page<Product> getProduct(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo,pageSize);
        return productRepo.findAll(pageable);
    }
}
