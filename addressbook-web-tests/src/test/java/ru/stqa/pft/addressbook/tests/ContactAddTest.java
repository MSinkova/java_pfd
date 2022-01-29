package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Set;

public class ContactAddTest extends ContactTestBase {

  @Test
  public void testContactAdd() {
    app.contact().contactPage();
    Set<ContactData> before = app.contact().all();
    ContactData contact = new ContactData().withLastname("Petrov").withFirstname("Ivan").withAddress2("Moscow").withEmail("232@mail.ru").withMobile("78961234545");
    create(contact);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() + 1);

    contact.withId(after.stream().mapToInt(g -> g.getId()).max().getAsInt());
    before.add(contact);
    Assert.assertEquals(before, after);
  }
}
