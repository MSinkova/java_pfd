package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTests extends ContactTestBase {

  @Test
  public void testContactDeletion() {
    app.getContactHelper().goToContactPage();
    createContactIfNotExist(new ContactData("Mariia", "S", "Sinkova", "Moscow", "89143245555", "123@mail.ru", "234@mail.ru", "1990", "Moscow", "Moscow",null));
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContacts();
    app.getNavigationHelper().goToContactPage();
  }
}
