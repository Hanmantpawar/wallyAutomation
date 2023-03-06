package fleetwally.wally;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage{
	WebDriver driver;
	//Page Factory
	public loginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//Launch WebSite
	public void launchUrl() {
	driver.get("https://app.wallyax.com/login");
	
	}
	//Declared all Webelements
	@FindBy (xpath ="//*[@id='username']")  WebElement userName;
	@FindBy (xpath = "//*[@id='password']") WebElement password;
	@FindBy (xpath = "//button[@type='submit']") WebElement submitButton;
	@FindBy (xpath = "//*[@class='text-sm text-left text-black font-light']") WebElement loginFailedError;
	
	public void loginApplication(String user,String pass) {
		
		userName.sendKeys(user);
		password.sendKeys(pass);
		submitButton.click();
	}
	
	public String ErrorMessage() {
		
	return loginFailedError.getText();
		
	}
		
}
