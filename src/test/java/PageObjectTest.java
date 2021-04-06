
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import page.BasePage;
import page.LoginPage;
import page.ProductsPage;


public class PageObjectTest extends BasePage {
    LoginPage loginPage;
    ProductsPage productsPage;


    public PageObjectTest() {
        super();
    }

    @Before
    public void init() {
        initialization();
        loginPage = new LoginPage();
        productsPage = new ProductsPage();

    }

    @Test
    @DisplayName("Test")
    public void pageTest() {
        LoginPage.login();
        ProductsPage.shopping();
    }


    @Test
    public void pageTestInfo() {
        LoginPage.login();
        ProductsPage.checkoutInfo();
    }

    @After
    public void close() {
        driver.quit();
    }
}
