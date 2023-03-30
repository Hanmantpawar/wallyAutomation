package fleetwally.wally;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgetPassword {
	WebDriver driver;

	// Page Factory initialization
	public ForgetPassword(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	// forget password? button
	@FindBy(xpath = "//a[text()='Forgot Password ?']")
	WebElement forgetpassword;
	// email text field
	@FindBy(xpath = "//input[@id='username']")
	WebElement enter_email;
	// send_me_code button
	@FindBy(xpath = "//button[@type='submit']")
	WebElement send_me_code;
	// error messages validation text
	@FindBy(xpath = "//span[text()='* E-mail is mandatory']")
	WebElement empty_data_error;
	@FindBy(xpath = "//span[text()='* Invalid email format']")
	WebElement Space_validation_error;
	@FindBy(xpath = "//p[text()='Email does not exists']")
	WebElement unregistered_email_error;
	public void screen_wait() {
	Timeouts implicitlyWait = driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
}
