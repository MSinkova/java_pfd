package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
      super(wd);
    }

    public void submitContactCreation() {
      click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void fillContactForm(ContactData contactData, boolean creation) {
      type(By.name("firstname"),contactData.getFirstname());
      type(By.name("middlename"),contactData.getMiddlename());
      type(By.name("lastname"),contactData.getLastname());
      type(By.name("home"),contactData.getHome());
      type(By.name("mobile"),contactData.getMobile());
      type(By.name("mobile"),contactData.getMobile());
      type(By.name("email"),contactData.getEmail());
      type(By.name("email2"),contactData.getEmail2());
      click(By.name("bday"));
      click(By.name("bmonth"));
      type(By.name("byear"),contactData.getByear());
      type(By.name("address2"),contactData.getAddress2());
      type(By.name("phone2"),contactData.getPhone2());

      if (creation) {
          new Select(wd.findElement(By.name("new_group"))).selectByIndex(1);
          } else {
          Assert.assertFalse(isElementPresent(By.name("new_group")));
     }
    }

    public void initContactCreation() {
      click(By.linkText("add new"));
    }

    public void contactPage() {
      click(By.id("logo"));
    }

    public void deleteSelectedContacts() {
      click(By.xpath("//input[@value='Delete']"));
      wd.switchTo().alert().accept();
    }

    public void selectContact(int id) {
        wd.findElements(By.name("selected[]")).get(id).click();
    }

    public void initContactModification() {
        click(By.xpath("//img[@alt='Edit']"));
    }

    public void submitContactModification() {
        click(By.xpath("//div[@id='content']/form/input[22]"));
    }

    public void createContact(ContactData contact) {
        initContactCreation();
        fillContactForm(contact, true);
        submitContactCreation();
        contactPage();
    }

    public void modify(int index, ContactData contact) {
        selectContact(index);
        initContactModification();
        fillContactForm(contact, false);
        submitContactModification();
        contactPage();
    }

    public void delete(int index) {
        selectContact(index);
        deleteSelectedContacts();
        contactPage();
    }

    public boolean isThereAСontact() {
        return isElementPresent(By.name("selected[]"));
    }

    public int getGroupCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public List<ContactData> list() {
        List<ContactData> contacts = new ArrayList<>();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for(WebElement element : elements) {
            WebElement fname = element.findElement(By.xpath(".//td[3]"));
            WebElement lname = element.findElement(By.xpath(".//td[2]"));
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            String firstname = fname.getText();
            String lastname = lname.getText();
            ContactData contact = new ContactData(id ,firstname, null, lastname, null, null, null, null, null, null, null);
            contacts.add(contact);
        }
        return contacts;
    }
}
