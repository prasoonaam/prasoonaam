package ictakLT;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import web.ictaklt.pages.LoginPage;

public class TestAdminAddUser extends TestBase {
	LoginPage objadm=null;
	SoftAssert softassert=new SoftAssert();
	SoftAssert softassert1=new SoftAssert();
	//Add user
	@Test(priority=1)
	public void ValidTestcaseAddUser() throws InterruptedException
	{
		objadm=new LoginPage(driver);
	    objadm.setUsername("admin");
	    objadm.setPassword("Admin@123");
	    objadm.LoginBtn();
	    objadm.AddFormIcon();
	    boolean act_name=objadm.addName("mary");
	    softassert.assertTrue(act_name,"Must contain letters only");
	    boolean act_email=objadm.addEmail("prasoona23@gmail.com");
	    softassert.assertTrue(act_email,"Must be a valid Email ID");
	    boolean act_uname=objadm.addUsername("prasoona23");
	    softassert.assertTrue(act_uname,"Must be min 5 characters with alphabets and numbers only");
	    boolean act_pwd=objadm.addPassword("prasoona@2");
	    softassert.assertTrue(act_pwd,"Must be a minimum of 8 characters long and include at least one letter, one special character (@$!%*?&), and one number.");
	    objadm.addRole("Admin");
	    objadm.SubmitBtn();
	    objadm.AlertBtn();
		softassert.assertAll();
//	    obj.Logout();
	}
//	@Test(priority=2)
	public void InValidTestcaseAddUser() throws InterruptedException
	{
	    objadm.AddFormIcon();
	    boolean act_name=objadm.addName("jj8");
	    softassert1.assertTrue(act_name,"Must contain letters only");
	    boolean act_email=objadm.addEmail("prasoonagmail.com");
	    softassert1.assertTrue(act_email,"Must be a valid Email ID");
	    boolean act_uname=objadm.addUsername("prasoona23");
	    softassert1.assertTrue(act_uname,"Must be min 5 characters with alphabets and numbers only");
	    boolean act_pwd=objadm.addPassword("prasoona@2");
	    softassert1.assertTrue(act_pwd,"Must be a minimum of 8 characters long and include at least one letter, one special character (@$!%*?&), and one number.");
	    objadm.addRole("Admin");
 		softassert1.assertFalse(objadm.subin(),"submit button is enabled");
//	    objadm.AlertBtn();
		softassert1.assertAll();
//	    obj.Logout();
	}
	@Test(priority=2)
	public void ValidTestcaseLearner() throws InterruptedException
	{
	    objadm.Learners();
	    objadm.LearnersFormIcon();
	    boolean act_idnum=objadm.LearnId("123");
	    softassert.assertTrue(act_idnum,"Must contain letters,numbers and - only");
	    boolean act_uname=objadm.LearnUname("prasoonaam");
	    softassert.assertTrue(act_uname,"Must contain letters only");
	    boolean act_course=objadm.LearnCourse("ST");
	    softassert.assertTrue(act_course,"Please select a course for the learner");
	    boolean act_proj=objadm.LearnProj("KKEM");
	    softassert.assertTrue(act_proj,"Please select a project for the learner");
	    boolean act_batch=objadm.LearnBatch("Jul_22");
	    softassert.assertTrue(act_batch,"Please select a batch for the learner");
	    boolean act_status=objadm.LearnCourseStatus("Jul_22");
	    softassert.assertTrue(act_status,"Please select the course status of the learner");
	    objadm.SubmitBtn();
	    objadm.AlertBtn();
		objadm.Learnercsvfile();
		softassert.assertAll();
//	    obj.Logout();
	}
	@Test(priority=3)
	public void ValidTestcasePlacement() throws InterruptedException
	{
	    objadm.Placement();
	    boolean act_status=objadm.PlacementStatus("Job Seeking");
	    softassert.assertTrue(act_status,"-select-");
	    objadm.SubmitBtn();
	    objadm.AlertBtn();
	    objadm.Learners();
	    objadm.Logout();
		softassert.assertAll();	
	}
}
