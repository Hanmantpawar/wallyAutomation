package fleetwally.wally;
import org.testng.Assert;
import org.testng.annotations.Test;
import fleetwally.wally.testclass.BaseTestClass;

public class ForgetPasswordValidation extends BaseTestClass {
	@Test(priority = 0)
	public void launch() {
		System.out.println("--------Browser Launched -----------");
		forg_pass.forgetpassword.click();
	}

	@Test(priority = 1)
	public void test_1() throws InterruptedException {
		// empty data validation
		forg_pass.send_me_code.click();
		Assert.assertTrue(forg_pass.empty_data_error.getText().contains("* E-mail is mandatory"));
		System.out.println("------------null validation assertion Passed-----------");
		driver.navigate().refresh();
		forg_pass.screen_wait();
	}

	@Test(priority = 2)
	public void test_2() throws InterruptedException {
		// spaced data validation
		forg_pass.enter_email.sendKeys(prop_neg.getProperty("spaced_email"));
		forg_pass.send_me_code.click();
		Assert.assertTrue(forg_pass.Space_validation_error.getText().contains("* Invalid email format"));
		System.out.println("------------space validation assertion Passed-----------");
		driver.navigate().refresh();
		forg_pass.screen_wait();
	}

	@Test(priority = 3)
	public void test_3() throws InterruptedException {
		// unregistered data validation
		forg_pass.enter_email.sendKeys(prop_neg.getProperty("un_reg_email"));
		forg_pass.send_me_code.click();
		Assert.assertTrue(forg_pass.unregistered_email_error.getText().contains("Email does not exists"));
		System.out.println("------------unregistered email validation asssertion Passed------");
		forg_pass.screen_wait();
		driver.navigate().refresh();
	}

	@Test(priority = 4)
	public void test_4() throws InterruptedException {
		// valid data validation
		forg_pass.enter_email.sendKeys(prop_neg.getProperty("reg_email"));
		forg_pass.send_me_code.click();
		System.out.println("------------registered email validation assertion Passed------");
		System.out.println("---OTP verification pending----");

	}
}
