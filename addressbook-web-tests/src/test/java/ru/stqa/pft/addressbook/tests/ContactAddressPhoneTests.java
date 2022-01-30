package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddressPhoneTests extends ContactTestBase{

    @Test
    public void testContactPhones() {
        app.goTo().goToContactPage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        assertThat(contact.getAllPhone(), equalTo(mergePhones(contactInfoFromEditForm)));
        assertThat(contact.getAddress(), equalTo(mergeAddresses(contactInfoFromEditForm)));
        assertThat(contact.getAllEmail(), equalTo(mergeEmails(contactInfoFromEditForm)));
    }

    private String mergePhones(ContactData contact) {
        return Arrays.asList(contact.getHomePhone(),contact.getMobilePhone(),contact.getWorkPhone())
                .stream().filter((s) -> ! s.equals(""))
                .map(ContactAddressPhoneTests::cleaned)
                .collect(Collectors.joining("\n"));
    }

    private String mergeEmails(ContactData contact) {
        return Arrays.asList(contact.getEmail(),contact.getEmail2(),contact.getEmail3())
                .stream().filter((s) -> ! s.equals(""))
                .map(ContactAddressPhoneTests::cleanedEmail)
                .collect(Collectors.joining("\n"));
    }

    private String mergeAddresses(ContactData contact) {
        return Arrays.asList(contact.getAddress())
                .stream().filter((s) -> ! s.equals(""))
                .map(ContactAddressPhoneTests::cleanedAddress)
                .collect(Collectors.joining("\n"));
    }

    public static String cleaned(String phone) {
        return phone.replaceAll("\\s","").replaceAll("[-()]","");
    }

    public static String cleanedAddress(String address) {
        return address.replaceAll("\\s","").replaceAll("[-()]","");
    }

    public static String cleanedEmail(String email) {
        return email.replaceAll("\\s","").replaceAll("[-()]","");
    }
}
