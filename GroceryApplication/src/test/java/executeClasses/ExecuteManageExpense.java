package executeClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.DashboardPage;
import elementRepository.LoginPage;
import elementRepository.ManageExpense;
import utilities.ExcelRead;

public class ExecuteManageExpense extends BaseClass{
	LoginPage login;
	DashboardPage dp1;
	ManageExpense me;
	
	  @Test
	  public void test1VerifySebmenuInManageExpense() throws IOException {
		  login=new LoginPage(driver);
		  dp1=new DashboardPage(driver);
		  me=new ManageExpense(driver);
		  
		  login.enterUserName(ExcelRead.readStringData(0, 0));
		  login.enterPassword(ExcelRead.readStringData(0, 1));
		  login.submitLogin();
		  
		  dp1.clickManageExpense();
		  me.getgManageExpensesSubmenu();
		  
		 // List<String> actual
	  }
}
