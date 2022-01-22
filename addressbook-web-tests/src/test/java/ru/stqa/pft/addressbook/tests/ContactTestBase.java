package ru.stqa.pft.addressbook.tests;

import ru.stqa.pft.addressbook.model.ContactData;

public class ContactTestBase extends TestBase {

    public void createContact() {
        app.getGroupHelper().createGroupIfNotExist();
        app.getContactHelper().createContact(new ContactData("Mariia", "S", "Sinkova", "Moscow", "89143245555", "123@mail.ru", "234@mail.ru", "1990", "Moscow", "Moscow",null));
    }

    public void createContactIfNotExist() {
        if (! app.getContactHelper().isThereAСontact())
            createContact();
    }
}
