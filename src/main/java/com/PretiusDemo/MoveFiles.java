package com.PretiusDemo;

import org.apache.commons.io.FileUtils;
import org.apache.tika.Tika;

import java.io.File;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoveFiles {


    private String xmlFile = "application/xml";
    private String jarFile = "application/java-archive";

    public void moveFile(Info info){
        File fromFolder = new File("D:/Pretius/Home");
        File toDevFolder = new File("D:/Pretius/Dev/");
        File toTestFolder = new File("D:/Pretius/Test/");
        List<File> files = new ArrayList<>(Arrays.asList(fromFolder.listFiles()));



        for (File f : files){
            Tika tika = new Tika();
            String type;
            File targetFile;
            if (f.isFile()){
                int amountDevFiles = info.getAmountDevFiles();
                int amountTestFiles = info.getAmountTestFiles();
                try {
                    type = tika.detect(f);
                    if (type.equals(xmlFile)) {
                        targetFile = new File(toDevFolder, f.getName());
                        Files.move(f.toPath(), targetFile.toPath());
                        info.setAmountDevFiles(++amountDevFiles);

                    } else if (type.equals(jarFile) && ifCreationTimeIsNotEven(f)) {
                        targetFile = new File(toTestFolder, f.getName());
                        Files.move(f.toPath(), targetFile.toPath());
                        info.setAmountTestFiles(++amountTestFiles);

                    } else if (type.equals(jarFile) && !ifCreationTimeIsNotEven(f)) {
                        targetFile = new File(toDevFolder, f.getName());
                        Files.move(f.toPath(), targetFile.toPath());
                        info.setAmountDevFiles(++amountDevFiles);

                    } else {
                        System.out.println("Nieznane rozszerzenia pliku w folderze Home");
                    }
                } catch (Exception exc) {
                    exc.printStackTrace();
                }

            }
        }

    }


    public boolean ifCreationTimeIsNotEven(File file) {
        int hour = 0;
        BasicFileAttributes attr;
        try {
            attr = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
            String b = attr.creationTime().toString().substring(11, 13);
            hour = Integer.parseInt(b);
        } catch (IOException exc) {
            exc.printStackTrace();
        }
        return (hour & 1) == 1; //czy godzina jest nieparzysta
    }
}
