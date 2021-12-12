package elementRepository;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManageExpense {

	WebDriver driver;
	GeneralUtilities utility = new GeneralUtilities();

	public ManageExpense(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	} 
	
	
	
	
	public List<String> getgManageExpensesSubmenu() {
	List<WebElement> mngeExpense = driver.findElements(By.xpath("//li[contains(@class,'nav-item has-treeview menu')]//li//a//p"));
	List<String> listElementText = new ArrayList<String>();
	
		for(int i=0;i<mngeExpense.size();i++) {
		//List<String> actualresult= mngeExpense.add(get(i).getText();
			//System.out.println(mngeExpense.get(i));
			
			

			for(int j = 0;j<mngeExpense.size();j++)
			{
				listElementText.add(mngeExpense.get(i).getText());
			}
			System.out.println(listElementText.get(i));
					
		
	}
	return listElementText;
	
	//List<String> expectedResult = new List<String>{"dsfgd"}
	}
//	
	
//
//	

	
}
