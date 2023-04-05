package fleetwally.wally;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class signout {
	WebDriver driver;
	public signout(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//div[contains(text(),'Profile')]")
	WebElement profile;
	@FindBy(xpath = "//*[@class =\"text-base mt-0.5 mr-2\"]")
	WebElement logoutButton;
	@FindBy (xpath = "//*[@class='relative']") WebElement logoutWindow;
	@FindBy(xpath = "//button[contains(text(),'Yes')]")
	WebElement yesButton;

	public void signoutApplication() throws InterruptedException {
		profile.click();
		Thread.sleep(5000);
		logoutButton.click();
		yesButton.click();
		driver.get("https://app.wallyax.com/login");
	}
}
