package io.text;

import java.io.*;
import java.nio.charset.StandardCharsets;

import static io.text.TextConst.*;
import static java.nio.charset.StandardCharsets.*;

public class ReaderWriterMainV3 {
    public static void main(String[] args) throws IOException {
        String writeString = "ABC";
        System.out.println("write String: " + writeString);

        FileWriter fw = new FileWriter(FILE_NAME, UTF_8);
        fw.write(writeString);
        fw.close();

        FileReader fr = new FileReader(FILE_NAME);
        StringBuilder sb = new StringBuilder();

        int ch;

        while((ch = fr.read()) != -1) {
            sb.append((char) ch);
        }

        fr.close();

        String string = sb.toString();
        System.out.println("string = " + string);
    }
}
