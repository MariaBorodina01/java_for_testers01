import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Dimension;

public class ContactRemovalTests {
  private WebDriver driver;

  @BeforeEach
  public void setUp() {
    driver = new FirefoxDriver();
    driver.get("http://localhost/addressbook/");
    driver.findElement(By.name("user")).click();
    driver.findElement(By.name("user")).sendKeys("admin");
    driver.findElement(By.name("pass")).click();
    driver.findElement(By.name("pass")).sendKeys("secret");
    driver.findElement(By.cssSelector("input:nth-child(7)")).click();
  }

  @AfterEach
  public void tearDown() {
    driver.findElement(By.linkText("Logout")).click();
    driver.manage().window().setSize(new Dimension(784, 844));
    driver.quit();
  }

  @Test
  public void canRemoveContact() {
    if (!IsElemetPresent(By.name("searchstring"))) {
      driver.findElement(By.xpath("//a[contains(.,'add new')]")).click();
    }
    if (!IsElemetPresent(By.name("selected[]"))) {
      driver.findElement(By.xpath("//a[contains(.,'add new')]")).click();
      driver.findElement(By.name("firstname")).click();
      driver.findElement(By.name("firstname")).sendKeys("FirstName");
      driver.findElement(By.name("lastname")).click();
      driver.findElement(By.name("lastname")).sendKeys("LastName");
      driver.findElement(By.name("address")).click();
      driver.findElement(By.name("address")).sendKeys("Address");
      driver.findElement(By.name("home")).click();
      driver.findElement(By.name("home")).sendKeys("1111");
      driver.findElement(By.name("work")).click();
      driver.findElement(By.name("mobile")).click();
      driver.findElement(By.name("mobile")).sendKeys("2222");
      driver.findElement(By.name("fax")).click();
      driver.findElement(By.name("work")).click();
      driver.findElement(By.name("work")).sendKeys("3333");
      driver.findElement(By.name("theform")).click();
      driver.findElement(By.name("email")).click();
      driver.findElement(By.name("email")).sendKeys("mail1@mail.ru");
      driver.findElement(By.name("email2")).click();
      driver.findElement(By.name("email2")).sendKeys("mail2@mail.ru");
      driver.findElement(By.name("email3")).click();
      driver.findElement(By.name("email3")).sendKeys("mail3@mail.ru");
      driver.findElement(By.xpath("//input[@name='submit']")).click();
      driver.findElement(By.linkText("home page")).click();
    }
    driver.findElement(By.name("selected[]")).click();
    driver.findElement(By.xpath("//input[@value=\'Delete\']")).click();
    driver.findElement(By.linkText("home")).click();

  }

  private boolean IsElemetPresent(By locator) {
    try {
      driver.findElement(locator);
      return true;
    } catch (NoSuchElementException exception) {
      return false;
    }
  }
}
