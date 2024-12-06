import org.junit.jupiter.api.Test;
import tests.TestBase;

public class ContactCreationTests extends TestBase {

    @Test
    public void canCreateContact() {
        openContactPage();
        createContact("FirstName", "LastName", "Address", "1111", "2222", "3333", "mail1@mail.ru", "mail2@mail.ru", "mail3@mail.ru");
    }

    @Test
    public void canCreateContactWithEmptyFields() {
        openContactPage();
        createContact("", "", "", "", "", "", "", "", "");
    }


}
