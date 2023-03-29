package fleetwally.wally.resources;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterClass {
	
	public static ExtentReports getReporterObject () 
	{
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter= new ExtentSparkReporter(path);
		reporter.config().setReportName("Wally Automation Report");
		reporter.config().setDocumentTitle("Wally Report");	
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester Name", "Hanmant Pawar");
		return extent;
	}
}
