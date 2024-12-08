package tests;

import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactCreationTests extends TestBase {

    @Test
    public void canCreateContact() {
        app.contacts().createContact(new ContactData("FirstName", "LastName", "Address", "1111", "2222", "3333", "mail1@mail.ru", "mail2@mail.ru", "mail3@mail.ru"));
    }

    @Test
    public void canCreateContactWithEmptyFields() {
        app.contacts().createContact(new ContactData());
    }

    @Test
    public void canCreateContactWithFirstNameOnly() {
        app.contacts().createContact(new ContactData().withFirstName("First Name"));
    }
}
