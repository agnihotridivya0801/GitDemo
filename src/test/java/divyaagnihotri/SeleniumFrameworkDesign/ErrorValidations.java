package divyaagnihotri.SeleniumFrameworkDesign;

import org.testng.Assert;
import org.testng.annotations.Test;

import divyaagnihotri.TestComponent.BaseTest;

import rahulshettyacademy.pageobjects.ProductCatalog;

public class ErrorValidations extends BaseTest {
	
	@Test
	public void invalidLoginError()
	{
		landingPage.loginApplication("agnihotridivya0801@gmail.com", "1divyaibm@0801");
		String message =landingPage.getErrorMessage();
		Assert.assertEquals(message, "Incorrect email or password.");
	}

}
