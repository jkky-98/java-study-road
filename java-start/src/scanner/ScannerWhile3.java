package scanner;

import java.util.Scanner;

public class ScannerWhile3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        while (true) {
           int next_item = sc.nextInt();
           sum += next_item;
           if (next_item == 0) {
               break;
           }
           System.out.println(sum);
        }

    }
}
