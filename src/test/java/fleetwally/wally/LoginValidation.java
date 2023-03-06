package fleetwally.wally;

import java.io.IOException;
import java.util.HashMap;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import fleetwally.wally.testclass.BaseTestClass;

public class LoginValidation extends BaseTestClass {

	@Test
	public void LoginApplication() {

		logpag.loginApplication("hpawar@fleetstudio.com", "Hanmant@369");
	}

	@Test(dataProvider = "hashmapdata")
	// from data provider data
	// public void LoginErrorMessage(String userName, String password) throws
	// IOException {

	public void LoginErrorMessage(HashMap<String, String> input) throws IOException {

		logpag.loginApplication(input.get("Email"), input.get("pass"));
		String expectedResult = "Incorrect Credentials. Please try again";
		String actualResult = logpag.ErrorMessage();
		Assert.assertEquals(expectedResult, actualResult);

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
		//correct user name & incorrect password
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