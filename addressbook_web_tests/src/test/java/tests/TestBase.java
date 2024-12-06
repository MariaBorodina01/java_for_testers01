package tests;

import manager.ApplicationManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

    protected static ApplicationManager app;
    protected static WebDriver driver;

    @AfterAll
    public static void tearDown() {
//        driver.findElement(By.linkText("Logout")).click();
        ContactCreationTests.driver.quit();
    }

    protected static void createContact(String first_name, String last_name, String home_address, String home_phone, String mobile_phone, String work_phone, String mail1, String mail2, String mail3) {
        driver.findElement(By.name("first_name")).click();
        driver.findElement(By.name("first_name")).sendKeys(first_name);
        driver.findElement(By.name("last_name")).click();
        driver.findElement(By.name("last_name")).sendKeys(last_name);
        driver.findElement(By.name("address")).click();
        driver.findElement(By.name("address")).sendKeys(home_address);
        driver.findElement(By.name("home")).click();
        driver.findElement(By.name("home")).sendKeys(home_phone);
        driver.findElement(By.name("work")).click();
        driver.findElement(By.name("mobile")).click();
        driver.findElement(By.name("mobile")).sendKeys(mobile_phone);
        driver.findElement(By.name("fax")).click();
        driver.findElement(By.name("work")).click();
        driver.findElement(By.name("work")).sendKeys(work_phone);
        driver.findElement(By.name("theform")).click();
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).sendKeys(mail1);
        driver.findElement(By.name("email2")).click();
        driver.findElement(By.name("email2")).sendKeys(mail2);
        driver.findElement(By.name("email3")).click();
        driver.findElement(By.name("email3")).sendKeys(mail3);
        driver.findElement(By.xpath("//input[@name='submit']")).click();
        driver.findElement(By.linkText("home page")).click();
    }

    protected static void removeContact() {
      driver.findElement(By.name("selected[]")).click();
      driver.findElement(By.xpath("//input[@value=\'Delete\']")).click();
      driver.findElement(By.linkText("home")).click();
    }

    @BeforeEach
    public void setUp() {
        if (app == null) {
            app = new ApplicationManager();
        }
        app.init(System.getProperty("browser", "firefox"));
    }

    @BeforeEach
    public void setUp() {
        if (ContactCreationTests.driver == null) {
            ContactCreationTests.driver = new FirefoxDriver();
            ContactCreationTests.driver.get("http://localhost/addressbook/");
            ContactCreationTests.driver.manage().window().setSize(new Dimension(673, 697));
            ContactCreationTests.driver.findElement(By.name("user")).click();
            ContactCreationTests.driver.findElement(By.name("user")).sendKeys("admin");
            ContactCreationTests.driver.findElement(By.name("pass")).click();
            ContactCreationTests.driver.findElement(By.name("pass")).sendKeys("secret");
            ContactCreationTests.driver.findElement(By.xpath("//input[@value='Login']")).click();
        }
    }

    protected boolean IsElemetPresent(By locator) {
        try {
            ContactCreationTests.driver.findElement(locator);
            return true;
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    protected void openContactPage() {
        if (!IsElemetPresent(By.name("new"))) {
            driver.findElement(By.xpath("//a[contains(.,'add new')]")).click();
        }
    }

    protected boolean isContactPresent() {
      return IsElemetPresent(By.name("selected[]"));
    }

    protected void openContactPage1() {
      if (!IsElemetPresent(By.name("searchstring"))) {
        driver.findElement(By.xpath("//a[contains(.,'add new')]")).click();
      }
    }
}
