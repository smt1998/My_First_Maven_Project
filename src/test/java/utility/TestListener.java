package utility;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import tests.LoginTest;

public class TestListener implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {
		try {
			Screenshot.captureScreen(LoginTest.driver, result.getName());
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
