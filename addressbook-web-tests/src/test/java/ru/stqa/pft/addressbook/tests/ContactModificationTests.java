package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase{

    @Test
    public void testContactModification() {
        app.getNavigationHelper().goToContactPage();
        app.getContactHelper().selectContact();
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData("Mariia", "S", "Sinkova", "Moscow", "89143245555", "123@mail.ru", "234@mail.ru", "1990", "Moscow", "Moscow"));
        app.getContactHelper().submitContactModification();
        app.getContactHelper().goToContactPage();
    }
}
