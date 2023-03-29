package fleetwally.wally;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class SignupPage {
	WebDriver driver;
	Select s;
	JavascriptExecutor js;
	
	public SignupPage(WebDriver driver)
	{
		this.driver =driver;
		PageFactory.initElements(driver, this);	
	}
	@FindBy (xpath = "//button[@class='md:text-lg text-xs font-normal text-white bg-black md:px-6 px-3 md:py-2 py-2 whitespace-pre getStarted']")
	WebElement GetStarted;
	@FindBy (xpath = "//*[@id='firstName']") WebElement FirstName;
	@FindBy (xpath = "//*[@id='lastName']") WebElement LastName;
	@FindBy (xpath = "//div[@class='flag-dropdown countryDropdown']") WebElement States;
	@FindBy (xpath = "//*[@class='selected-flag']")WebElement countryFlag;
	@FindBy (xpath = "//*[@class='flag in']") WebElement country;
	@FindBy (xpath = "//*[@class='form-control phoneInput']") WebElement phoneNumber;
	@FindBy (xpath = "//*[@id='role']") WebElement Role;
	@FindBy (xpath = "//input[@id='organization']") WebElement CompanyName;
	@FindBy (xpath = "//*[@id='email']") WebElement Email;
	@FindBy (xpath = "//*[@id='freelancer']") WebElement SizeOfCompany;
	@FindBy (xpath = "//*[@class='text-md mr-10 cursor-pointer ']") WebElement Websites;
	@FindBy(xpath = "//input[@value='SUBMIT']") WebElement SubmitButton;
	
	public void SignupFunction(String Fname,String Lname,String email,String company,String phone) throws InterruptedException {
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		GetStarted.click();
		FirstName.sendKeys(Fname);
		LastName.sendKeys(Lname);	
		Email.sendKeys(email);
		js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,400)", "");
	   Thread.sleep(2000);
	    countryFlag.click();
	    country.click();
	    phoneNumber.sendKeys(phone);   
		Thread.sleep(2000);
		s = new Select(Role);
		s.selectByVisibleText("Software Engineer");	
		/*
		Select s = new Select(Role);
		List<WebElement> option = s.getOptions();
		int size =option.size();
		System.out.println(size);
		for(int i=0;i<=size;i++) {
			String allOption= option.get(i).getText();
			System.out.println(allOption);
			if(allOption.equalsIgnoreCase("Software Engineer")) {
				System.out.println(allOption);
				s.selectByVisibleText("Software Engineer");				
			}	
		}
		*/
		js.executeScript("window.scrollBy(0,400)", "");
		Thread.sleep(2000);
		CompanyName.sendKeys(company);	
		Thread.sleep(2000);
		SizeOfCompany.click();
		Thread.sleep(2000);
		Websites.click();
		Thread.sleep(2000);
		SubmitButton.click();
		
		
	}
}
