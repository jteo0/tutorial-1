package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> productData = new ArrayList<>();
    private long currentId = 0;

    public Product create(Product product) {
        productData.add(product);
        product.setProductId(Long.toString(currentId));
        currentId++;
        return product;
    }

    public Iterator<Product> findAll() {
        return productData.iterator();
    }

    public Product edit(Product product) {
        for (Product currentProduct : productData) {
            if (currentProduct.getProductId().equals(product.getProductId())) {
                productData.set(productData.indexOf(currentProduct), product);
                return product;
            }
        }
        return null;
    }

    public Product findProductById(String productId){
        for (Product product : productData){
            if (product.getProductId().equals(productId)){
                return product;
            }
        }
        return null;
    }

    public void delete(String productId) {
        Product product = findProductById(productId);
        productData.remove(product);
    }
}
