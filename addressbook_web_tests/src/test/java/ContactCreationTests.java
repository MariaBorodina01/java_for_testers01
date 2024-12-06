import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ContactCreationTests {
    private static WebDriver driver;

    @AfterAll
    public static void tearDown() {
//        driver.findElement(By.linkText("Logout")).click();
        driver.quit();
    }

    @BeforeEach
    public void setUp() {
        if (driver == null) {
            driver = new FirefoxDriver();
            driver.get("http://localhost/addressbook/");
            driver.manage().window().setSize(new Dimension(673, 697));
            driver.findElement(By.name("user")).click();
            driver.findElement(By.name("user")).sendKeys("admin");
            driver.findElement(By.name("pass")).click();
            driver.findElement(By.name("pass")).sendKeys("secret");
            driver.findElement(By.xpath("//input[@value='Login']")).click();
        }
    }

    @Test
    public void canCreateContact() {
        if (!IsElemetPresent(By.name("new"))) {
            driver.findElement(By.xpath("//a[contains(.,'add new')]")).click();
        }
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

    private boolean IsElemetPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    @Test
    public void canCreateContactWithEmptyFields() {
        if (!IsElemetPresent(By.name("new"))) {
            driver.findElement(By.xpath("//a[contains(.,'add new')]")).click();
        }
        driver.findElement(By.xpath("//a[contains(.,'add new')]")).click();
        driver.findElement(By.name("firstname")).click();
        driver.findElement(By.name("firstname")).sendKeys("");
        driver.findElement(By.name("lastname")).click();
        driver.findElement(By.name("lastname")).sendKeys("");
        driver.findElement(By.name("address")).click();
        driver.findElement(By.name("address")).sendKeys("");
        driver.findElement(By.name("home")).click();
        driver.findElement(By.name("home")).sendKeys("");
        driver.findElement(By.name("work")).click();
        driver.findElement(By.name("mobile")).click();
        driver.findElement(By.name("mobile")).sendKeys("");
        driver.findElement(By.name("fax")).click();
        driver.findElement(By.name("work")).click();
        driver.findElement(By.name("work")).sendKeys("");
        driver.findElement(By.name("theform")).click();
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).sendKeys("");
        driver.findElement(By.name("email2")).click();
        driver.findElement(By.name("email2")).sendKeys("");
        driver.findElement(By.name("email3")).click();
        driver.findElement(By.name("email3")).sendKeys("");
        driver.findElement(By.xpath("//input[@name='submit']")).click();
        driver.findElement(By.linkText("home page")).click();
    }
}
