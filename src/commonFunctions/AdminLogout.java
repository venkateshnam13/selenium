package commonFunctions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminLogout {
@FindBy(id ="welcome")
WebElement clickwelcome;
@FindBy(linkText = "Logout")
WebElement clicklogout;
public void verifyLogout()
{
	clickwelcome.click();
	clicklogout.click();
}
}
