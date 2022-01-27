package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactAddTest extends ContactTestBase {

  @Test(enabled = false)
  public void testContactAdd() {
    app.contact().contactPage();
    List<ContactData> before = app.contact().list();
    ContactData contact = new ContactData("Sidorova", "S", "Sinkova", "Moscow", "89143245555", "123@mail.ru", "234@mail.ru", "1990", "Moscow", "79876664343");
    createContact(contact);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() + 1);

    before.add(contact);
    Comparator<? super ContactData> byId =  (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    contact.setId(after.stream().max((o1, o2) -> Integer.compareUnsigned(o1.getId(), o2.getId())).get().getId());

    Assert.assertEquals(before, after);
  }
}
