package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends ContactTestBase{

    @Test
    public void testContactModification() {
        app.getNavigationHelper().goToContactPage();
        int before = app.getContactHelper().getGroupCount();
        createContactIfNotExist(new ContactData("Mariia", "S", "Sinkova", "Moscow", "89143245555", "123@mail.ru", "234@mail.ru", "1990", "Moscow", "Moscow",null));
        app.getContactHelper().selectContact();
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData("Mariia", "S", "Sinkova", "Moscow", "89143245555", "123@mail.ru", "234@mail.ru", "1990", "Moscow", "Moscow", null), false);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().goToContactPage();
        int after = app.getContactHelper().getGroupCount();
        Assert.assertEquals(after, before);
    }
}
