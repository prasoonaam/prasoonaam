package ictakLT;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import web.ictaklt.pages.LoginPage;
public class TestTrainer extends TestBase {
	LoginPage objadm=null;
	SoftAssert softassert=new SoftAssert();

@Test(priority=1)
public void ValidTestcaseLogin() throws InterruptedException
{
	objadm=new LoginPage(driver);
	objadm.setUsername("trainer");
	objadm.setPassword("trainer@123"); 
	objadm.LoginBtn();
//    obj.Logout();
}
@Test (priority=2)
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
//    obj.Logout();
}

}
