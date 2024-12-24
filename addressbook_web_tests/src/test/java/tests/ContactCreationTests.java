package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.ArrayList;
import java.util.List;

public class ContactCreationTests extends TestBase {

    public static List<ContactData> contactProvider() {
        var result = new ArrayList<ContactData>();
        for(var firstName : List.of("", "firstName")){
            for (var lastName: List.of("", "lastName")) {
                for (var homeAddress: List.of("", "homeAddress")){
                                            result.add(new ContactData()
                                                    .withFirstName(firstName)
                                                    .withLasttName(lastName)
                                                    .withHomeAddress(homeAddress)
                                                    .withHomePhone("")
                                                    .withMobilePhone("")
                                                    .withWorkPhone("")
                                                    .withMail1("")
                                                    .withMail2("")
                                                    .withMail3( ""));
                }
            }
        }

        for (int i = 0; i < 5; i++) {
            result.add(new ContactData()
                            .withFirstName(randomString(i * 10))
                            .withLasttName(randomString(i * 10))
                            .withHomeAddress(randomString(i * 10))
                            .withHomePhone(randomString(i * 10))
                            .withMobilePhone(randomString(i * 10))
                            .withWorkPhone(randomString(i * 10))
                            .withMail1(randomString(i * 10))
                            .withMail2(randomString(i * 10))
                            .withMail3(randomString(i * 10)));
        }
        return result;
    }


    @ParameterizedTest
    @MethodSource("contactProvider")
    public void canCreateMultipleContacts(ContactData contact) {
        int contactCount = app.contacts().getCount();

        app.contacts().createContact(contact);;

        int newContactCount = app.contacts().getCount();
        Assertions.assertEquals(contactCount + 1, newContactCount);
    }

    public static List<ContactData> negativeContactProvider() {
        var result = new ArrayList<ContactData>(List.of(
                new ContactData("", "FirstName'", "", "", "", "", "", "", "", "")));
        return result;
    }

    @ParameterizedTest
    @MethodSource("negativeContactProvider")
    public void canNotCreateContact(ContactData contact) {
        int contactCount = app.contacts().getCount();

        app.contacts().createContact(contact);;

        int newContactCount = app.contacts().getCount();
        Assertions.assertEquals(contactCount, newContactCount);
    }
}
