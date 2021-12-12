package executeClasses;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.DashboardPage;
import elementRepository.ListOfPagespage;
import elementRepository.LoginPage;
import utilities.ExcelRead;

public class ExecuteListOfPages extends BaseClass {
	ListOfPagespage listpage;
	DashboardPage dashboard1;
	LoginPage login;
	
	@Test
  public void test1VerifyisNewOpenToCreatePages() throws IOException {
		dashboard1 = new DashboardPage(driver);
		login = new LoginPage(driver);

		login.enterUserName(ExcelRead.readStringData(0, 0));
		login.enterPassword(ExcelRead.readStringData(0, 1));
		login.submitLogin();
				 
		dashboard1.clickManagePages();
		
		listpage.createPage();
		String actualPageTitle=listpage.titleOfCreateNewPage();
		String expectedpageTitle="Add Pages | 7rmart supermarket";
		Assert.assertEquals(actualPageTitle,expectedpageTitle,"WrongPageOpened");
  }
	
	@Test
	  public void tes2VerifySerchOfInvalidData() throws IOException, InterruptedException {
			dashboard1 = new DashboardPage(driver);
			login = new LoginPage(driver);

			login.enterUserName(ExcelRead.readStringData(0, 0));
			login.enterPassword(ExcelRead.readStringData(0, 1));
			login.submitLogin();
					 
			dashboard1.clickManagePages();
			listpage.clickSearch();
			listpage.searchingPages("juju");
			listpage.searchOk();
			String actualMessage=listpage.noSearchResult();
			String expectedMessage=".........RESULT NOT FOUND.......";
			Assert.assertTrue(actualMessage==expectedMessage,"search is present");
			
	  }
	
	@Test
	  public void tes3VerifySerchOfValidData() throws IOException, InterruptedException {
			dashboard1 = new DashboardPage(driver);
			login = new LoginPage(driver);

			login.enterUserName(ExcelRead.readStringData(0, 0));
			login.enterPassword(ExcelRead.readStringData(0, 1));
			login.submitLogin();
					 
			dashboard1.clickManagePages();
			listpage.clickSearch();
			listpage.searchingPages("s1");
			listpage.searchOk();
			String actualMessage=listpage.validSearchResult();
			String expectedMessage="s1";
			Assert.assertTrue(actualMessage==expectedMessage,"search is not present");
			
	  }
	
	@Test
	public void test4VerifyReset() throws IOException, InterruptedException {
		dashboard1 = new DashboardPage(driver);
		login = new LoginPage(driver);
		login.enterUserName(ExcelRead.readStringData(0, 0));
		login.enterPassword(ExcelRead.readStringData(0, 1));
		login.submitLogin();
		dashboard1.clickManagePages();
		listpage.clickReset();
		String actualTitle = listpage.titleOfResetPageHeader();
		String expected = "List Pages | 7rmart supermarket";
		Assert.assertEquals(actualTitle,expected,"Wrong Page Loaded");
	}

	
	
}
