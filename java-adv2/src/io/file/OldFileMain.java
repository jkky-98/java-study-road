package io.file;

import java.io.File;
import java.io.IOException;

public class OldFileMain {

    public static void main(String[] args) throws IOException {
        File file = new File("temp/example.txt");
        File directory = new File("temp/exampleDir");

        System.out.println("file.exists() = " + file.exists());

        boolean created = file.createNewFile();
        System.out.println("File created = " + created);

        boolean dirCreated = directory.mkdir();
        System.out.println("dirCreated = " + dirCreated);
    }
}
