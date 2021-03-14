package steps;

import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import hooks.DriverInstance;

public class LoginSteps extends DriverInstance{
	
//	public ChromeDriver driver;
	
//	@Given("Launch browser")
//	public void launchBrowser() {
//		driver = new ChromeDriver();
//	}
//
//	@Given("Load the URL")
//	public void loadTheURL() {
//	    driver.get("https://dev103006.service-now.com/");
//	}

	@When("user enter the username as {string}")
	public void userEnterTheUsernameAsAdmin(String name) {
		driver.switchTo().frame("gsft_main");
	    driver.findElementById("user_name").sendKeys(name);
	}

	@When("user enter the password as {string}")
	public void userEnterThePasswordAsPassword(String pass) {
		driver.findElementById("user_password").sendKeys(pass);
	}

	@When("user clicks the login button")
	public void userClicksTheLoginButton() {
	   driver.findElementByXPath("//*[@id='sysverb_login']").click();
	}

	@Then("user must see the dashboard page")
	public void userMustSeeTheDashboardPage() {
	   System.out.println(driver.getTitle());
//	   driver.quit();
	}
	
	@When("login should fail")
	public void loginShouldFail() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String text = driver.findElementByClassName
				("dp-invalid-login-msg")
		.getText();
		if(text.contains("User name or password invalid.")) {
			System.out.println("Expected and actual match");
		}else {
			throw new RuntimeException();
		}
	}

}
