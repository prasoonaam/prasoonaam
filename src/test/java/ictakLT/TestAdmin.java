package ictakLT;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import web.ictaklt.constants.AutomationConstants;
import web.ictaklt.pages.LoginPage;
public class TestAdmin extends TestBase {
	LoginPage objadm=null;
	SoftAssert softassert=new SoftAssert();

@Test(priority=1)
public void ValidTestcaseLoginAdmin() throws InterruptedException
{
    objadm=new LoginPage(driver);
    objadm.setUsername("admin");
    objadm.setPassword("Admin@123");
    objadm.LoginBtn();
    objadm.Adminctrl();
    objadm.Logout();
}
@Test(priority=2)

public void InValidTestcaseLoginAdmin() throws InterruptedException
{
    objadm=new LoginPage(driver);
    objadm.setUsername("adminn");
    objadm.setPassword("admin@1234");
	softassert.assertTrue(objadm.signin(),"User Not Found");
	softassert.assertAll();

}
@Test(priority=3)

public void InValidUsernameTestcaseLoginAdmin() throws InterruptedException
{
    objadm=new LoginPage(driver);
    objadm.setUsername("adminn");
    objadm.setPassword("admin@123");
	softassert.assertTrue(objadm.signin(),"User Not Found");
	softassert.assertAll();

}
@Test(priority=4)

public void InValidPasswordTestcaseLoginAdmin() throws InterruptedException
{
    objadm=new LoginPage(driver);
    objadm.setUsername("admin");
    objadm.setPassword("admin@1234");
//	String actualError=objadm.checkLoginStatus();
//	softassert.assertEquals(actualError, AutomationConstants.expError);
	softassert.assertTrue(objadm.signin(),"Login Failed");
	softassert.assertAll();
}
@Test(priority=5)

public void BlankFieldsTestcaseLoginAdmin() throws InterruptedException
{
    objadm=new LoginPage(driver);
    objadm.setUsername("");
    objadm.setPassword("");
//    softassert.assertEquals(objadm.uname_err_msg(), AutomationConstants.exp_uname_err_msg);
//    softassert.assertEquals(objadm.password_err_msg(), AutomationConstants.exp_psswd_err_msg);    
//    softassert.assertTrue(objadm.signin(),"Please fill in all fields.");
//    softassert.assertEquals(objadm.login_err_msg(), AutomationConstants.exp_login_err_msg);
	softassert.assertAll();

}
}
