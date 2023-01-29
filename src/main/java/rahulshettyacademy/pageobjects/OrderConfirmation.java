package rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class OrderConfirmation extends AbstractComponent {

	WebDriver driver;

	public OrderConfirmation(WebDriver driver)
	{
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css =".hero-primary")
	WebElement orderConfirm;
	
	public String getOrderConfirmation()
	{
		String orderConfirmation = orderConfirm.getText();
		return orderConfirmation;
	}
	

}

