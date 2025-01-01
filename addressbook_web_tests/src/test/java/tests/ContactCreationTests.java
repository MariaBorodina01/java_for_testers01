package tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import common.CommonFunctions;
import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ContactCreationTests extends TestBase {

    public static List<ContactData> contactProvider() throws IOException {
        var result = new ArrayList<ContactData>();
//        for(var firstName : List.of("", "firstName")){
//            for (var lastName: List.of("", "lastName")) {
//                for (var homeAddress: List.of("", "homeAddress")){
//                                            result.add(new ContactData()
//                                                    .withFirstName(firstName)
//                                                    .withLasttName(lastName)
//                                                    .withHomeAddress(homeAddress)
//                                                    .withMobilePhone("")
//                                                    .withMail("")
//                                                    );
//                }
//            }
//        }
        var json = Files.readString(Paths.get("contacts.json"));
        ObjectMapper mapper = new ObjectMapper();

        var value = mapper.readValue(json, new TypeReference<List<ContactData>>() {});
        result.addAll(value);
        return result;
    }


    @ParameterizedTest
    @MethodSource("contactProvider")
    public void canCreateMultipleContacts(ContactData contact) {
        int contactCount = app.contacts().getCount();

        app.contacts().createContact(contact);

        int newContactCount = app.contacts().getCount();
        Assertions.assertEquals(contactCount + 1, newContactCount);
    }

    public static List<ContactData> negativeContactProvider() {
        var result = new ArrayList<ContactData>(List.of(
                new ContactData("", "FirstName'", "", "", "", "", "src/test/resources/images/avatar.png")));
        return result;
    }

    @ParameterizedTest
    @MethodSource("negativeContactProvider")
    public void canNotCreateContact(ContactData contact) {
        int contactCount = app.contacts().getCount();

        app.contacts().createContact(contact);

        int newContactCount = app.contacts().getCount();
        Assertions.assertEquals(contactCount, newContactCount);
    }

    @Test
    void canCreateContact() {
        var contact = new ContactData()
                .withFirstName(CommonFunctions.randomString(10))
                .withLasttName(CommonFunctions.randomString(10))
                .withPhoto(CommonFunctions.randomFile("src/test/resources/images"));
        app.contacts().createContact(contact);
    }
}
