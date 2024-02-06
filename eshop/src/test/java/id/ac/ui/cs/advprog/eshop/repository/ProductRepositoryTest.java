package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public final class ProductRepositoryTest {

    @InjectMocks
    ProductRepository productRepository;
    @BeforeEach
    void setUp() {
    }

    @Test
    void testCreateAndFind() {
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        productRepository.create(product);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product.getProductId(), savedProduct.getProductId());
        assertEquals(product.getProductName(), savedProduct.getProductName());
        assertEquals(product.getProductQuantity(), savedProduct.getProductQuantity());
    }

    @Test
    void testFindAllIfEmpty() {
        Iterator<Product> productIterator = productRepository.findAll();
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testFindAllIfMoreThanOneProduct() {
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setProductId("a0f9de46-90b1-437d-a0bf-d0821dde9096");
        product2.setProductName("Sampo Cap Usep");
        product2.setProductQuantity(50);
        productRepository.create(product2);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product1.getProductId(), savedProduct.getProductId());
        savedProduct = productIterator.next();
        assertEquals(product2.getProductId(), savedProduct.getProductId());
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testEdit() {
        Product product = new Product();
        product.setProductId("1");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        productRepository.create(product);

        Product edited = new Product();
        edited.setProductId("1");
        edited.setProductName("Sampo Cap Usep");
        edited.setProductQuantity(50);

        productRepository.edit(product.getProductId(), edited);

        Iterator<Product> productIterator = productRepository.findAll();
        Product firstProduct = productIterator.next();
        assertEquals("1", firstProduct.getProductId());
        assertEquals("Sampo Cap Usep", firstProduct.getProductName());
        assertEquals(50, firstProduct.getProductQuantity());
    }

    @Test
    void testEditMultiple() {
        Product product1 = new Product();
        product1.setProductId("1");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setProductId("2");
        product2.setProductName("Sampo Cap Bango");
        product2.setProductQuantity(50);
        productRepository.create(product2);

        Product edited1 = new Product();
        edited1.setProductId("1");
        edited1.setProductName("Sampo Cap Usep");
        edited1.setProductQuantity(25);

        Product edited2 = new Product();
        edited2.setProductId("2");
        edited2.setProductName("Sampo Cap Usop");
        edited2.setProductQuantity(75);

        productRepository.edit(product1.getProductId(), edited1);
        productRepository.edit(product2.getProductId(), edited2);

        Iterator<Product> productIterator = productRepository.findAll();
        Product firstProduct = productIterator.next();
        assertEquals("1", firstProduct.getProductId());
        assertEquals("Sampo Cap Usep", firstProduct.getProductName());
        assertEquals(25, firstProduct.getProductQuantity());

        Product secondProduct = productIterator.next();
        assertEquals("2", secondProduct.getProductId());
        assertEquals("Sampo Cap Usop", secondProduct.getProductName());
        assertEquals(75, secondProduct.getProductQuantity());
    }
    @Test
    void testDelete() {
        Product product = new Product();
        product.setProductId("1");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        productRepository.create(product);
        productRepository.delete(product.getProductId());

        Iterator<Product> productIterator = productRepository.findAll();
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testDeleteMultiple() {
        Product product1 = new Product();
        product1.setProductId("1");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setProductId("2");
        product2.setProductName("Sampo Cap Bango");
        product2.setProductQuantity(50);
        productRepository.create(product2);

        Iterator<Product> productIterator = productRepository.findAll();
        Product firstProduct = productIterator.next();

        productRepository.delete(product1.getProductId());
        assertFalse(productIterator.hasNext());

        productRepository.delete(product2.getProductId());
        productIterator = productRepository.findAll();
        assertFalse(productIterator.hasNext());
    }
}
