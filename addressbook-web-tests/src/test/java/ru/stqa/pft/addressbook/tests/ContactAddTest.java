package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactAddTest extends ContactTestBase {

  @Test
  public void testContactAdd() {
    app.getNavigationHelper().goToContactPage();
    List<ContactData> before = app.getContactHelper().getContactList();
    ContactData contact = new ContactData("Sidorova", "S", "Sinkova", "Moscow", "89143245555", "123@mail.ru", "234@mail.ru", "1990", "Moscow", "79876664343");
    createContact(contact);
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);

    contact.setId(after.stream().max((o1, o2) -> Integer.compareUnsigned(o1.getId(), o2.getId())).get().getId());
    before.add(contact);
    Assert.assertEquals(before, after);
  }
}
