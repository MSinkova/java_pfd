package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModificationTests extends ContactTestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        app.contact().contactPage();
        createIfNotExist(new ContactData().withLastname("Petrov").withFirstname("Ivan").withAddress2("Moscow").withEmail("232@mail.ru").withMobile("78961234545"));
    }

    @Test
    public void testContactModification() {
        Contacts before = app.contact().all();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData()
                .withLastname("Petrov").withFirstname("Ivan").withAddress2("Moscow").withEmail("232@mail.ru").withMobile("78961234545").withId(modifiedContact.getId());
        app.contact().modify(contact);
        Contacts after = app.contact().all();
        assertEquals(after.size(), before.size());
        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    }
}
