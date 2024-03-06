package id.ac.ui.cs.advprog.eshop.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PaymentTest {
    private List<Product> products;
    private List<Order> orders;


    @BeforeEach
    void setUp() {
        this.products = new ArrayList<Product>();

        this.products = new ArrayList<>();
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(2);

        Product product2 = new Product();
        product2.setProductId("a2c62328-4a37-4664-83c7-f32db8620155");
        product2.setProductName("Sabun Cap Usep");
        product2.setProductQuantity(1);

        this.products.add(product1);
        this.products.add(product2);

        this.orders = new ArrayList<Order>();
        Order order1 = new Order("13652556-012a-4c07-b546-54eb1396d79b", this.products, 1708560000L,
                "Safira Sudrajat");
        Order order2 = new Order("7f9e15bb-4b15-42f4-aebc-c3af385fb078", this.products, 1708570000L,
                "Safira Sudrajat");

        this.orders.add(order1);
        this.orders.add(order2);
    }

    @Test
    void testCreateVoucherCodePaymentDefaultStatus() {
        HashMap<String, String> paymentData = new HashMap<>();
        paymentData.put("voucherCode", "ESHOP12345678900");
        Payment payment = new Payment("testId", "voucherCode", paymentData);

        assertSame(this.orders, payment.getOrder());
    }

    @Test
    void testCreateVoucherCodePaymentSuccessStatus() {
        HashMap<String, String> paymentData = new HashMap<>();

    }

}
