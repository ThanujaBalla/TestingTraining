package package1;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;

public class DesktopTest extends BaseTest {

	@Test(dataProvider = "sortData")
	public void DesktopFlow(String sortOption) {
		POMLocators pom = new POMLocators(driver);
		pom.gotoMacPage();
		String actualHeading = pom.getMacHeading();
		Assert.assertEquals(actualHeading, "Mac");
		Reporter.log("Mac Heading Verified",true);
		
		pom.addtoCart(sortOption);
		String actualMessage = pom.verifySuccessMessage();
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
