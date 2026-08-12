package package1;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

public class SearchTest extends BaseTest {
	@Test(dataProvider = "searchData")
	public void searchFlowTest(String firstSearch, String secondSearch) throws IOException {
		POMLocators pom = new POMLocators(driver);
		ExtentTest test = extent.createTest("SearchTest - " + secondSearch);
		pom.searchText(firstSearch, secondSearch);
		String actualHeading = pom.resultPageHeading();
		test.pass("Search verified for " + secondSearch);
		Reporter.log("Searching " + secondSearch);
		Assert.assertEquals(actualHeading, "Search - " + secondSearch);
		String screenshotName = "Search_" + secondSearch.replaceAll("[^a-zA-Z0-9]", "_");

		test.pass("Search verified successfully for " + secondSearch)
				.addScreenCaptureFromPath(BaseTest.capturescreenshot(screenshotName));
	}

	

	@DataProvider(name = "searchData")
	public Object[][] searchData() {

		return new Object[][] { { "Mobile", "Monitors" }, { "Laptop", "Phones" }, { "Camera", "Cameras" } };
	}

}
