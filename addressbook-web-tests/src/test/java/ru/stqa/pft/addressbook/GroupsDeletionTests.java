package ru.stqa.pft.addressbook;

import org.testng.annotations.*;

public class GroupsDeletionTests extends TestBase{

  @Test
  public void testGroupsDeletionTests() throws Exception {
    gotoGroupPage();
    selectGroup();
    deleteSelectedGroups();
    returnToGroupPage();
  }
}
