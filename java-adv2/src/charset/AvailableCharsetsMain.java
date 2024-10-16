package charset;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Set;
import java.util.SortedMap;

public class AvailableCharsetsMain {

    public static void main(String[] args) {
        // 이용가능한 모든 charset 자바 + OS
        SortedMap<String, Charset> charsets = Charset.availableCharsets();

        for (String charsetName : charsets.keySet()) {
            System.out.println("charsetName = " + charsetName);
        }

        System.out.println("=======");
        // 문자로 조회 (대소문자 구분x)
        Charset charset1 = Charset.forName("MS949");
        System.out.println("charset1 = " + charset1);

        Set<String> aliases = charset1.aliases();
        for (String alias : aliases) {
            System.out.println("alias = " + alias);
        }

        //UTF8
        Charset charset2 = Charset.forName("UTF-8");
        System.out.println("charset2 = " + charset2);

        Charset utf8 = StandardCharsets.UTF_8;
        System.out.println("utf8 = " + utf8);

        // 시스템 기본 CHARSET 조회
        Charset defaultCharset = Charset.defaultCharset();
        System.out.println("defaultCharset = " + defaultCharset);

    }
}
