package executeClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.LoginPage;
import utilities.ExcelRead;


public class ExecuteLogin extends BaseClass{
	
	LoginPage login;
	
  @Test
  public void test1VerifyLoginedUser() throws IOException {
	  login=new LoginPage(driver);
	  
	  login.enterUserName(ExcelRead.readStringData(0, 0));
	  login.enterPassword(ExcelRead.readStringData(0, 1));
	  login.submitLogin();
	  String actualUserName=login.verifyLoginedUser();
	  String expectedUserName="Admin";
	  Assert.assertEquals(actualUserName, expectedUserName,"Invalid user");
  }
  
  
  
}
