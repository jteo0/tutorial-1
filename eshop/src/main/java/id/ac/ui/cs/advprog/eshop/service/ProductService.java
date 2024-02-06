package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import java.util.List;

public interface ProductService {
    public Product create(Product product);
    public List<Product> findAll();
<<<<<<< HEAD
=======
    public void setId(String productId);
    public void edit(Product edited);
    public Product findProductById(String productId);
    public void delete(String productId);
>>>>>>> 03f26d1d8e91b6180591855bdd6299ed0753aff0
}