package ru.stqa.pft.addressbook;

import org.testng.annotations.*;

public class ContactAddTest extends TestBase {

  @Test
  public void testContactAdd() throws Exception {
    initContactCreation();
    fillContactForm(new ContactData("Mariia", "S", "Sinkova", "Moscow", "89143245555", "123@mail.ru", "234@mail.ru", "1990", "Moscow", "Moscow"));
    submitContactCreation();
    returnToContactPage();
    logout();
  }

}
