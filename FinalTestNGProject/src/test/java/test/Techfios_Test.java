package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import page.Techfios_Page;
import util.Browser_Factory;

public class Techfios_Test {
	// Create Global driver used by all methods
	WebDriver driver;

	// Before Method start browser and save the driver in the test class
	@BeforeMethod
	public void launchBrowser() {
		driver = Browser_Factory.startBrowser();
	}

	// Test 1: Validate a user is able to add a category and once the category
	// is added it should display.
	@Test
	public void validUserShouldAbleToAddaCategory() throws InterruptedException {

		// driver will take you to the site
		driver.get("http://techfios.com/test/101/");

		// Calling the TechFios_Page class
		Techfios_Page techfios_Page = PageFactory.initElements(driver, Techfios_Page.class);

		// Calling the method from Techfios_Page
		techfios_Page.ClickOnAddaCategoryButton("Techfios Student");

		// Test 2: Validate a user is not able to add a duplicated category.If it does
		// then the following
		// message will display:"The category you want to add already exists:
		// <duplicated category name>."

		// Calling the Validation method from Techfios_Page
		Assert.assertTrue(techfios_Page.isWarningMessageDisplayed(), "Warning Message is not Displayed");

		//// Test 3: Validate the Month drop down has all the months (jan, feb, mar ...)
		// in the Due Date dropdown section.
		// Click on the Back Link
		techfios_Page.clickBackLink();

		// Click Month drop down
		techfios_Page.selectMonthDropDownBox();

		// Checking the Month List
		techfios_Page.isMonthDropDownHasMonthsDisplayed();

		// Validate the Month List
		Assert.assertTrue(techfios_Page.isMonthDropDownHasMonthsDisplayed(),
				"Months in the drop down box do not match!!");
		}
	
	@AfterMethod
	//Close and quit method
	public void closeAndquit() {		
		driver.close();
		driver.quit();
	}
	
	}

