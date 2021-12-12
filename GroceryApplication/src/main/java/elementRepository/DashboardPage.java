package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class DashboardPage {

	WebDriver driver;
	GeneralUtilities utility=new GeneralUtilities();

	public DashboardPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-page'])[2]")
	WebElement managePages;
	
	@FindBy(xpath="//div[@class='content-header']//div[@class='container-fluid']//h1")
	WebElement managePagesList;
	
	@FindBy(xpath="(//ul[@class='nav nav-pills nav-sidebar flex-column']//li[2]//a[1])[1]")
	WebElement manageExpense;
	
		
	public void clickManagePages() {
		utility.ClickOnElement(managePages);
	}
	
	public String titleOfmanagePageHeader() {
		return utility.getPageTitle(driver);
	}
	
	public String styleOfManagepageFont() {
		return utility.getElementCSSValue(managePages, "font-family");
	}
	
	public String isManagePageIsHyperlink() {
		return utility.getElementTagNmae(managePages);   
	}
	
	public void clickManageExpense() {
		utility.ClickOnElement(manageExpense);
	}
	
}
