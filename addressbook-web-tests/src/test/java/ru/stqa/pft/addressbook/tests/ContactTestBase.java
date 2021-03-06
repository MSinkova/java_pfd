package ru.stqa.pft.addressbook.tests;

import ru.stqa.pft.addressbook.model.ContactData;

public class ContactTestBase extends TestBase {

    public void create(ContactData contact) {
        app.group().createGroupIfNotExist();
        app.contact().createContact(contact);
    }

    public void createIfNotExist(ContactData contact) {
        if (! app.contact().isThereAСontact())
            create(contact);
    }
}
