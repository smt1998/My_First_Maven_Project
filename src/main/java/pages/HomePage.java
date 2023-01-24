package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	
	public WebDriver driver;
	@FindBy (xpath="//span[text()='Dashboard']")
	WebElement Dashboard;
	@FindBy (xpath="//span[@class='oxd-userdropdown-tab']")

	WebElement profileSelection;
	
	@FindBy (xpath="//a[text()='Logout']")
	WebElement logoutButton;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public  void clickOnDashboard() {
		Dashboard.click();
	}
	
	public void clickOnProfile() {
		profileSelection.click();
	}
	
	public void clickOnLogotButton() {
		logoutButton.click();
	}
}

