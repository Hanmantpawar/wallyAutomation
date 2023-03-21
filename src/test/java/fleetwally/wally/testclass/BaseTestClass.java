package fleetwally.wally.testclass;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import fleetwally.wally.SignupPage;
import fleetwally.wally.loginPage;
import fleetwally.wally.signout;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTestClass {
	public WebDriver driver;
	public loginPage logpag;
	public signout signoutApp;
	public SignupPage sp; 
	
@BeforeSuite
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
		driver.get("https://app.wallyax.com/");
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

	@BeforeClass 
	public void createobject() {
		
		logpag = new loginPage(driver);
		signoutApp = new signout(driver);
		sp = new SignupPage(driver);
	}
	
	@AfterSuite
	public void closeBrowser() {
		driver.quit();
	}
}
