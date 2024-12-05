package co.edu.unihumboldt.parcial_iii;

import co.edu.unihumboldt.parcial_iii.domain.Product;
import co.edu.unihumboldt.parcial_iii.repositories.ProductRepository;
import co.edu.unihumboldt.parcial_iii.services.impl.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class UnitTest {

    @InjectMocks
    private ProductServiceImpl productService;

    @Mock
    private ProductRepository productRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Product 1", "10.00", 100, null));
        when(productRepository.findAll()).thenReturn(products);

        List<Product> result = productService.findAll();
        assertEquals(1, result.size());
        assertEquals("Product 1", result.get(0).getName());
    }

    @Test
    public void testSave() {
        Product product = new Product(1, "Product 1", "10.00", 100, null);
        when(productRepository.save(any(Product.class))).thenReturn(product);

        Product result = productService.save(product);
        assertEquals("Product 1", result.getName());
    }

    @Test
    public void testUpdate() {
        Product product = new Product(1, "Product 1", "10.00", 100, null);
        when(productRepository.save(any(Product.class))).thenReturn(product);

        Product result = productService.update(product);
        assertEquals("Product 1", result.getName());
    }

    @Test
    public void testDelete() {
        doNothing().when(productRepository).deleteById(1);
        productService.delete(1);
        verify(productRepository, times(1)).deleteById(1);
    }

    @Test
    public void testRegisterSale() {
        Product product = new Product(1, "Product 1", "10.00", 100, null);
        when(productRepository.findById(1)).thenReturn(java.util.Optional.of(product));
        when(productRepository.save(any(Product.class))).thenReturn(product);

        Product result = productService.registerSale(1, LocalDateTime.now());
        assertNotNull(result.getSaleDate());
    }
}
