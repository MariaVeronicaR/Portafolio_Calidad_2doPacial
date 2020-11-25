package com.mayab.calidad.funcional;


import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.Select;

public class TestFacebook {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Usuario\\Desktop\\6to_semestre\\Calidad y pruebas de software\\chromedriver_win32\\chromedriver.exe");
    driver = new ChromeDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testUntitledTestCase() throws Exception {
	  driver.get("https://www.facebook.com/?stype=lo&jlou=AfczbEbOaBD9ODpR4bJfNMievPb-Bb6zlQD4O7yZ2kgfOzkV8LD98v77JuF4h5H4AzUbjhJXL_MHC-I8nb-G6zHw&smuh=19950&lh=Ac8xkDU9Bhri03SUxus");
	    driver.findElement(By.id("email")).click();
	    driver.findElement(By.id("email")).clear();
	    driver.findElement(By.id("email")).sendKeys("veronica@gmail.com");
	    driver.findElement(By.id("pass")).click();
	    driver.findElement(By.id("pass")).clear();
	    driver.findElement(By.id("pass")).sendKeys("jdienfruw");
	    driver.findElement(By.id("u_0_b")).click();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.print(driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div[2]/div[2]/form/div/div[2]/div[2]")).getText());

        assertEquals("La contraseña que ingresaste es incorrecta. ¿Olvidaste tu contraseña?", driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div[2]/div[2]/form/div/div[2]/div[2]")).getText());
  }
  
  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }


}
