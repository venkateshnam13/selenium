package commonFunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class AddEmpPage {
	WebDriver driver;
	public AddEmpPage(WebDriver driver)
	{
		this.driver =driver;
	}
	//Define Repository
	@FindBy(xpath = "//b[normalize-space()='PIM']")
	WebElement clickpim;
	@FindBy(name = "btnAdd")
	WebElement clickAddBtn;
	@FindBy(name="firstName")
	WebElement EnterFname;
	@FindBy(name="middleName")
	WebElement EnterMname;
	@FindBy(name ="lastName")
	WebElement EnterLname;
	@FindBy(name="employeeId")
	WebElement BeforeEid;
	@FindBy(id="btnSave")
	WebElement clicksaveBtn;
	@FindBy(name="personal[txtEmployeeId]")
	WebElement AfterEid;
	public boolean verifyEmp(String FirstName,String MiddleName,String LastName)
	{
		Actions ac = new Actions(driver);
		ac.moveToElement(this.clickpim).click().perform();
		ac.moveToElement(this.clickAddBtn).click().perform();
		this.EnterFname.sendKeys(FirstName);
		this.EnterMname.sendKeys(MiddleName);
		this.EnterLname.sendKeys(LastName);
		String ExpectedEid = this.BeforeEid.getAttribute("value");
		this.clicksaveBtn.click();
		String ActualEid = this.AfterEid.getAttribute("value");
		if(ExpectedEid.equals(ActualEid))
		{
			Reporter.log("Add Emp Success::"+ExpectedEid+"     "+ActualEid,true);
			return true;
		}
		else
		{
			Reporter.log("Add Emp Fail::"+ExpectedEid+"     "+ActualEid,true);
			return false;
		}
		

	}
}
