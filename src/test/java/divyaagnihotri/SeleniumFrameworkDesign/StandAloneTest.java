package divyaagnihotri.SeleniumFrameworkDesign;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import divyaagnihotri.TestComponent.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckOutPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.OrderConfirmation;
import rahulshettyacademy.pageobjects.ProductCatalog;

public class StandAloneTest extends BaseTest {
@Test
	public void submitOrder() throws IOException, InterruptedException {
	String productName= "ADIDAS ORIGINAL";
	

	//landingPage.loginApplication("agnihotridivya0801@gmail.com", "Divyaibm@0801");
	ProductCatalog productCatalogue = landingPage.loginApplication("agnihotridivya0801@gmail.com", "Divyaibm@0801");
	List<WebElement> products =productCatalogue.getProductList();
	productCatalogue.addProductToCart(productName);
	productCatalogue.goToCartPage();
	//CartPage cartPage = new CartPage(driver);
	CartPage cartPage  =productCatalogue.goToCartPage();
	Boolean found = cartPage.verifyProductDisplay(productName);
    Assert.assertTrue(found);
    CheckOutPage checkOutPage =cartPage.goToCheckout();
    //CheckOutPage checkOutPage = new CheckOutPage(driver);
    checkOutPage.selectCountry("ind", "Indonesia");
    OrderConfirmation orderConfirmation = checkOutPage.placeOrder();
    //OrderConfirmation orderConfirmation = new OrderConfirmation(driver);
    
    String orderConfirmationFinal= orderConfirmation.getOrderConfirmation();


Assert.assertEquals("THANKYOU FOR THE ORDER.", orderConfirmationFinal);
    System.out.println("passed");
    Thread.sleep(5000);
   
	}

}
