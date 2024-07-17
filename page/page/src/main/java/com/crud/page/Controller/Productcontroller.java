package com.crud.page.Controller;

import com.crud.page.Service.ProductSevice;
import com.crud.page.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Productcontroller {
    @Autowired
     private ProductSevice productSevice;

    @PostMapping(value="/addProduct")
    public Product addProduct(@RequestBody Product product){
        return productSevice.addProduct(product);
    }
    @GetMapping(value = "/getProducts")
    public List<Product> getProduct(){
        return productSevice.getProduct();
    }
    @PatchMapping(value = "/update")
    public Product updateProduct(@RequestBody Product product){
        return productSevice.updateProduct(product);
    }
    @DeleteMapping(value = "/deleteProduct")
    public Product deleteProduct(@PathVariable int id){
        return productSevice.deleteProduct(id);
    }
    @GetMapping(value="/getProductsBySize")
    public ResponseEntity<Page<Product>> getProductss(
            @RequestParam (defaultValue = "0")int pageNo,
            @RequestParam(defaultValue = "10")int pageSize){
        Page<Product> pageproduct = productSevice.getProduct(pageNo,pageSize);
        return ResponseEntity.ok(pageproduct);
    }
}
