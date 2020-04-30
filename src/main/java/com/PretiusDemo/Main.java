package com.PretiusDemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Info info = null;
        Scanner scanner = new Scanner(new File("D:/Pretius/Home/Count.txt"));

        if (!scanner.hasNext()){
            info = new Info("amountDevFilesName", 0, "amountTestFilesName",
                    0, "amountHomeFilesName", 0);
        }

        while (scanner.hasNext()){
            String amountDevFilesName = scanner.next();
            int amountDevFiles = scanner.nextInt();
            String amountTestFilesName = scanner.next();
            int amountTestFiles = scanner.nextInt();
            String amountHomeFilesName = scanner.next();
            int amountHomeFiles = scanner.nextInt();

            info = new Info(amountDevFilesName, amountDevFiles, amountTestFilesName,
                    amountTestFiles, amountHomeFilesName, amountHomeFiles);
        }


        CreateDirectory createDirectory = new CreateDirectory();
        createDirectory.createDirectoreIfExists();

        MoveFiles moveFiles = new MoveFiles();
        moveFiles.moveFile(info);

        saveCountFile(info);
    }

    public static void saveCountFile(Info info) {
        try (FileWriter fileWriter = new FileWriter("D:/Pretius/Home/count.txt")){
            fileWriter.write(info.getAmountDevFilesName() + " ");
            fileWriter.write(info.getAmountDevFiles() + " ");
            fileWriter.write(info.getAmountHomeFilesName() + " ");
            fileWriter.write(info.getAmountHomeFiles() + " ");
            fileWriter.write(info.getAmountTestFilesName() + " ");
            fileWriter.write(info.getAmountTestFiles() + " ");


        } catch (IOException exc) {
            exc.printStackTrace();
        }

    }
}
