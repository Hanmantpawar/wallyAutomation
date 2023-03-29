package fleetwally.wally;

import java.io.IOException;
import java.util.HashMap;

import org.apache.hc.core5.reactor.Command.Priority;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import fleetwally.wally.testclass.BaseTestClass;

public class LoginValidation extends BaseTestClass {
	

//	@Test(priority = 1, dataProvider = "hashmapdata")
	// from data provider data
	// public void LoginErrorMessage(String userName, String password) throws
	// IOException {

	public void LoginErrorMessage(HashMap<String, String> input) throws IOException, InterruptedException {
		logpag.loginApplication(input.get("Email"), input.get("pass"));
		String expectedResult = "Incorrect Credentials. Please try again";
		String actualResult = logpag.ErrorMessage();
		Assert.assertEquals(expectedResult, actualResult);

	}
	@Test (priority = 3,dataProvider ="SignupData" )
	public void singupApplication(HashMap<String, String>inputData) throws InterruptedException {
		sp.SignupFunction(inputData.get("First Name"),
				inputData.get("Last Name"),
				inputData.get("email"),
				inputData.get("Compamy"),
				inputData.get("phone")
				);		
	}
	
	@DataProvider
	public Object[][] SignupData() {
		// correct user name & incorrect password
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("First Name", "Hanmant ");
		data.put("Last Name", "Pawar ");
		data.put("email", "hpawar+1@fleetstudio.com ");
		data.put("Compamy", "Fleet Studio Technology");
		data.put("phone", "9876543210");
		
		return new Object[][] { { data }};
		
	}
	
@Test(priority = 1)
	public void LoginApplication() throws InterruptedException {

		logpag.loginApplication("hpawar@fleetstudio.com", "Hanmant@369");
	}
	
	@Test(priority = 2)
	public void logout() throws InterruptedException {
		signoutApp.signoutApplication();
	}
	/* using data provide sending user login details */
	/*
	 * @DataProvider public Object[][] getData() { return new Object [][]
	 * {{"hpawar@fleetstudio.com","hpawar@123456"},{"hanmant@fleetstudio.com",
	 * "Hanmant@12345"}}; }
	 */

	/* Using HashMap sending user login details */
	@DataProvider
	public Object[][] hashmapdata() {
		// correct user name & incorrect password
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("Email", "hpawar@fleetstudio.com");
		map.put("pass", "Hanmant@12345");
		// incorrect User name & correct password
		HashMap<String, String> map1 = new HashMap<String, String>();
		map1.put("Email", "hanmant@fleetstudio.com");
		map1.put("pass", "Hanmant@369");
		// Incorrect User name & incorrect password
		HashMap<String, String> map2 = new HashMap<String, String>();
		map2.put("Email", "vipul@fleetstudio.com");
		map2.put("pass", "vipul@23651");

		return new Object[][] { { map }, { map1 }, { map2 } };

	}

}