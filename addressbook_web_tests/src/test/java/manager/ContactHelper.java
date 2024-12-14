package manager;

import model.ContactData;
import org.openqa.selenium.By;

public class ContactHelper extends HelperBase {
    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    public void createContact(ContactData contract) {
        openContactPage();
        fillContactForm(contract);
        submitContact();
        returnToMainPage();
    }

    public void removeContact() {
        selectContact();
        removeSelectedContacts();
        returnToMainPage();
    }

    public void openContactPage() {
        if (!manager.isElementPresent(By.name("new"))) {
            click(By.xpath("//a[contains(.,'add new')]"));
        }
    }


    private void selectContact() {
        click(By.name("selected[]"));
    }

    private void fillContactForm(ContactData contract) {
        type(By.name("firstname"), contract.first_name());
        type(By.name("lastname"), contract.last_name());
        type(By.name("address"),contract.home_address() );
        type(By.name("home"), contract.home_phone());
        type(By.name("mobile"), contract.mobile_phone());
        type(By.name("work"), contract.work_phone());
        type(By.name("email"), contract.mail1());
        type(By.name("email2"), contract.mail2());
        type(By.name("email3"), contract.mail3());
    }

    private void submitContact() {
        click(By.xpath("//input[@name='submit']"));
    }

    private void returnToMainPage() {
        click(By.linkText("home"));
    }

    private void removeSelectedContacts() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public int getCount() {
        return manager.driver.findElements(By.name("selected[]")).size();
    }

    public void removeAllContacts() {
        selectAllContacts();
        removeSelectedContacts();
    }

    private void selectAllContacts() {
        var checkboxes = manager.driver.findElements(By.name("selected[]"));
        for (var checkbox : checkboxes) {
            checkbox.click();
        }
    }
}
