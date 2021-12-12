package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExplicitWait;
import utilities.GeneralUtilities;
import utilities.ManageWaitSleep;

public class ListOfPagespage {
	WebDriver driver;
	GeneralUtilities utility2 = new GeneralUtilities();
	ManageWaitSleep mws= new ManageWaitSleep();
	ExplicitWait explicit1= new ExplicitWait();

	DashboardPage dashboard1;

	ListOfPagespage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement createNewPage;

	@FindBy(xpath = "//a[contains(text(),' Search')]")
	WebElement searchPage;

	@FindBy(xpath = "//a[contains(text(),' Reset')]")
	WebElement pageReset;
	
	@FindBy(xpath="//input[@placeholder='Title']")
	WebElement searchTitle;
	
	@FindBy(xpath="//button[@class='btn btn-danger btn-fix']")
	WebElement searchingSubmit;
	
	@FindBy(xpath="//tr//td//span[@id='res']//center[contains(text(),'.........RESULT NOT FOUND.......')]")
	WebElement resultNotFound;
	
	@FindBy(xpath="//table//tbody//td[contains(text(),'s1')]")
	WebElement searchResult;
	
	@FindBy(xpath="//table//tbody//tr[1]//td[5]//a[@href='https://groceryapp.uniqassosiates.com/admin/pages/edit?edit=42&page_ad=1']")
	WebElement listEdit;
	
	public void createPage() {

		createNewPage.click();
		try {
			mws.moreWait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickSearch() throws InterruptedException {
		mws.moreWait();
		searchPage.click();
	}
	
	public String titleOfCreateNewPage() {
		
		return utility2.getPageTitle(driver);
	}
	
	public void searchingPages(String searchTitl) {
		utility2.typeOnElement(searchTitle,searchTitl);
				
	}
	
	public void searchOk() {
		utility2.ClickOnElement(searchingSubmit);
		
	}
	public String noSearchResult() {
		explicit1.checkPresenceOfElement(driver, "//tr//td//span[@id='res']//center[contains(text(),'.........RESULT NOT FOUND.......')");
		return utility2.getElementText(resultNotFound);
	}
	
	public String validSearchResult() {
		explicit1.checkPresenceOfElement(driver, "//table//tbody//td[contains(text(),'s1')]");
		return utility2.getElementText(searchResult);
	}
	
	public void clickReset() throws InterruptedException {
		mws.moreWait();
		searchPage.click();
	}
	
	public String titleOfResetPageHeader() {
		return utility2.getPageTitle(driver);
	}
	
	public void clickDataEdit() {
		explicit1.checkPresenceOfElement(driver, "//table//tbody//tr[1]//td[5]//a[@href='https://groceryapp.uniqassosiates.com/admin/pages/edit?edit=42&page_ad=1']");
		utility2.ClickOnElement(listEdit);
	}
	
	
	
}
