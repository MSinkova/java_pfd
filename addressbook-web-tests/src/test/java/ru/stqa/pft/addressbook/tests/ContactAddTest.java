package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

public class ContactAddTest extends TestBase {

  @Test
  public void testContactAdd() throws Exception {
    app.getNavigationHelper().goToContactPage();
    if(!app.getContactHelper().webElementOptionGroup()) {
      app.getGroupHelper().createGroup(new GroupData("test1","test","nameGroup"));
    }
    app.getContactHelper().createContact(new ContactData("Mariia", "S", "Sinkova", "Moscow", "89143245555", "123@mail.ru", "234@mail.ru", "1990", "Moscow", "Moscow",null));
  }
}
