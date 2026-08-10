package package1;

import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
	public Object[][] registerData() throws InvalidFormatException, IOException {
		File f1 = new File(projectpath + "\\data.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(f1);
		XSSFSheet sheet = workbook.getSheetAt(0);
		int rowcount = sheet.getPhysicalNumberOfRows();
		System.out.println("no of rows:" + rowcount);
		Object[][] data = new Object[rowcount - 1][6];
		DataFormatter formatter = new DataFormatter();
		for (int i = 1; i < rowcount; i++) {
			data[i - 1][0] = sheet.getRow(i).getCell(0).getStringCellValue();
			data[i - 1][1] = sheet.getRow(i).getCell(1).getStringCellValue();
			data[i - 1][2] = sheet.getRow(i).getCell(2).getStringCellValue();
			data[i - 1][3] = formatter.formatCellValue(sheet.getRow(i).getCell(3));
			data[i - 1][4] = formatter.formatCellValue(sheet.getRow(i).getCell(4));
			data[i - 1][5] = formatter.formatCellValue(sheet.getRow(i).getCell(5));
		}
		workbook.close();
		return data;

	}

}
