package week5.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProjSpecMethod {

	public RemoteWebDriver driver;

	@Parameters({ "url", "browser", "username", "pswd" })
	@BeforeTest
	public void beforeTest(String url, String browser, String username, String pswd) {
		// setup browser and driver
		if (browser.equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		}

		else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		}

		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// login service now
		driver.switchTo().frame(0);
		driver.findElement(By.id("user_name")).sendKeys(username);
		driver.findElement(By.id("user_password")).sendKeys(pswd);
		driver.findElement(By.id("sysverb_login")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// search for incident
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("filter")));
		driver.findElement(By.id("filter")).sendKeys("incident");

		// click all
		driver.findElement(By.xpath("(//div[text()='All'])[2]")).click();

	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
