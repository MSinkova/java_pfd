package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;

public class GroupsDeletionTests extends TestBase{

  @Test
  public void testGroupsDeletionTests() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteSelectedGroups();
    app.getGroupHelper().returnToGroupPage();
  }
}
