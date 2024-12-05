package co.edu.unihumboldt.parcial_iii.controller;

import co.edu.unihumboldt.parcial_iii.domain.Product;
import co.edu.unihumboldt.parcial_iii.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.findAll();
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product createdProduct = productService.save(product);
        return ResponseEntity.ok(createdProduct);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody Product product) {
        product.setId(id);
        Product updatedProduct = productService.update(product);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable int id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/adjust-quantity")
    public ResponseEntity<Product> adjustProductQuantity(@PathVariable int id, @RequestParam int quantityChange) {
        Product product = productService.findById(id);
        int newQuantity = product.getQuantity() + quantityChange;
        product.setQuantity(newQuantity);

        if (quantityChange > 0) {
            System.out.println("Added " + quantityChange + " to product ID " + id);
        } else {
            System.out.println("Removed " + Math.abs(quantityChange) + " from product ID " + id);
        }

        Product updatedProduct = productService.update(product);
        return ResponseEntity.ok(updatedProduct);
    }
    public ResponseEntity<Product> registerSale(@PathVariable int id, @RequestParam String saleDate) {
        LocalDateTime date = LocalDateTime.parse(saleDate);
        Product updatedProduct = productService.registerSale(id, date);
        return ResponseEntity.ok(updatedProduct);
    }
}
