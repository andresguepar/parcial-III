package co.edu.unihumboldt.parcial_iii.repositories;

import co.edu.unihumboldt.parcial_iii.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
