package week5.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ServiceNowTC4 extends SrvcNwProjSpecMethod {

	@Test
	public void servicenowTC4() {

		// click new button
		driver.switchTo().frame(0);
		Actions action = new Actions(driver);

		// search existing ticket
		WebElement search = driver.findElement(By.xpath("(//a[text()='State'])[1]"));
		action.moveToElement(search).click().perform();
		driver.findElement(By.xpath("(//td[@class='vt'])[1]/a")).click();
		WebElement incidentNum = driver.findElement(By.id("incident.number"));
		String incidentNumber = incidentNum.getAttribute("value");
		System.out.println(incidentNumber);
		// delete incident
		driver.findElement(By.id("sysverb_delete")).click();
		driver.findElement(By.id("ok_button")).click();

		// verify deleted incident
		// sort by number

		// WebElement number =
		// driver.findElement(By.xpath("(//a[text()='Number'])[1]"));
		// action.moveToElement(number).click().perform();
		// driver.switchTo().frame(0);
		// driver.findElement(By.xpath("//select[@class='form-control
		// default-focus-outline']"))
		// .sendKeys("N" + Keys.TAB + incidentNumber + Keys.ENTER);
		// driver.findElement(By.xpath("//option[text()='Number']")).click();
		// driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(incidentNumber
		// + Keys.ENTER);

		/*
		 * WebElement noRec =
		 * driver.findElement(By.xpath("//tr[@class='list2_no_records']/td")); if
		 * (noRec.getText().contains("no records")) { System.out.println("Incident " +
		 * incidentNumber + " is Deleted."); }
		 */

	}

}
