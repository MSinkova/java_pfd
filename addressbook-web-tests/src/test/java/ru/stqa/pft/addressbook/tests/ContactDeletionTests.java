package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends ContactTestBase {

  @Test
  public void testContactDeletion() {
    app.getContactHelper().goToContactPage();
    createContactIfNotExist();
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContacts();
    app.getNavigationHelper().goToContactPage();
  }
}
