package package1;

import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import java.io.IOException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;

public class DesktopTest extends BaseTest {
	String projectpath = System.getProperty("user.dir");

	@Test(dataProvider = "sortData")
	public void DesktopFlow(String sortOption) throws IOException {
		POMLocators pom = new POMLocators(driver);

		ExtentTest test = extent.createTest("AddtoCartTest-" + sortOption);
		pom.gotoMacPage();
		String actualHeading = pom.getMacHeading();
		Assert.assertEquals(actualHeading, "Mac");
		test.info("Heading matched");
		Reporter.log("Mac Heading Verified", true);

		pom.addtoCart(sortOption);
		String actualMessage = pom.verifySuccessMessage();
		System.out.println("ACTUAL MESSAGE = " + actualMessage);
		Assert.assertTrue(actualMessage.contains("Success: You have added iMac to your shopping cart!"));
		Reporter.log("Add to cart Verified", true);
		test.info("Added to cart");
		if (actualMessage.contains("Success: You have added iMac to your shopping cart!")) {
			String screenshotName = "AddtoCart_" + sortOption.replaceAll("[^a-zA-Z0-9]", "_");
			test.pass("Added to cart Successfully!").addScreenCaptureFromPath(capturescreenshot(screenshotName));
		} else {
			test.fail("Failed to add item in the cart").addScreenCaptureFromPath(capturescreenshot("AddtoCartTest"));
		}
	}


	@DataProvider(name = "sortData")
	public Object[][] sortData() {
		return new Object[][] { { "Name (A - Z)" }, { "Name (Z - A)" } };
	}

}
