package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage_PF {
	WebDriver driver;
	
	@FindBy(id = "react-burger-menu-btn")
	WebElement btn_Menu;
	
	@FindBy(id = "logout_sidebar_link")
	WebElement btn_Logout;
	
	public HomePage_PF() {
    }
	
	public HomePage_PF(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver,this);		
	}
	
	// Functions
	public void clickMenu(String menu) {
		btn_Menu.click();
	}
	
	public void clickLogout(String logout) {
		btn_Logout.click();
	}
}
