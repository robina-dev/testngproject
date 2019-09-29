package page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class Techfios_Page extends Base_Page {
	//Global driver used by all methods
	WebDriver driver;
	
	//Create a Constructor to invite driver
	public Techfios_Page(WebDriver driver) {
		this.driver = driver;
	}
	
		
	//Element Library
	@FindBy(how = How.NAME, using = "data")
	WebElement CategoryInputBox;
	@FindBy(how = How.XPATH, using = "//input[@value='Add']")
	WebElement AddButton;
	@FindBy(how = How.XPATH, using = "//body[contains(text(),'Sorry that TODO item already exists. ')]")
	WebElement WarningMessage;
	@FindBy(how = How.NAME, using = "due_month")
	WebElement MonthDropDown;
	@FindBy(how = How.LINK_TEXT, using = "Back")
	WebElement BackLink;
	@FindBys(@FindBy(how = How.XPATH, using = "//select[@name='due_month']/descendent::option"))
	List<WebElement>MonthList;
	
	
	//Test 1: Validate a user is able to add a category and 
	//once the category is added it should display.
	//Method to add category
	public void ClickOnAddaCategoryButton(String category) throws InterruptedException {
		CategoryInputBox.click();
		CategoryInputBox.sendKeys(category);
		AddButton.click();
		Thread.sleep(2000);
	}
	//Test 2: Validate a user is not able to add a duplicated category.If it does then the following  
	// message will display:"The category you want to add already exists: <duplicated category name>."
	//Method to check if the message is displayed
	public boolean isWarningMessageDisplayed() {
		return WarningMessage.isDisplayed();
	}
	
	//Test 3: Validate the month drop down has all the months (jan, feb, mar ...) 
	//in the Due Date dropdown section.
	//Method to select Month drop down box
	public void selectMonthDropDownBox() {
		MonthDropDown.click();
	}
	
	//Method to click Back Link
	public void clickBackLink() {
		BackLink.click();
	}
	
	//Method to validate monthDropDown has all the Months
	public boolean isMonthDropDownHasMonthsDisplayed(){
		
		Select selectMonthDropDown = new Select(MonthDropDown); 
		List<WebElement> allOptions = selectMonthDropDown.getOptions();
		
		String months = "None;Jan;Feb;Mar;Apr;May;Jun;Jul;Aug;Sep;Oct;Nov;Dec";
		String[] arrMonths = months.split(";");
		
		int count = 0;
		for(String str:arrMonths){
			boolean found = false;
			for(WebElement ele:allOptions) {
				if(str.contentEquals(ele.getText())) {
					found = true;
					count++;
					System.out.println(str+ "Month exists.");
					break;
				}
	 }
		if(!found) {
			System.out.println(str +"Month does not exist");
		}	
			
	}
		System.out.println("Count : " + count);
		if(count < 13) {
			return false;
		}
		else {
			return true;
		}
			
	}
	
}




