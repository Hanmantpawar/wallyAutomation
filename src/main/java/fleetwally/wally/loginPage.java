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
	
	//Declared all Webelements
	@FindBy (xpath = "//*[@class='md:text-lg text-xs font-normal border-solid border-4 border-black md:px-6 px-2 md:py-1 py-1 md:mr-5 mr-2 whitespace-pre signIn']")
			WebElement LoginButton;
	@FindBy (xpath ="//*[@id='username']")  WebElement userName;
	@FindBy (xpath = "//*[@id='password']") WebElement password;
	@FindBy (xpath = "//button[@type='submit']") WebElement submitButton;
	@FindBy (xpath = "//*[@class='text-sm text-left text-black font-light']") WebElement loginFailedError;

	
	public void loginApplication(String user,String pass) throws InterruptedException {
		
		userName.sendKeys(user);
		password.sendKeys(pass);
		submitButton.click();
		Thread.sleep(5000);
	}
	
	public String ErrorMessage() {
		
	return loginFailedError.getText();
		
	}
		
}
