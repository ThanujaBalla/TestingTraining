package package1;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentTest;
 
public class ExtentTestNgListener implements ITestListener{
	
 
private static ThreadLocal<ExtentTest> test=new ThreadLocal<>();
 
@Override
public void onTestStart(ITestResult result)
{
	String testname = result.getMethod().getMethodName();
	Object[] parameters = result.getParameters();
	if(parameters.length>0) {
		testname +="-";
		for(Object parameter: parameters) {
			testname += parameter+" ";
		}
	}
	ExtentTest extendtest=BaseTest.extent.createTest(testname.trim());
	test.set(extendtest);
	test.get().info("Test Started");
	
	
}
@Override
public void onTestSuccess(ITestResult result)
{
	test.get().pass("Test Passed");
	try {
		String screenshotname = result.getMethod().getMethodName()+"-"+System.currentTimeMillis();
		Object[] parameters = result.getParameters();
		if(parameters.length>0) {
			screenshotname +="-";
			for(Object parameter: parameters) {
				screenshotname += parameter+" ";
			}
		}
		String path = BaseTest.capturescreenshot(screenshotname);
		test.get().addScreenCaptureFromPath(path);
	}catch(Exception e) {
		test.get().info("Screenshot could not be captured");
	}
}
 
@Override
public void onTestFailure(ITestResult result)
{
	test.get().fail("Test Failed");
	test.get().fail(result.getThrowable());
	try {
		String screenshotname = result.getMethod().getMethodName()+"-"+System.currentTimeMillis();
		String path = BaseTest.capturescreenshot(screenshotname);
		test.get().addScreenCaptureFromPath(path);
	}catch(Exception e) {
		test.get().info("Screenshot could not be captured");
	}
	
}
 
 
@Override
public void onTestSkipped(ITestResult result)
{
	test.get().skip("Test Skipped");
	test.get().skip(result.getThrowable());
	
	
}
 
 
 
@Override
public void onFinish(ITestContext context)
{
//extent.flush();
	
	
}
 
 
}