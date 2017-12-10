package scripts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.BaseTest;
import generic.Lib;
import pompages.LoginPageObjectRepository;

public class TestInvalidlogin extends BaseTest{
	
	@Test
	public void testInvalidLogin() throws InterruptedException {
		LoginPageObjectRepository l = new LoginPageObjectRepository(driver);
		
		int rowCount = Lib.getRowCount(EXCEL_PATH, "InvalidLogin");
		
		for (int i = 1; i <= rowCount; i++) {
			String unname = Lib.getCellValue(EXCEL_PATH, "InvalidLogin", i, 0);
			String pw = Lib.getCellValue(EXCEL_PATH, "InvalidLogin", i, 1);
			l.setUsername(unname);
			l.setPassword(pw);
			l.clickLogin();
			Thread.sleep(2000);
			
		}
		
		System.out.println(rowCount);
	
	}
	
	

}
