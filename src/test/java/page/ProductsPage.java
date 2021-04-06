package page;

import lombok.extern.java.Log;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;

@Log
public class ProductsPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-backpack\"]")
    static WebElement productOne;

    @FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-onesie\"]")
    static WebElement productTwo;

    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a/span")
    static WebElement cartBadge;

    @FindBy(xpath = "//*[@id=\"checkout\"]")
    static WebElement checkout;

    @FindBy(xpath = "//*[@id=\"first-name\"]")
    static WebElement firstName;

    @FindBy(xpath = "//*[@id=\"last-name\"]")
    static WebElement lastName;

    @FindBy(xpath = "//*[@id=\"postal-code\"]")
    static WebElement postCode;

    @FindBy(xpath = "//*[@id=\"continue\"]")
    static WebElement continueOrder;

    @FindBy(xpath = "//*[@id=\"finish\"]")
    static WebElement finish;

    @FindBy(xpath = "//*[@id=\"checkout_complete_container\"]/h2")
    static WebElement checkoutCompleteContainer;

    static String text = "THANK YOU FOR YOUR ORDER";

    @FindBy(xpath = "//*[@id=\"checkout_info_container\"]/div/form/div[1]/div[4]/h3")
    static WebElement errorText;

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/span")
    static WebElement headerText;

    static String firstError = "Error: First Name is required";

    static String secondError = "Error: Last Name is required";

    static String thirdError = "Error: Postal Code is required";

    static String textHeader = "CHECKOUT: OVERVIEW";

    public ProductsPage() {
        PageFactory.initElements(driver, this);
    }

    public static void shopping() {
        productOne.click();
        productTwo.click();
        cartBadge.click();
        checkout.click();
        firstName.sendKeys("Test");
        lastName.sendKeys("Testov");
        postCode.sendKeys("123456");
        continueOrder.click();
        finish.click();
        String pageText = checkoutCompleteContainer.getText();
        log.info(pageText);
        Assert.assertTrue(pageText.contains(text));
    }

    public static void checkoutInfo() {
        productOne.click();
        cartBadge.click();
        checkout.click();
        continueOrder.click();
        String error = errorText.getText();
        log.info(error);
        Assert.assertTrue(error.contains(firstError));
        firstName.sendKeys("Test");
        continueOrder.click();
        error = errorText.getText();
        log.info(error);
        Assert.assertTrue(error.contains(secondError));
        lastName.sendKeys("Testov");
        continueOrder.click();
        error = errorText.getText();
        log.info(error);
        Assert.assertTrue(error.contains(thirdError));
        postCode.sendKeys("123456");
        continueOrder.click();
        String text = headerText.getText();
        log.info(text);
        Assert.assertTrue(text.contains(textHeader));

    }


}
