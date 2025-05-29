package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

@Epic("E-Commerce Site")
@Feature("Shopping Cart")
public class AddToCartTest {

    WebDriver driver;

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new", "--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Add a product to the cart and verify it appears")
    @DisplayName("Add to Cart Test")
    public void testAddToCart() {
        driver.findElement(By.className("btn_inventory")).click();
        driver.findElement(By.className("shopping_cart_link")).click();
        Assertions.assertTrue(driver.findElements(By.className("cart_item")).size() > 0);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
