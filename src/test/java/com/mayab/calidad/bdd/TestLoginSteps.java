package com.mayab.calidad.bdd;


import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;



public class TestLoginSteps {
	  private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	  
	
	@Given("Browser is open")
	public void browser_is_open() {
		    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Usuario\\Desktop\\6to_semestre\\Calidad y pruebas de software\\chromedriver_win32\\chromedriver.exe");
		    driver = new ChromeDriver();
		    baseUrl = "https://www.google.com/";
		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Given("user is in login page")
	public void user_is_in_login_page() {
		driver.get("https://example.testproject.io/web/");
	}

	@When("user enters (.*) and (.*)$")
	public void user_enters_username_and_password(String user, String pass) {

	    driver.findElement(By.id("name")).sendKeys(user);
	    driver.findElement(By.id("password")).sendKeys(pass);

	}
	
	@When("user clicks login button")
	public void user_clicks_login_button() {
	    driver.findElement(By.id("login")).click();
	}

	@Then("website shows main page")
	public void website_shows_main_page() {
		assertEquals("Logout",driver.findElement(By.id("logout")).getText());
		driver.close();
		driver.quit();
	}

}
