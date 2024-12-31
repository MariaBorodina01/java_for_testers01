package manager;

import model.ContactData;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

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

    public void removeContact(ContactData contact) {
        selectContact(contact);
        removeSelectedContacts();
        returnToMainPage();
    }

    public void openContactPage() {
        if (!manager.isElementPresent(By.name("new"))) {
            click(By.xpath("//a[contains(.,'add new')]"));
        }
    }


    private void selectContact(ContactData contact) {
        click(By.cssSelector(String.format("input [value='%s']", contact.id())));
    }

    private void fillContactForm(ContactData contract) {
        type(By.name("firstname"), contract.first_name());
        type(By.name("lastname"), contract.last_name());
        type(By.name("address"), contract.home_address());
        type(By.name("mobile"), contract.mobile_phone());
        type(By.name("email"), contract.mail());
        attach(By.name("photo"), contract.photo());
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

    public List<ContactData> getList() {
        var contacts = new ArrayList<ContactData>();
        var trs = manager.driver.findElements(By.name("entry"));
        for (var tr : trs) {
            var td = tr.findElement(By.cssSelector("td"));
            String id = String.valueOf(Integer.parseInt(td.findElement(By.cssSelector("input[type='checkbox']")).getAttribute("value")));
            ;
            contacts.add(new ContactData().withId(id));
        }
        return contacts;
    }
}
