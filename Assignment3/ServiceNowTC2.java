package week5.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class ServiceNowTC2 extends SrvcNwProjSpecMethod {

	@Test
	public void servicenowTC2() {
		// click new button
		driver.switchTo().frame(0);
		Actions action = new Actions(driver);

		// search existing ticket
		WebElement search = driver.findElement(By.xpath("(//a[text()='State'])[1]"));
		action.moveToElement(search).click().perform();
		driver.findElement(By.xpath("(//td[@class='vt'])[1]/a")).click();
		WebElement incidentNum = driver.findElement(By.id("incident.number"));
		String incidentNumber = incidentNum.getText();

		// select urgency
		WebElement urgency = driver.findElement(By.id("incident.urgency"));
		Select selectUrgency = new Select(urgency);
		selectUrgency.selectByVisibleText("1 - High");

		// select state
		WebElement state = driver.findElement(By.id("incident.state"));
		Select selectState = new Select(state);
		selectState.selectByVisibleText("In Progress");

		// click update
		driver.findElement(By.id("sysverb_update")).click();

		// search existing ticket
		driver.findElement(By.xpath("(//a[text()='Number'])[1]")).click();
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(incidentNumber + Keys.ENTER);

		System.out.println("Updated Priority of " + incidentNumber + " is "
				+ driver.findElement(By.xpath("(//td[@class='vt'])[5]")).getText());

		System.out.println("Updated State of " + incidentNumber + " is "
				+ driver.findElement(By.xpath("(//td[@class='vt'])[6]")).getText());

	}

}
