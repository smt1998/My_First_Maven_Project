package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;
import pages.LoginPage;

public class HomeTest {
	public WebDriver driver;
	LoginPage loginpage;
	HomePage homepage;
	public void initOnject(WebDriver driver) {
		loginpage=new LoginPage(driver);
		homepage=new HomePage(driver);
	}
	@BeforeClass
	public void init() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		initOnject(driver);
	}
	
	@BeforeMethod
	public void PreCondition() {
		loginpage.enterUsernameTextBox("Admin");
		loginpage.enterPasswordTextBox("admin123");
		loginpage.clickOnLoginButton();
		
	}
	
	@Test
	public void logout () throws InterruptedException {
		Thread.sleep(2000);
		
		homepage.clickOnDashboard();
		Thread.sleep(2000);
		homepage.clickOnProfile();
		Thread.sleep(2000);
		homepage.clickOnLogotButton();
	}
	
	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.close();
	}
	
	

}
