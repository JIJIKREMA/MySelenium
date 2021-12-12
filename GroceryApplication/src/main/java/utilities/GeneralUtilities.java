package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class GeneralUtilities {
	

	public String getElementText(WebElement textElement) {
		String text = textElement.getText();
		return text;
	}
	

	public void ClickOnElement(WebElement clickElement) {
		clickElement.click();

	}
	

	public void typeOnElement(WebElement inputElement, String text) {
		inputElement.sendKeys(text);
	}
	
	
	public String getPageTitle(WebDriver driver){
		return driver.getTitle();
	}
	

	public String getElementCSSValue(WebElement styleElement, String cssAttribute ) {
		
		String cssValue = styleElement.getCssValue(cssAttribute);
		return cssValue;
	}
	
	
	public void selectDropDownOnElement(WebElement element,String drpdownValue) {
		Select selectValue=new Select(element);
		selectValue.selectByValue(drpdownValue);
	}
	
	
	public void verticalScroll(WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(400,0)");
	}
	
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public String getElementTagNmae(WebElement elementAttribute) {
		return elementAttribute.getTagName();
	}
}
