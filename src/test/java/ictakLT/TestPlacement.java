package ictakLT;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import web.ictaklt.pages.LoginPage;

public class TestPlacement extends TestBase {
	LoginPage objadm=null;
	SoftAssert softassert=new SoftAssert();

@Test(priority=1)
public void ValidTestcase() throws InterruptedException
{
	objadm=new LoginPage(driver);
	objadm.setUsername("pofficer");
	objadm.setPassword("pofficer@123"); 
	objadm.LoginBtn();
//    obj.Logout();
}
@Test(priority=2)
public void ValidTestcasePlacement() throws InterruptedException
{
    objadm.Placement();
    boolean act_status=objadm.PlacementStatus("Job Seeking");
    softassert.assertTrue(act_status,"-select-");
    objadm.SubmitBtn();
//    objadm.AlertBtn();
//    objadm.Logout();
	softassert.assertAll();	
}
}
