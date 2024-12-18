package io.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class NewFilesMain {
    public static void main(String[] args) throws IOException {
        Path file = Path.of("temp/example.txt");
        Path directory = Path.of("temp/exampleDir");

        System.out.println("Files.exists(file) = " + Files.exists(file));

        Files.createFile(file);

        Files.createDirectory(directory);

        Files.delete(file);

        System.out.println("Is regular file: " + Files.isRegularFile(file));
        System.out.println("Is directory: " + Files.isDirectory(directory));
    }
}
