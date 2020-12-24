package lang_market.backend.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProduct() {
        return productRepository.getAllProduct();
    }

    public Product getOneProduct(Integer id_product) {
        return productRepository.getOneProduct(id_product);
    }

    public List<Product> getProductByType(Integer product_type) {
        return  productRepository.getProductByType(product_type);
    }
}
