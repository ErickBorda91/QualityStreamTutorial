package com.qualitystream.tutorial;

import static org.junit.Assert.assertEquals;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;

import org.openqa.selenium.By;

public class SearchTest {

	private WebDriver driver;
	
	@Before
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
	}
	
	@Test
	public void testPage() {
		
		WebElement searchbox = driver.findElement(By.name("q"));
		searchbox.clear();
		searchbox.sendKeys("quality-stream automatizacion de software");
		searchbox.submit();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		assertEquals("quality-stream automatizacion de software", driver.getTitle());
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
}
