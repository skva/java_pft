package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;


public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() throws Exception {
        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("test1","test1","test1","test1","test1"), true);
        }
        app.getNavigationHelper().gotoContactPage();
        app.getContactHelper().modifyContact();
        app.getContactHelper().fillContactForm(new ContactData("test2","test2","test2","test2", null), false);
        app.getContactHelper().submitContactModification();

    }



}