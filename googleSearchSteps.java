package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;



public class GoogleSearchSteps {
	
	WebDriver driver = null;
	
	@Given("browser is open")
	public void browser_is_open() {
	   System.out.println("Inside Step: browser is open");
	   
	   String projectPath = System.getProperty("user.dir"); // Used to give relative property for this project i.e. "Cucumber Java"
	   System.out.println("Project path is" + projectPath);	// Just to be sure we print it
	   
	   System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/Drivers/chromedriver.exe");
	   
	   driver =  new ChromeDriver();
	   
	   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	   
	   driver.manage().window().maximize();
	}

	@And("user is on google search page")
	public void user_is_on_google_search_box() {
		   System.out.println("Inside Step: user is on google search page");
		   
		   driver.navigate().to("https://google.com"); // Used to navigate to the search page
	}

	@When("user enters text in search box")
	public void user_enters_text_in_search_box() {
		System.out.println("Inside Step: user enters text in search box");
		
		driver.findElement(By.name("q")).sendKeys("Automation Step by Step");
	}

	@And("hits enter")
	public void hits_enter() {
		System.out.println("Inside Step: hits enter");
		
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	}

	@Then("user is navigated to the search results")
	public void user_is_navigated_to_the_search_results() {
		System.out.println("Inside Step: user is navigated to the search results");
		
		driver.getPageSource().contains("Online Courses");
		
		driver.close();
		driver.quit();
	}
}
