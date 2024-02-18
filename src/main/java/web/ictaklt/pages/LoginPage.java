package web.ictaklt.pages;

import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage {
    WebDriver driver;
    @FindBy(xpath="//option[@value='ST' and text()='ST']")
    WebElement course;
    @FindBy(xpath="//option[text()='KKEM']")
    WebElement proj;
    @FindBy(xpath="//option[text()='Jul_22']")
    WebElement batch;
    @FindBy(xpath="//option[text()='Qualified']")
    WebElement status;
    @FindBy(xpath="//a[@href='/upload']")
    WebElement csvfile;
    @FindBy(xpath="//input[@name='file']")
    WebElement dwldfile;
    @FindBy(xpath="//a[text()='Click here to download a sample csv file']")
    WebElement dwldcsvfile;
    @FindBy(xpath="//span[text()='Placement']")
    WebElement placmt;   
    @FindBy(xpath="//div[@class='container w-75 mt-5 pt-5']/div/table/tbody/tr[2]/td[8]/button")
    WebElement updateplcmt;
    @FindBy(xpath="//select[@name='pstatus']")
    WebElement dropdwn;
    @FindBy(xpath="//div[@class='col col-12 col-sm-12 col-md-9 col-lg-9 col-xl-9 col-xxl-9']/select[@class='form-select' and @name='pstatus']/option[3]")
    WebElement plcmntstatus;
    @FindBy(xpath="//button[contains(text(),'Login')]")
    WebElement logbutton;
    @FindBy(xpath="//button[contains(text(),'Login')]")
    WebElement buttons;
    @FindBy(xpath="//button[contains(text(),'Submit')]")
    WebElement subbutton;
    @FindBy(xpath="//button[contains(text(),'Submit')]")
    WebElement subbtn;
    @FindBy(xpath="//a[@id='basic-nav-dropdown' and @role='button']")
    WebElement admctrl;
    @FindBy(xpath="//a[text()='Logout']")
    WebElement logout;
    @FindBy(xpath="//a[@href='/aadd']")
    WebElement addiconbutton;
    @FindBy(xpath="//select[@name='roleInputs']")
    WebElement roleclick;
    @FindBy(xpath="//option[text()='Admin']")
    WebElement admin;
    @FindBy(xpath="//option[text()='Training Head']")
    WebElement traing;
    @FindBy(xpath="//option[text()='Placement Officer']")
    WebElement plcmt;
    @FindBy(xpath="//button[contains(text(),'Back to Dashboard')]")
    WebElement dashbutton;
    @FindBy(xpath="//button[contains(text(),'OK')]")
    WebElement altbutton;
    @FindBy(xpath="//span[text()='Learners']")
    WebElement learnbutton;
    @FindBy(xpath="//input[@id='learnerid']")
    WebElement lrnid;
    @FindBy(xpath="//input[@id='name']")
    WebElement lrnuname;
    @FindBy(xpath="//a[@href='/tadd']")
    WebElement learniconbutton;
    @FindBy(xpath="//input[@placeholder='Enter your username']//following-sibling::small")
    WebElement uname_err;
    @FindBy(xpath="//small[text()='Password is required.']")
    WebElement passwd_err;
    @FindBy(xpath="//small[text()='Please fill in all fields.']")
    WebElement login_err;
    @FindBy(xpath="//input[@class='form-control' and @id='name']")
    WebElement addpname;
    @FindBy(xpath="//input[@class='form-control' and @id='email']")
    WebElement addmail;
    @FindBy(xpath="//input[@class='form-control' and @id='username']")
    WebElement adduname;
    @FindBy(xpath="//input[@class='form-control' and @id='password']")
    WebElement addpwd;
    @FindBy(xpath="//select[@name='course']")
    WebElement courseclick;
    @FindBy(xpath="//select[@name='project']")
    WebElement projclick;
    @FindBy(xpath="//select[@name='batch']")
    WebElement batchclick;
    @FindBy(xpath="//select[@name='cstatus']")
    WebElement coursestatusclick;
    public LoginPage(WebDriver driver) {
    this.driver=driver;
    PageFactory.initElements(driver, this);

	}
	public void setUsername(String username)
	{
		WebElement uname=driver.findElement(By.xpath("//input[@placeholder='Enter your username']"));
		uname.clear();
		uname.sendKeys(username);
	}
		public void setPassword(String password)
		{
		WebElement pwd=driver.findElement(By.xpath("//input[@placeholder='Enter your password']"));
		pwd.clear();
		pwd.sendKeys(password);
	}
		public String uname_err_msg() 
		{
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(1));
			wait.until(ExpectedConditions.visibilityOf(uname_err));
			String err_uname=uname_err.getText();
			return err_uname      ;
		}
		public String password_err_msg() 
		{
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(1));
			wait.until(ExpectedConditions.visibilityOf(passwd_err));
			String err_pass=passwd_err.getText();
			return err_pass;
		}
		public String login_err_msg() 
		{
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(1));
			wait.until(ExpectedConditions.visibilityOf(login_err));
			String err_log=login_err.getText();
			return err_log;
		}
		public void LoginBtn()
		{
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(50));
			wait.until(ExpectedConditions.visibilityOf(logbutton));
			logbutton.click();
		}
		public boolean signin()
		{
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(50));
			wait.until(ExpectedConditions.visibilityOf(buttons));
			boolean logInvalue=buttons.isEnabled();
			if(buttons.isEnabled())
			{
				buttons.click();
			 	
			}
			
			return logInvalue;
		
		}
		public void Adminctrl()
		{
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(500));
			wait.until(ExpectedConditions.visibilityOf(admctrl));
			admctrl.click();
		}
		public void Logout()
		{
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(100));
			wait.until(ExpectedConditions.visibilityOf(logout));
			logout.click();
		}
		public String checkLoginStatus()

		{

			return driver.findElement(By.xpath("//div[@role='alert']")).getText();

		}

		//ADMIN Page Details.................................
		//add users
		public void AddFormIcon()
		{
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(addiconbutton));
			addiconbutton.click();
		}
		public boolean addName(String addpersonname)
		{
//			WebElement addpname=driver.findElement(By.xpath("//input[@class='form-control' and @id='name']"));
//			addpname.sendKeys(addpersonname);
//			addpname.clear();
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(addpname));
			addpname.clear();
			addpname.sendKeys(addpersonname);
			String namefield=addpname.getAttribute("value");
			Pattern ptrn=Pattern.compile("^[a-zA-Z]*$");  
			Matcher match = ptrn.matcher(namefield); 
			boolean isnamevalid=match.find() && match.group().equals(namefield);
			return (isnamevalid); 
		}
		public boolean addEmail(String addemail)
		{
//			WebElement addmail=driver.findElement(By.xpath("//input[@class='form-control' and @id='email']"));
//			addmail.sendKeys(addemail);
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(addmail));
			addmail.clear();
			addmail.sendKeys(addemail);
			String emailfield=addmail.getAttribute("value");
			Pattern ptrn=Pattern.compile("^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}");  
			Matcher match = ptrn.matcher(emailfield); 
			boolean isemailvalid=match.find() && match.group().equals(emailfield);;
			return (isemailvalid);
		}
		public boolean addUsername(String addusername)
		{
//			WebElement adduname=driver.findElement(By.xpath("//input[@class='form-control' and @id='username']"));
//			adduname.sendKeys(addusername);
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(adduname));
			adduname.clear();
			adduname.sendKeys(addusername);
			String nameandnumfield=adduname.getAttribute("value");
			Pattern ptrn=Pattern.compile("^[a-zA-Z]*$+(0/1)?[7-9][0-9]{9}");  
			Matcher match = ptrn.matcher(nameandnumfield); 
			boolean isnameandnumvalid=match.find() && match.group().equals(nameandnumfield);
			return (isnameandnumvalid);
		}
		public boolean addPassword(String addpassword)
		{
//			WebElement addpwd=driver.findElement(By.xpath("//input[@class='form-control' and @id='password']"));
//			addpwd.sendKeys(addpassword);
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(addpwd));
			addpwd.clear();
			addpwd.sendKeys(addpassword);
			String pwdfield=addpwd.getAttribute("value");
			Pattern ptrn=Pattern.compile("^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}");  
			Matcher match = ptrn.matcher(pwdfield); 
			boolean ispwdvalid=match.find() && match.group().equals(pwdfield);
			return (ispwdvalid);
		}
		public void addRole(String text)
		{
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(roleclick));
			roleclick.click();
			WebElement Admin=driver.findElement(By.xpath("//option[text()='"+text+"']"));
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait1.until(ExpectedConditions.visibilityOf(admin));
	        admin.click();
	        admin.clear();
//	        WebElement Traing=driver.findElement(By.xpath("//option[text()='"+text+"']"));
//			WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
//			wait1.until(ExpectedConditions.visibilityOf(traing));
//	        traing.click();
//	        WebElement Placmt=driver.findElement(By.xpath("//option[text()='"+text+"']"));
//			WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(20));
//			wait1.until(ExpectedConditions.visibilityOf(plcmt));
//	        plcmt.click();
//			Select role = new Select(driver.findElement(By.id("//option[text()='Admin']")));
//			role.selectByVisibleText("Admin");
//			role.selectByIndex(1);
//			if (role.isMultiple())
//		       {
//		         role.selectByIndex(0);
//		         role.selectByValue("1: Admin");
//		       }
//		     else
//		       {
//		         System.out.println("Multiple selection is not possible");
//		       }
		}
		public void SubmitBtn()
		{
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(subbutton));
			subbutton.click();
		}
		public boolean subin()
		{
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(50));
			wait.until(ExpectedConditions.visibilityOf(subbtn));
			boolean subInvalue=buttons.isEnabled();
			if(subbtn.isEnabled())
			{
				subbtn.click();
			 	
			}
			
			return subInvalue;
		}
		
		public void AlertBtn()
		{
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(altbutton));
			altbutton.click();
//			Alert simpleAlert = driver.switchTo().alert();
//			simpleAlert.accept();
			}
//		public boolean AlertBtn()
//		{
//			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(2));
//			wait.until(ExpectedConditions.visibilityOf(altbutton));
//			boolean isalt=altbutton.isEnabled();
//			if(isalt==true)
//			{
//				altbutton.click();
//				Alert alt = driver.switchTo().alert();
//				alt.accept();
//				
//			}
//			//System.out.println(isreg);
//			return isalt;
//		}	
		public void BacktoDash()
		{
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(dashbutton));
			dashbutton.click();
		}
		
		//Learners details.....................
		
		public void Learners()
		{
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(learnbutton));
			learnbutton.click();
		}
		public void LearnersFormIcon()
		{
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(learniconbutton));
			learniconbutton.click();
		}
		public void LearnersForm()
		{
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOf(learnbutton));
			learnbutton.click();
		}
		public boolean LearnId(String learnid)
		{
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOf(lrnid));
			lrnid.clear();
			lrnid.sendKeys(learnid);
			String idfield=lrnid.getAttribute("value");
			Pattern ptrn=Pattern.compile("(0/1)?[7-9][0-9]{9}");  
			Matcher match = ptrn.matcher(idfield); 
			boolean isidvalid=match.find() && match.group().equals(idfield);
			return (isidvalid); 
		}
		public boolean LearnUname(String learnuname)
		{
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOf(lrnuname));
			lrnuname.clear();
			lrnuname.sendKeys(learnuname);
			String namefield=lrnuname.getAttribute("value");
			Pattern ptrn=Pattern.compile("^[a-zA-Z]*$");  
			Matcher match = ptrn.matcher(namefield); 
			boolean isnamevalid=match.find() && match.group().equals(namefield);
			return (isnamevalid); 
		}
	
		public boolean LearnCourse(String text)
		{
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(courseclick));
			courseclick.click();
			WebElement course=driver.findElement(By.xpath("//option[text()='"+text+"']"));
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait1.until(ExpectedConditions.visibilityOf(course));
	        course.click();
			return true;
		}
		public boolean LearnProj(String text)
		{	
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(projclick));
			projclick.click();
			WebElement proj=driver.findElement(By.xpath("//option[text()='"+text+"']"));
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait1.until(ExpectedConditions.visibilityOf(proj));
	        proj.click();
			return true;

//		Select proj = new Select(driver.findElement(By.id("//option[text()='KKEM']")));
//		proj.selectByVisibleText("KKEM");
//		proj.selectByIndex(2);
//		boolean projvalue=proj.isMultiple();
//
//		if (proj.isMultiple())
//	       {
//			proj.selectByIndex(1);
//			proj.selectByValue("2: KKEM");
//	       }
//	     else
//	       {
//	         System.out.println("Multiple selection is not possible");
//	       }
//		return projvalue;
		
		}
		public boolean LearnBatch(String text)
		{
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(batchclick));
			batchclick.click();
			WebElement batch=driver.findElement(By.xpath("//option[text()='"+text+"']"));
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait1.until(ExpectedConditions.visibilityOf(batch));
	        batch.click();
			return true;
//		Select batch = new Select(driver.findElement(By.id("//option[text()='Jul_22']")));
//		batch.selectByVisibleText("Jul_22");
//		batch.selectByIndex(3);
//		boolean batchvalue=batch.isMultiple();
//
//		if (batch.isMultiple())
//	       {
//			batch.selectByIndex(2);
//			batch.selectByValue("3: Jul_22");
//	       }
//	     else
//	       {
//	         System.out.println("Multiple selection is not possible");
//	       }
//		return batchvalue;
		}
		public boolean LearnCourseStatus(String text)
		{
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(coursestatusclick));
			coursestatusclick.click();
//			WebElement status=driver.findElement(By.xpath("//option[text()='"+text+"']"));
//			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
//			wait1.until(ExpectedConditions.visibilityOf(status));
//	        status.click();
//			return true;
//		Select status = new Select(driver.findElement(By.id("//option[text()='Qualified']")));
//		status.selectByVisibleText("Qualified");
//		status.selectByValue("Qualified");
//		
//		return true;
			driver.findElement(By.xpath("//option[text()='Qualified']")).click();
			new Select(driver.findElement(By.id("//option[text()='Qualified']"))).selectByVisibleText("Qualified");
			return true;

		}
		public void Learnercsvfile()
		{
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(csvfile));
			csvfile.click();
//			WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(30));
//			wait1.until(ExpectedConditions.visibilityOf(dwldfile));
//			dwldfile.click();
			WebDriverWait wait2 = new WebDriverWait(driver,Duration.ofSeconds(30));
			wait2.until(ExpectedConditions.visibilityOf(dwldcsvfile));
			dwldcsvfile.click();
}
		// Placement Details............................
		public void Placement()
		{
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(placmt));
			placmt.click();
			WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(30));
			wait1.until(ExpectedConditions.visibilityOf(updateplcmt));
			updateplcmt.click();
		}
		
		public boolean PlacementStatus(String text)
		{
			
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(dropdwn));
			dropdwn.click();
			WebElement plcmntstatus=driver.findElement(By.xpath("//option[text()='"+text+"']"));
			WebDriverWait waitp = new WebDriverWait(driver, Duration.ofSeconds(20));
			waitp.until(ExpectedConditions.visibilityOf(plcmntstatus));
			plcmntstatus.click();
			return true;
			
		}
}