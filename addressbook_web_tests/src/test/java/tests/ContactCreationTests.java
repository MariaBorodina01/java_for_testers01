import model.ContactData;
import org.junit.jupiter.api.Test;
import tests.TestBase;

public class ContactCreationTests extends TestBase {

    @Test
    public void canCreateContact() {
        app.openContactPage();
        app.createContact(new ContactData("FirstName", "LastName", "Address", "1111", "2222", "3333", "mail1@mail.ru", "mail2@mail.ru", "mail3@mail.ru"));
    }

    @Test
    public void canCreateContactWithEmptyFields() {
        app.openContactPage();
        app.createContact(new ContactData());
    }

    @Test
    public void canCreateContactWithFirstNameOnly() {
        app.openContactPage();
        var emptyContact = new ContactData();
        var contactWithFirstName = emptyContact.withFirstName("First");

        app.createContact(contactWithFirstName);
    }
}
