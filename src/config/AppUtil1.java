package config;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import commonFunctions.AdminLoginPage;
import commonFunctions.AdminLogout;

public class AppUtil1 {
public static WebDriver driver;
@BeforeTest
public static void setup() throws Throwable
{
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://orangehrm.qedgetech.com/");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	AdminLoginPage login = PageFactory.initElements(driver, AdminLoginPage.class);
	login.verifylogin("Admin", "Qedge123!@#");
}
@AfterTest
public static void teardown()
{
	AdminLogout logout = PageFactory.initElements(driver, AdminLogout.class);
	logout.verifyLogout();
}
}
