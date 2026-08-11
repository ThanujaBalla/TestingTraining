package package1;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;

public class DesktopTest extends BaseTest {

	@Test(dataProvider = "sortData")
	public void DesktopFlow(String sortOption) {
		POM_properties page = new POM_properties(driver);
		page.gotoMacPage();
		String actualHeading = page.getMacHeading();
		Assert.assertEquals(actualHeading, "Mac");
		Reporter.log("Mac Heading Verified",true);
		
		page.addToCart(sortOption);
		String actualMessage = page.getSuccessMessage();
		System.out.println("ACTUAL MESSAGE = " + actualMessage);
		Assert.assertTrue(actualMessage.contains("Success: You have added iMac to your shopping cart!"));
		Reporter.log("Add to cart Verified",true);
	
		
	}
	
	@DataProvider(name="sortData")
	public Object[][] sortData(){
		return new Object[][] {
			{"Name (A - Z)"},
			{"Name (Z - A)"}
		};
	}

}
