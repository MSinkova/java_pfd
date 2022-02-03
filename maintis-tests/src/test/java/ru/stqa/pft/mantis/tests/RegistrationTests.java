package ru.stqa.pft.mantis.tests;

import org.testng.annotations.Test;

import java.io.File;

public class RegistrationTests extends TestBase{

    @Test
    public void testRegistration() {
        app.registration().start("user1", "user1@localhost.localdomain");
    }

    @Test
    public void testCurrentDir() {
        File currentDir = new File(".");
        System.out.println(currentDir.getAbsolutePath() + " рабочая директория");
    }

}
