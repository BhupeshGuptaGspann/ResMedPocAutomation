package com.resmed.automation.util;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestUtil {

	private final static Logger log = LogManager.getLogger(TestUtil.class);
	public static long PAGE_LOAD_TIME = 50;
	public static long IMPLICTI_WAIT = 50;
	public static WebDriverWait wait;
	protected static WebDriver driver;
	protected static Properties testProp;

	public void type(By loc, String value) {
		log.info("Waiting for element: " + loc);
		WebElement element = waitForElementPresent(loc);
		log.info("element found: " + loc);
		element.sendKeys(value);
		log.info("Typing '" + value + "' into " + loc);
	}

	public void click(By loc) {
		log.info("Waiting for element: " + loc);
		WebElement element = waitForElementPresent(loc);
		log.info("element found: " + loc);
		element.click();
	}

	public boolean textEqualTo(By loc, String value) {
		return waitForElementPresent(loc).getText().equals(value);
	}

	public boolean textEqual(String value1, String value2) {
		return value1.equals(value2);
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public WebElement waitForElementPresent(By loc) {
		wait = new WebDriverWait(driver, PAGE_LOAD_TIME);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(loc));
	}

	public boolean isElementPresent(By loc) {
		WebElement element = waitForElementPresent(loc);
		return element.isDisplayed();
	}

	public List<String> getList(By loc) {
		List<WebElement> elements = driver.findElements(loc);
		List<String> list = new ArrayList<String>();
		for (WebElement element : elements) {
			list.add(element.getText());
		}
		return list;

	}

	public void getSelect(By loc, String value) {
		WebElement element = waitForElementPresent(loc);
		Select dropDown = new Select(element);
		dropDown.selectByVisibleText(value);
	}

	public String takeScreenshotAtEndOfTest() throws IOException {

		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		File destinationFile = new File(currentDir + "//screenshots//" + System.currentTimeMillis() + ".png");
		FileUtils.copyFile(srcFile, destinationFile);
		;
		return destinationFile.toString();
	}

	public void handleAlert() {
		driver.switchTo().alert().accept();
	}

	public boolean verifyAlertText(String message) {
		click(By.xpath("//div[@class='login-center']//*[@title='LOGIN']"));
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println(alertText);
		return textEqual(alertText, message);

	}

	public String getText(By loc) {
		log.info("Waiting for element: " + loc);
		WebElement element = waitForElementPresent(loc);
		log.info("element found: " + loc);
		String product = element.getAttribute("innerHTML");
		return product;
	}

	public String getQuantVal(By loc) {
		log.info("Waiting for element: " + loc);
		WebElement element = waitForElementPresent(loc);
		log.info("element found: " + loc);
		String quantity = element.getAttribute("value");
		return quantity;
	}

	public void clickByJs(By loc) {
		log.info("Waiting for element: " + loc);
		WebElement element = waitForElementPresent(loc);
		log.info("element found: " + loc);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	public void changeDisbaleVal(By loc) {
		log.info("Waiting for element: " + loc);
		WebElement element = waitForElementPresent(loc);
		log.info("element found: " + loc);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('disabled', 'false')", element);
	}

	public void clear(By loc) {
		log.info("Waiting for element: " + loc);
		WebElement element = waitForElementPresent(loc);
		log.info("element found: " + loc);
		element.clear();
	}

	public static void enterByKeyBoard() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

	}
	public void clickByMouse(By loc) {
		log.info("Waiting for element: " + loc);
		WebElement element = waitForElementPresent(loc);
		log.info("element found: " + loc);
		Actions action = new Actions(driver);
		action.moveToElement(element).click().build().perform();
	}
}
