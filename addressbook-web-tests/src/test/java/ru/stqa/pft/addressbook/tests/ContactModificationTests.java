package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;


public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() throws Exception {
        app.getContactHelper().modifyContact();
        app.getContactHelper().fillContactForm(new ContactData("44","44","44","44"));
        app.getContactHelper().submitContactModification();

    }



}