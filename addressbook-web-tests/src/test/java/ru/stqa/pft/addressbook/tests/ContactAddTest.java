package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddTest extends ContactTestBase {

  @Test
  public void testContactAdd() {
    app.contact().contactPage();
    Contacts before = app.contact().all();
    ContactData contact = new ContactData().withLastname("Petrov").withFirstname("Ivan").withAddress2("Moscow").withEmail("232@mail.ru").withMobile("78961234545");
    create(contact);
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt(g -> g.getId()).max().getAsInt()))));
  }
}
