package elementRepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExplicitWait;
import utilities.GeneralUtilities;

public class LoginPage {
WebDriver driver;

public LoginPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	
}

GeneralUtilities utility=new GeneralUtilities();
ExplicitWait excplicit=new ExplicitWait();

@FindBy(xpath="//input[@name='username']")
WebElement userName;

@FindBy(xpath="//input[@name='password']")
WebElement password;

@FindBy(xpath="//button[@type='submit']")
WebElement loginButton;

@FindBy(xpath="//a[@data-toggle='dropdown']")
WebElement loginedUser;

public void enterUserName(String uname) {
	utility.typeOnElement(userName, uname);
}

public void enterPassword(String pwd) {
	utility.typeOnElement(password, pwd);
}

public void submitLogin() {
	
	excplicit.checkPresenceOfElement(driver, "//button[@type='submit']");
	utility.ClickOnElement(loginButton);
	
}



public String verifyLoginedUser() {
	
	excplicit.elementTobeClickable(driver, loginedUser);
	String loginedUserName=utility.getElementText(loginedUser);
	return loginedUserName;
	
}




}
