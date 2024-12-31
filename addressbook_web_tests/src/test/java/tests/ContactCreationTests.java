package tests;

import common.CommonFunctions;
import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
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
                                                    .withMobilePhone("")
                                                    .withMail("")
                                                    );
                }
            }
        }

        for (int i = 0; i < 5; i++) {
            result.add(new ContactData()
                            .withFirstName(CommonFunctions.randomString(i * 10))
                            .withLasttName(CommonFunctions.randomString(i * 10))
                            .withHomeAddress(CommonFunctions.randomString(i * 10))
                            .withMobilePhone(CommonFunctions.randomString(i * 10))
                            .withMail(CommonFunctions.randomString(i * 10))
                            );
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
                new ContactData("", "FirstName'", "", "", "", "", "")));
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

    @Test
    void canCreateContact() {
        var contact = new ContactData()
                .withFirstName(CommonFunctions.randomString(10))
                .withLasttName(CommonFunctions.randomString(10))
                .withPhoto(randomFile("src/test/resources/images"));
        app.contacts().createContact(contact);
    }
}
