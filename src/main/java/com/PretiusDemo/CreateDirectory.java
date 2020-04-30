package com.PretiusDemo;

import java.io.File;

public class CreateDirectory {

    public void createDirectoreIfExists() {

        File file1 = new File("D:\\Pretius\\Home");
        boolean homeCreated = file1.mkdir();

        File file2 = new File("D:\\Pretius\\Dev");
        boolean devCreated = file2.mkdir();

        File file3 = new File("D:\\Pretius\\Test");
        boolean testCreated = file3.mkdir();


        System.out.println("Utworzono folder Home: " + homeCreated +
                "\nUtworzono folder Home: " + devCreated  +
                "\nUtworzono folder Home: " + testCreated);
    }

}
