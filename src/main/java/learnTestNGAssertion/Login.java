package learnTestNGAssertion;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Login {
	@Test
	public void login() {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://letcode.in/");
		String title = driver.getTitle();
		String expectedTitle = "LetCode";
		// hard assert
		Assert.assertEquals(title, expectedTitle); 
		assertTrue(title.equals(expectedTitle));
		WebElement loginBtn = driver.findElementByLinkText("Log in");
		Assert.assertTrue(loginBtn.isDisplayed());

		// soft assert
		SoftAssert sftassert = new SoftAssert();
		sftassert.assertEquals(title, expectedTitle);
		sftassert.assertTrue(loginBtn.isDisplayed());

		sftassert.assertAll();
		driver.quit();
	}
}
