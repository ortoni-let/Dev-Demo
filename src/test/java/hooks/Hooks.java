package hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.AfterStep;
import cucumber.api.java.Before;
import cucumber.api.java.BeforeStep;

public class Hooks extends DriverInstance{
	
	@BeforeStep
	public void beforeEachStep(){
		
	}
	
	@AfterStep
	public void afterEachStep() {
		
	}
	
	@Before
	public void beforeScenario(Scenario sc) {
		driver = new ChromeDriver();
		driver.get("https://dev103006.service-now.com/");
		byte[] screenshotAs = driver.getScreenshotAs(OutputType.BYTES);
		sc.embed(screenshotAs, "image/png");
		System.out.println("Result is "+sc.getStatus());
		String name = sc.getName();
		System.out.println("Scenario Name: "+name);
	}
	
	@After
	public void afterScenario(Scenario sc) {
		byte[] screenshotAs = driver.getScreenshotAs(OutputType.BYTES);
		sc.embed(screenshotAs, "image/png");
		System.out.println("Result is "+sc.getStatus());
		driver.quit();
	}

}
