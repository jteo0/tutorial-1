package id.ac.ui.cs.advprog.eshop.functional;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@ExtendWith(SeleniumJupiter.class)
class CreateProductFunctionalTest {

    @LocalServerPort
    private int serverPort;

    @Value("${app.baseUrl:http://localhost}")
    private String testBaseUrl;

    private String baseUrl;

    @BeforeEach
    void setupTest() {
        baseUrl = String.format("%s:%d", testBaseUrl, serverPort) + "/product/list";
    }

    @Test
    void createProduct_isCorrect(ChromeDriver driver) throws Exception {
        driver.get(baseUrl);

        driver.findElement(By.linkText("Create Product")).click();

        driver.findElement(By.id("inputName")).sendKeys("test");
        driver.findElement(By.id("inputQuantity")).sendKeys("0");

        driver.findElement(By.id("submitCreate")).click();

        String productName = driver.findElement(By.id("productName")).getText();
        assertEquals("test", productName);
        String productQuantity = driver.findElement(By.id("productQuantity")).getText();
        assertEquals("0", productQuantity);
    }
}