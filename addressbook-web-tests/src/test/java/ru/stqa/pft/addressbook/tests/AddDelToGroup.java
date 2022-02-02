package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

public class AddDelToGroup extends ContactTestBase {

    private Contacts contacts;

    @BeforeMethod
    void init() {
        app.contact().contactPage();
        this.contacts = app.db().contacts();

        if (this.contacts == null || this.contacts.isEmpty()) {
            ContactData defaultContactData = new ContactData()
                    .withLastname("Petrov")
                    .withFirstname("Ivan")
                    .withMobilePhone("78961234545")
                    .withAddress("address")
                    .withEmail("email@yande.ru");
            this.contacts.withAdded(defaultContactData);
            create(defaultContactData);
        }
    }

    @Test
    public void testContactAddToGroup() {
        ContactData anyContact = this.contacts.stream().findAny().get();
        app.contact().selectContactById(anyContact.getId());
        app.contact().addContactToGroup();
    }

    @Test
    public void testContactDelToGroup() {
        ContactData anyContact = this.contacts.stream().findAny().get();
        app.contact().selectGroup();
        app.contact().selectContactById(anyContact.getId());
        app.contact().delContactToGroup();
    }

}
