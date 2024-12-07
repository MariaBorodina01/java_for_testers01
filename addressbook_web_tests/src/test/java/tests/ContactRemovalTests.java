import model.ContactData;
import org.junit.jupiter.api.Test;
import tests.TestBase;

public class ContactRemovalTests extends TestBase {
  @Test
  public void canRemoveContact() {
    app.openContactPage1();
    if (!app.isContactPresent()) {
      app.createContact(new ContactData("", "", "", "", "", "", "", "", ""));
    }
    app.removeContact();
  }
}
