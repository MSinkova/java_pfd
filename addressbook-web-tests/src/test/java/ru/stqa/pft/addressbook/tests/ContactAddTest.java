package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactAddTest extends TestBase {

  @Test
  public void testContactAdd() throws Exception {
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(new ContactData("Mariia", "S", "Sinkova", "Moscow", "89143245555", "123@mail.ru", "234@mail.ru", "1990", "Moscow", "Moscow", "test3"), true);
    app.getContactHelper().submitContactCreation();
    app.getNavigationHelper().goToContactPage();
  }
}
