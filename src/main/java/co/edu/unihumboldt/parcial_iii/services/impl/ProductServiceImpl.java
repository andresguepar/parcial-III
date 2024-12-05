package co.edu.unihumboldt.parcial_iii.services.impl;

import co.edu.unihumboldt.parcial_iii.domain.Product;
import co.edu.unihumboldt.parcial_iii.repositories.ProductRepository;
import co.edu.unihumboldt.parcial_iii.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product update(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void delete(int id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Override
    public Product registerSale(int id, LocalDateTime saleDate) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        product.setSaleDate(saleDate);
        return productRepository.save(product);
    }
}
