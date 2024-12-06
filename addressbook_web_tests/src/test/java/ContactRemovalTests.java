import org.junit.jupiter.api.Test;
import tests.TestBase;

public class ContactRemovalTests extends TestBase {
  @Test
  public void canRemoveContact() {
    openContactPage1();
    if (!isContactPresent()) {
      createContact("", "", "", "", "", "", "", "", "");
    }
    removeContact();
  }
}
