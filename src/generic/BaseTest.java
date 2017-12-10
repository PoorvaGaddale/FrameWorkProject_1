package generic;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest implements IAutoConstant {
	
	static {
		System.setProperty("webdriver.gecko.driver", ".\\driver\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
	}
	
	public static WebDriver driver;
	
	@BeforeMethod
	public void openApplication() {
		driver = new FirefoxDriver();
		
		String url = Lib.getProperty(CONFIG_PATH, "URL");
		driver.get(url);
		String ITO = Lib.getProperty(CONFIG_PATH, "ImplicitTimeOut");
		int ito = Integer.parseInt(ITO);
		driver.manage().timeouts().implicitlyWait(ito, TimeUnit.SECONDS);	
	}

	@AfterMethod
	public void closeApplication() {
		driver.close();
	}
	
	
	public void takeScreenshot(String testName) {
		
		Date d = new Date();
		String currentDate = d.toString().replaceAll(":", "_");
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		File destFile = new File(".\\Screenshots\\"+currentDate+"\\"+testName+"_screenshot.png");
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
