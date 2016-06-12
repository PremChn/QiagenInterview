package com.Qiagen.interview;

/*Automate the following testcase using Webdriver
1.	Open http://www.hotwire.com/ website
2.	Select flight+hotel+car search
3.	Enter flight from SFO to LAX
4.	Departing next day, returning 20 days after
(note: “next day” and “20 days” should be calculated dynamically, not hard-coded)
5.	Departing evening, returning morning
6.	Click find package
7.	Verify that there is at least one result returned*/


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class hotWire {
	public static void main(String args[]) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, 1);
		String departureDate = new SimpleDateFormat("MM/dd/yy").format(calendar.getTime());
		calendar.add(Calendar.DATE, 20);
		String returningDate = new SimpleDateFormat("MM/dd/yy").format(calendar.getTime());
		String origin = "SFO";
		String destination = "LAX";

		ChromeOptions co = new ChromeOptions();
		co.addArguments("--start-maximized");
		System.setProperty("webdriver.chrome.driver", "/Users/NIS1600/Documents/workspace/Qiagen/chromedriver");
		WebDriver driver = new ChromeDriver();

		// WebDriver driver = new FirefoxDriver();
		// WebDriverWait wait = new WebDriverWait(driver, 30);
		// driver.manage().window().maximize();

		driver.get("https://www.hotwire.com/");
		driver.findElement(By.id("genRandom9-ACHRadio")).click();
		driver.findElement(By.cssSelector("input[id=genRandom9-origCity]")).sendKeys(origin);
		driver.findElement(By.cssSelector("input[id=genRandom9-destCity]")).sendKeys(destination);
		driver.findElement(By.cssSelector("input[id=startDateCalendarVacation-field]")).sendKeys(departureDate);
		driver.findElement(By.cssSelector("input[id=endDateCalendarVacation-field]")).sendKeys(returningDate);
		List<WebElement> deptTime = driver.findElements(By.cssSelector("a[id=vacationExtendedStartTime-button]"));
		java.util.Iterator<WebElement> i = deptTime.iterator();
		while (i.hasNext()) {
			WebElement ele = i.next();
			if (ele.getText().equals("Anytime")) {
				ele.click();
				driver.findElement(By.cssSelector("a[id=ui-id-14]")).click();
			}
		}
		List<WebElement> returnTime = driver.findElements(By.cssSelector("a[id=vacationExtendedEndTime-button]"));
		java.util.Iterator<WebElement> j = returnTime.iterator();
		while (j.hasNext()) {
			WebElement ele = j.next();
			if (ele.getText().equals("Anytime")) {
				ele.click();
				driver.findElement(By.cssSelector("a[id=ui-id-44]")).click();
			}
		}
		driver.findElement(By.id("findVacationButton")).click();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2[id=TA_hotelName_0]")));
		String searchResult = driver.findElement(By.cssSelector("h2[id=TA_hotelName_0]")).getText();
		if (searchResult.isEmpty()) {
			System.out.println("There is no flight and hotel available for the given search data");
		} else {
			System.out.println("Flights and Hotels are available for the given search data");
		}
		driver.quit();
	}
}