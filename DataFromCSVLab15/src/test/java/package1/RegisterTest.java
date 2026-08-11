package package1;

import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;

public class RegisterTest extends BaseTest {
	String projectpath = System.getProperty("user.dir");

	@Test(dataProvider = "RegisterData")
	public void fillRegisterForm(String fname, String lname, String emailid, String phno, String password,
			String cpassword) {
		POMPageFactory page = new POMPageFactory(driver);
		Assert.assertEquals(page.getHomePagetitle(), "Your Store");
		Reporter.log("Home Page Verified", true);
		page.gotoRegisterPage();
		Assert.assertEquals(page.verifyRegisterPage(), "Register Account");
		Reporter.log("Register Page Verified", true);
		page.fillPersonalDetails(fname, lname, emailid, phno);
		page.fillPasswords(password, cpassword);
		page.submittingForm();
		String result = page.getRegistrationResult();
		if (result.contains("Your Account Has Been Created!")) {
			Reporter.log("Account created successfully", true);
			Assert.assertTrue(true);
		} else if (result.contains("already registered")) {
			Reporter.log("Account already exists - treated as PASS", true);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Unexpected registration result: " + result);
		}
	}

	@DataProvider(name = "RegisterData")
	public Object[][] registerData() throws InvalidFormatException, IOException, CsvException {
		String csvpath = projectpath+"\\data(sheet1).csv";
		CSVReader reader = new CSVReader(new FileReader(csvpath));
		List<String[]> rows= reader.readAll();
		int rowcount = rows.size();
		Object[][] data = new Object[rowcount-1][6];
		for (int i = 1; i < rowcount; i++) {
			data[i - 1][0] = rows.get(i)[0];
			data[i - 1][1] = rows.get(i)[1];
			data[i - 1][2] = rows.get(i)[2];
			data[i - 1][3] = rows.get(i)[3];
			data[i - 1][4] = rows.get(i)[4];
			data[i - 1][5] = rows.get(i)[5];
		}
		reader.close();
		return data;

	}

}
