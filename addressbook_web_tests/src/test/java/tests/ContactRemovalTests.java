package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ContactRemovalTests extends TestBase {
  @Test
  public void canRemoveContact() {
    if (app.contacts().getCount() == 0) {
      app.contacts().createContact(new ContactData("", "", "", "", "", "", "", "", "", ""));
    }
    var oldContact = app.contacts().getList();
    var rnd = new Random(oldContact.size());
    var index = rnd.nextInt(oldContact.size());
    app.contacts().removeContact(oldContact.get(index));
//    var newContact = app.contacts().getList();
//    var expectedList = new ArrayList<>(oldContact);
//    expectedList.remove(index);
////    int newContactCount = app.contacts().getCount();
//    Assertions.assertEquals(newContact, expectedList);
  }

 @Test
 void canRemoveAllContractsAtOnce(){
   if (app.contacts().getCount() == 0) {
     app.contacts().createContact(new ContactData("", "", "", "", "", "", "", "", "", ""));
   }
   app.contacts().removeAllContacts();
   Assertions.assertEquals(0, app.contacts().getCount());
 }
}
