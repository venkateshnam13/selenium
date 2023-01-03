package commonFunctions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminLoginPage {
	//define repository
	@FindBy(name= "txtUsername")
	WebElement Enterusername;
	@FindBy(name= "txtPassword")
	WebElement Enterpassword;
	@FindBy(name="Submit")
	WebElement clickLoginBtn;
	//method for login
	public void verifylogin(String username,String password)
	{
		Enterusername.sendKeys(username);
		Enterpassword.sendKeys(password);
		clickLoginBtn.click();
	}

}
