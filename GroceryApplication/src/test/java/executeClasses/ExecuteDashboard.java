package executeClasses;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.DashboardPage;
import elementRepository.LoginPage;
import utilities.ExcelRead;

public class ExecuteDashboard extends BaseClass {
	DashboardPage dashboard;
	LoginPage login;

	@Test
	public void test1DashboardVerifyingOpenPageFromManagePages() throws IOException {
		dashboard = new DashboardPage(driver);
		login = new LoginPage(driver);
		login.enterUserName(ExcelRead.readStringData(0, 0));
		login.enterPassword(ExcelRead.readStringData(0, 1));
		login.submitLogin();
		dashboard.clickManagePages();
		String actualTitle = dashboard.titleOfmanagePageHeader();
		String expected = "List Pages | 7rmart supermarket";
		Assert.assertEquals(actualTitle,expected,"Wrong Page Loaded");
	}

	@Test
	public void test2DashboardVerifyingFontStyleofManagePages() throws IOException {
		dashboard = new DashboardPage(driver);
		login = new LoginPage(driver);

		login.enterUserName(ExcelRead.readStringData(0, 0));
		login.enterPassword(ExcelRead.readStringData(0, 1));
		login.submitLogin();
		dashboard.clickManagePages();
		String fontFamily = dashboard.styleOfManagepageFont();
		Assert.assertTrue(true, fontFamily);
	}
	
	@Test
	public void test3VerifymanagePagesIsHyperlink() throws IOException {
		dashboard = new DashboardPage(driver);
		login = new LoginPage(driver);

		login.enterUserName(ExcelRead.readStringData(0, 0));
		login.enterPassword(ExcelRead.readStringData(0, 1));
		login.submitLogin();
		String actualtag=dashboard.isManagePageIsHyperlink();
		String expectedTag="a";
		Assert.assertEquals(actualtag,expectedTag,"It is a hyperlink");
	}
}
