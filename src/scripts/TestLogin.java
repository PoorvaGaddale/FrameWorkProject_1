package scripts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.BaseTest;
import generic.Lib;
import pompages.LoginPageObjectRepository;

public class TestLogin extends BaseTest{
	
	@Test
	public void testLogin() throws InterruptedException {
		LoginPageObjectRepository l = new LoginPageObjectRepository(driver);
		
		String unname = Lib.getCellValue(EXCEL_PATH, "ValidLogin", 1, 0);
		String pw = Lib.getCellValue(EXCEL_PATH, "ValidLogin", 1, 1);
		String expected = Lib.getCellValue(EXCEL_PATH, "ValidLogin", 1, 2);
		
		l.setUsername(unname);
		l.setPassword(pw);
		Thread.sleep(3000);
		l.clickLogin();
		
		String actualTitle = driver.getTitle();
		
		//System.out.println(actualTitle);
		
		SoftAssert s = new SoftAssert();
		s.assertEquals(actualTitle, expected);
		s.assertAll();
	}
	
	

}
