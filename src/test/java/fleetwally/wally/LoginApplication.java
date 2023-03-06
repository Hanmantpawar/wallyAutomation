package fleetwally.wally;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import fleetwally.wally.testclass.BaseTestClass;

public class LoginApplication extends BaseTestClass {
	ExtentReports exreport;

	public void reporter() {
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter report= new ExtentSparkReporter(path);
		report.config().setReportName("Wally Automation Report");
		report.config().setDocumentTitle("Wally Report");
		exreport = new ExtentReports();
		exreport.attachReporter(report);
		exreport.setSystemInfo("Tester Name", "Hanmant Pawar");
				
	}
	

	public void LoginTest() {
		exreport.createTest("LoginTest");
		logpag.loginApplication("hpawar@fleetstudio.com", "Hanmant@369");
		exreport.flush();
		
	}
	
	
}