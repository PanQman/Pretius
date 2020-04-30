package com.PretiusDemo;

import java.io.File;
import java.util.Scanner;

public class Info {

    private String amountDevFilesName;

    private int amountDevFiles;

    private String amountTestFilesName;

    private int amountTestFiles;

    private String amountHomeFilesName;

    private int amountHomeFiles;

    public Info(String amountDevFilesName, int amountDevFiles, String amountTestFilesName,
                int amountTestFiles, String amountHomeFilesName, int amountHomeFiles) {
        this.amountDevFilesName = amountDevFilesName;
        this.amountDevFiles = amountDevFiles;
        this.amountTestFilesName = amountTestFilesName;
        this.amountTestFiles = amountTestFiles;
        this.amountHomeFilesName = amountHomeFilesName;
        this.amountHomeFiles = amountHomeFiles;
    }

    public String getAmountDevFilesName() {
        return amountDevFilesName;
    }

    public void setAmountDevFilesName(String amountDevFilesName) {
        this.amountDevFilesName = amountDevFilesName;
    }

    public int getAmountDevFiles() {
        return amountDevFiles;
    }

    public void setAmountDevFiles(int amountDevFiles) {
        this.amountDevFiles = amountDevFiles;
    }

    public String getAmountTestFilesName() {
        return amountTestFilesName;
    }

    public void setAmountTestFilesName(String amountTestFilesName) {
        this.amountTestFilesName = amountTestFilesName;
    }

    public int getAmountTestFiles() {
        return amountTestFiles;
    }

    public void setAmountTestFiles(int amountTestFiles) {
        this.amountTestFiles = amountTestFiles;
    }

    public String getAmountHomeFilesName() {
        return amountHomeFilesName;
    }

    public void setAmountHomeFilesName(String amountHomeFilesName) {
        this.amountHomeFilesName = amountHomeFilesName;
    }

    public int getAmountHomeFiles() {
        return amountHomeFiles;
    }

    public void setAmountHomeFiles(int amountHomeFiles) {
        this.amountHomeFiles = amountHomeFiles;
    }

    @Override
    public String toString() {
        return
                "amountDevFilesName= " + amountDevFilesName + "\n" +
                "amountDevFiles= " + amountDevFiles +
                "amountTestFilesName= " + amountTestFilesName + "\n" +
                "amountTestFiles= " + amountTestFiles +
                "amountHomeFilesName= " + amountHomeFilesName + "\n" +
                "amountHomeFiles= " + amountHomeFiles;
    }
}
