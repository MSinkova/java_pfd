package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTests extends ContactTestBase {

  @Test
  public void testContactDeletion() {
    app.getContactHelper().goToContactPage();
    int before = app.getContactHelper().getGroupCount();
    createContactIfNotExist(new ContactData("Mariia", "S", "Sinkova", "Moscow", "89143245555", "123@mail.ru", "234@mail.ru", "1990", "Moscow", "Moscow",null));
    app.getContactHelper().selectContact(before - 1);
    app.getContactHelper().deleteSelectedContacts();
    app.getNavigationHelper().goToContactPage();
    int after = app.getContactHelper().getGroupCount();
    Assert.assertEquals(after, before - 1);
  }
}
