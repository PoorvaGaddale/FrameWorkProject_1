package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObjectRepository {
	
	//declare the Elements
	@FindBy(id="username")
	WebElement un1;
	@FindBy(name="pwd")
	WebElement pwd1;
	@FindBy(xpath="//a[@id='loginButton']")
	WebElement loginbtn1;	
	
	//initialise
	
	public LoginPageObjectRepository(WebDriver driver){
		PageFactory.initElements(driver, this);	
	}
	//utilise
	public void setUsername(String unname) {
		un1.sendKeys(unname);
	}
	public void setPassword(String pw){
		pwd1.sendKeys(pw);
	}
	public void clickLogin() {
		loginbtn1.click();
	}
	
}
