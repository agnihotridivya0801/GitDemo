package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class CheckOutPage extends AbstractComponent {

	WebDriver driver;

	public CheckOutPage(WebDriver driver)
	{
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@placeholder='Select Country']" )
	WebElement selectCountry;
	
	@FindBy(css = ".list-group-item")
	List<WebElement> countries;
	
	@FindBy(css =".action__submit")
	WebElement submit;
	
	public void selectCountry(String keys, String countryToBeSelected)
	{
		selectCountry.sendKeys(keys);
		WebElement country=  countries.stream().filter(s->s.getText().equalsIgnoreCase(countryToBeSelected)).findFirst().orElse(null);
		  country.click();
	}
	
	public OrderConfirmation placeOrder()
	{
		submit.click();
		OrderConfirmation orderConfirmation = new OrderConfirmation(driver);
		return orderConfirmation;
	}
	

}
