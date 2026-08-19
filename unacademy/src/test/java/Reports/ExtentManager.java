package Reports;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Utilities.ConfigReader;

public class ExtentManager {

	private static ExtentReports extent;

	public static ExtentReports getExtentReports() {
		if (extent == null) {
			String reportPath = System.getProperty("user.dir") + File.separator + "Reports" + File.separator
					+ "ExtentTestReports.html";
			ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
			reporter.config().setReportName("Unacademy Automation Test Report");
			reporter.config().setDocumentTitle("Unacademy Test Execution Report");
			extent = new ExtentReports();
			extent.attachReporter(reporter);
			extent.setSystemInfo("Tester", "Thanuja");
			extent.setSystemInfo("Application", "Unacademy");
			extent.setSystemInfo("Framework", "Selenium + Cucumber + TestNG");
			extent.setSystemInfo("Environment", "QA");
			extent.setSystemInfo("Browser", ConfigReader.getProperty("browser"));
		}
		return extent;
	}

		public static void flushReport() {
	        if (extent != null) {
	            extent.flush();
	        }
	    }
}