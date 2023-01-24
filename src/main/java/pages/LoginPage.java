package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	@FindBy(xpath="//*[@name='username']")
	WebElement usernameTextBox;
	
	@FindBy(xpath="//*[@name='password']")
	WebElement passwordTextBox;
	
	@FindBy(xpath="//*[@type='submit']")
	WebElement loginButton;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void enterUsernameTextBox(String user) {
		if(usernameTextBox.isEnabled()) {
			usernameTextBox.sendKeys(user);
		}
		
	}
 public void enterPasswordTextBox(String password) {
	 if(passwordTextBox.isEnabled()) {
		 passwordTextBox.sendKeys(password);
	 }
	 
 }
 
 public void clickOnLoginButton() {
	 loginButton.click();
 }
}

