package fleetwally.wally.testclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import fleetwally.wally.loginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTestClass {
	public WebDriver driver;
	public loginPage logpag;

	public WebDriver initalizeDriver() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
		"C:\\Users\\Fleet Studio-21\\eclipse-workspace\\wally\\src\\main\\java\\fleetwally\\wally\\resources\\GlobalData.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		}
		if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;

	}
	/* Take screen shot */

	public String getScreenShot(String TestCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + TestCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + TestCaseName + ".png";
	}

	@BeforeMethod
	public loginPage launchApplication() throws IOException {
		driver = initalizeDriver();
		logpag = new loginPage(driver);
		logpag.launchUrl();
		return logpag;
	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
}
