/*package selenium;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Test1 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost:8090/SodispolSoftware/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    
  }

  @Test
  public void test1() throws Exception {
    driver.get(baseUrl);
    driver.findElement(By.linkText("Cita")).click();
    driver.findElement(By.linkText("Nueva Cita")).click();
    driver.findElement(By.id("j_idt10:paramBusqueda")).clear();
    driver.findElement(By.id("j_idt10:paramBusqueda")).sendKeys("201045878");
    driver.findElement(By.id("j_idt10:buscarPaciente")).click();
    driver.findElement(By.id("j_idt10:selectMedico_label")).click();
    driver.findElement(By.xpath("//div[@id='j_idt10:selectMedico_panel']/div/ul/li[2]")).click();
    driver.findElement(By.id("infoCita:seded:0:agregar")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}*/
