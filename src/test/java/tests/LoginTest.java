package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;

@Listeners(utility.TestListener.class)
public class LoginTest extends BaseTest{
	public static WebDriver driver;
	LoginPage lp;
	@BeforeClass
	public void init() {
		WebDriverManager.chromedriver().setup();
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		lp=new LoginPage(driver);
	}
	
	@Test (priority=2)
	public void login() {
		lp.enterUsernameTextBox("Admin");
		lp.enterPasswordTextBox("admin123");
		lp.clickOnLoginButton();
	}
	
	@Test (priority=1)
	public void verifyPageTitle() {
Assert.assertFalse(driver.getTitle().contains("Orange"),"Page Titledoes not match");
	
	}
	
	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.close();
	}
}
