package ru.stqa.pft.addressbook.tests;

import ru.stqa.pft.addressbook.model.ContactData;

public class ContactTestBase extends TestBase {

    public void createContact(ContactData contact) {
        app.getGroupHelper().createGroupIfNotExist();
        app.getContactHelper().createContact(contact);
    }

    public void createContactIfNotExist(ContactData contact) {
        if (! app.getContactHelper().isThereAСontact())
            createContact(contact);
    }
}
