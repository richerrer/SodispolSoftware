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
    Thread.sleep(2000);
    driver.findElement(By.linkText("Paciente")).click();
    Thread.sleep(2000);
    driver.findElement(By.id("j_idt14:paramBusqueda")).clear();
    driver.findElement(By.id("j_idt14:paramBusqueda")).sendKeys("201013448");
    Thread.sleep(2000);
    driver.findElement(By.id("j_idt14:buscarPaciente")).click();
    Thread.sleep(2000);
    driver.findElement(By.id("botonesFicha:nuevaObservacion")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [waitForPopUp | _self | 30000]]
    driver.findElement(By.xpath("//a[@id='form:toggleable2_toggler']/span")).click();
    Thread.sleep(2000);
    driver.findElement(By.cssSelector("span.ui-icon.ui-icon-minusthick")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//a[@id='form:toggleable3_toggler']/span")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//a[@id='form:toggleable4_toggler']/span")).click();
    Thread.sleep(2000);
    driver.findElement(By.name("form:j_idt175")).clear();
    driver.findElement(By.name("form:j_idt175")).sendKeys("buena");
    Thread.sleep(2000);
    driver.findElement(By.id("form:buscarPaciente")).click();
    Thread.sleep(2000);
    driver.findElement(By.id("form:j_idt173")).click();
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
}
*/