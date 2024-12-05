package co.edu.unihumboldt.parcial_iii.services;

import co.edu.unihumboldt.parcial_iii.domain.Product;

import java.time.LocalDateTime; // Import LocalDateTime
import java.util.List;

public interface ProductService {
    Product findById(int id);
    List<Product> findAll();
    Product save(Product product);
    Product update(Product product);
    void delete(int id);
    Product registerSale(int id, LocalDateTime saleDate);
}
