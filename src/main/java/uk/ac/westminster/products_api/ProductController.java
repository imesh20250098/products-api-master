package uk.ac.westminster.products_api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable("id") Long id) {
        return productService.getProductById(id);
    }

    @PostMapping("/products")
    public Product addProduct(
            @RequestBody DigitalProduct product) {

        // Product is abstract, so use DigitalProduct for this lab.
        return productService.addProduct(product);
    }

    @GetMapping("/products/summaries")
    public List<String> getSummaries() {
        return productService.getAllSummaries();
    }
}


