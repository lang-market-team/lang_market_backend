package lang_market.backend.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/product")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProduct() {
        return productService.getAllProduct();
    }

    @RequestMapping(path = "id/{id_product}")
    public Product getOneProduct(@PathVariable("id_product") Integer id_product) {
        return productService.getOneProduct(id_product);
    }

    @RequestMapping(path = "type/{product_type}")
    public List<Product> getProductByType(@PathVariable("product_type")Integer product_type) {
        return  productService.getProductByType(product_type);
    }
}
