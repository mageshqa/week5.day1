package week5.day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TC03Erail extends ProjSpecMethod {

	@Test(priority = -1, timeOut = 5)
	public void erail() {
		// enter from station
		WebElement fromStation = driver.findElement(By.id("txtStationFrom"));
		fromStation.clear();
		fromStation.sendKeys("TPJ" + Keys.ENTER);

		// enter to station
		WebElement toStation = driver.findElement(By.id("txtStationTo"));
		toStation.clear();
		toStation.sendKeys("MS" + Keys.ENTER);

		// uncheck sort by date
		WebElement sortDateBox = driver.findElement(By.id("chkSelectDateOnly"));

		// search trains
		driver.findElement(By.id("buttonFromTo")).click();

		if (sortDateBox.isSelected()) {
			sortDateBox.click();
		}

		// get train names from table

		WebElement trainTable = driver.findElement(By.xpath("(//table[contains(@class,'TrainList ')])[2]"));
		List<WebElement> rowsTrain = trainTable.findElements(By.tagName("tr"));

		for (int i = 0; i < rowsTrain.size(); i++) {
			WebElement colsTrain = rowsTrain.get(i);
			List<WebElement> eachTrainName = colsTrain.findElements(By.tagName("td"));

			// System.out.println("Train names are " + eachTrain.get(1).getText());

			if (eachTrainName.get(1).getText().contains("CHENNAI")) {
				System.out.println(eachTrainName.get(1).getText());
			}

		}

	}

}
