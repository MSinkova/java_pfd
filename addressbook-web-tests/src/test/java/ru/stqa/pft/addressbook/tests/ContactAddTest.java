package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactAddTest extends ContactTestBase {

  @Test
  public void testContactAdd() {
    int before = app.getContactHelper().getGroupCount();
    createContact(new ContactData("Mariia", "S", "Sinkova", "Moscow", "89143245555", "123@mail.ru", "234@mail.ru", "1990", "Moscow", "Moscow",null));
    app.getNavigationHelper().goToContactPage();
    int after = app.getContactHelper().getGroupCount();
    Assert.assertEquals(after, before + 1);
  }
}
