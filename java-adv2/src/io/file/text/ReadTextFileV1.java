package io.file.text;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.charset.StandardCharsets.*;

public class ReadTextFileV1 {

    private static final String PATH = "temp/hello2.txt";

    public static void main(String[] args) throws IOException {
        String writeString = "abc\n가나다";
        System.out.println("== Write String ==");
        System.out.println(writeString);

        Path path = Path.of(PATH);

        //쓰기
        Path path1 = Files.writeString(path, writeString, UTF_8);
        //읽기
        String readString = Files.readString(path, UTF_8);

        System.out.println("== READ String");
        System.out.println(readString);


    }
}
