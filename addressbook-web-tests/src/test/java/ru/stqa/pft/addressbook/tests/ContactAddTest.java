package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactAddTest extends ContactTestBase {

  @Test
  public void testContactAdd() {
    app.contact().contactPage();
    List<ContactData> before = app.contact().list();
    ContactData contact = new ContactData().withLastname("Petrov").withFirstname("Ivan").withAddress2("Moscow").withEmail("232@mail.ru").withMobile("78961234545");
    create(contact);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() + 1);

    before.add(contact);
    Comparator<? super ContactData> byId =  (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    contact.withId(after.stream().max((o1, o2) -> Integer.compareUnsigned(o1.getId(), o2.getId())).get().getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
