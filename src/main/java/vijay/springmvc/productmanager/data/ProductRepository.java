package vijay.springmvc.productmanager.data;

import org.springframework.data.jpa.repository.JpaRepository;
import vijay.springmvc.productmanager.model.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
