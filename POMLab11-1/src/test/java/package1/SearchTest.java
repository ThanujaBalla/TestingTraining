package package1;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest{
	@Test(dataProvider="searchData")
	public void searchFlowTest(String firstSearch,String secondSearch) {
		POMLocators pom = new POMLocators(driver);
		pom.searchText(firstSearch, secondSearch);
		String actualHeading = pom.resultPageHeading();
		Reporter.log("Searching "+secondSearch);
        Assert.assertEquals(
            actualHeading,
            "Search - " + secondSearch
        );
	}
	
	@DataProvider(name = "searchData")
	public Object[][] searchData() {

	    return new Object[][] {
	        {"Mobile", "Monitors"},
	        {"Laptop", "Phones"},
	        {"Camera", "Cameras"}
	    };
	}

}
