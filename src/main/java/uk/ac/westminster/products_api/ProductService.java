package uk.ac.westminster.products_api;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final List<Product> products = new ArrayList<>();

    public ProductService() {

        products.add(
                new DigitalProduct(
                        1L,
                        "E-book",
                        9.99,
                        "/dl/1",
                        4.2
                )
        );

        products.add(
                new PhysicalProduct(
                        2L,
                        "Mug",
                        8.50,
                        0.35,
                        "10 x 8 x 8 cm"
                )
        );
    }

    // Return all products.
    public List<Product> getAllProducts() {
        return products;
    }

    // Find a product using its ID.
    public Product getProductById(Long id) {

        for (Product product : products) {
            if (product.getId().equals(id)) {
                return product;
            }
        }

        return null;
    }

    // Add a new product.
    public Product addProduct(Product product) {
        products.add(product);
        return product;
    }

    // Return the summary of every product.
    public List<String> getAllSummaries() {

        List<String> summaries = new ArrayList<>();

        for (Product p : products) {
            summaries.add(p.getSummary());
        }

        return summaries;
    }
}