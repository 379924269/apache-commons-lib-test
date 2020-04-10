package com.dnp.test.io;

import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;

import java.io.File;

public class FileListerAdapter extends FileAlterationListenerAdaptor {
    @Override
    public void onFileChange(File file) {
        if (!file.exists() || !file.canRead()) {
            System.out.println("The file {} is not exists or is not readable!");
            return;
        }
        System.out.println("----The file {} is change.");
        //TODO 读取操作
        super.onFileChange(file);
    }

    @Override
    public void onFileCreate(File file) {
        if (!file.exists()) {
            System.out.println("The file {} is not exists!");
            return;
        }
        if (!file.canRead()) {
            System.out.println("The file {} is not readable!");
            return;
        }
        System.out.println("----The file {} is created.");
        //TODO 读取操作
        super.onFileCreate(file);
    }

    @Override
    public void onFileDelete(File file) {
        System.out.println("----The file {} is deleted.");
        super.onFileDelete(file);
    }

    @Override
    public void onDirectoryChange(File directory) {
        if (!directory.exists()) {
            System.out.println("The directory {} is not exists!");
            return;
        }
        System.out.println("----The directory {} has changed.");
        super.onDirectoryChange(directory);
    }

    @Override
    public void onDirectoryCreate(File directory) {
        if (!directory.exists()) {
            System.out.println("The directory {} is not exists!");
            return;
        }
        System.out.println("----The directory {} is created.");
        super.onDirectoryCreate(directory);
    }

    @Override
    public void onDirectoryDelete(File directory) {
        System.out.println("----The directory {} is deleted.");
        super.onDirectoryDelete(directory);
    }
}