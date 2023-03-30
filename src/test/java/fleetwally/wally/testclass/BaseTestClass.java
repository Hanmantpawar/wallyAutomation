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
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import fleetwally.wally.ForgetPassword;
import fleetwally.wally.LoginDetailsValidation;
import fleetwally.wally.SignupPage;
import fleetwally.wally.loginPage;
import fleetwally.wally.signout;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTestClass {
	public static WebDriver driver;
	public loginPage logpag;
	public signout signoutApp;
	public SignupPage sp;
	public ForgetPassword forg_pass;
	public Properties prop_neg;

	@BeforeSuite 
	public WebDriver initializeDriver() throws IOException {
		Properties prop = new Properties();
		String path = System.getProperty("user.dir");
		FileInputStream fis = new FileInputStream(
				path + "\\src\\main\\java\\fleetwally\\wally\\resources\\GlobalData.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		prop_neg = new Properties();
		String path_neg = System.getProperty("user.dir");
		FileInputStream neg = new FileInputStream(
				path_neg + "\\src\\main\\java\\fleetwally\\wally\\resources\\Neg_Case_Data.properties");
		prop_neg.load(neg);

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeopt = new ChromeOptions();
			chromeopt.addArguments("--remote-allow-origins=*");
			// chromeopt.addArguments("--disable notifications");
			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setCapability(ChromeOptions.CAPABILITY, chromeopt);
			chromeopt.merge(dc);
			driver = new ChromeDriver(chromeopt);

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
		//sp = new SignupPage(driver);
		forg_pass = new ForgetPassword(driver);
	}

	@AfterSuite
	public void closeBrowser() {
	//driver.quit();
	}
}
