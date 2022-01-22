package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactAddTest extends ContactTestBase {

  @Test
  public void testContactAdd() {
    createContact();
    app.getNavigationHelper().goToContactPage();
  }
}
