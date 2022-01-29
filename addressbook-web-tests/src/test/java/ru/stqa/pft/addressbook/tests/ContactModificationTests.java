package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Set;

public class ContactModificationTests extends ContactTestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        app.contact().contactPage();
        createIfNotExist(new ContactData().withLastname("Petrov").withFirstname("Ivan").withAddress2("Moscow").withEmail("232@mail.ru").withMobile("78961234545"));
    }

    @Test
    public void testContactModification() {
        Set<ContactData> before = app.contact().all();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData()
                .withLastname("Petrov").withFirstname("Ivan").withAddress2("Moscow").withEmail("232@mail.ru").withMobile("78961234545").withId(modifiedContact.getId());
        app.contact().modify(contact);
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size());

        before.remove(modifiedContact);
        before.add(contact);
        Assert.assertEquals(before,after);
    }
}
