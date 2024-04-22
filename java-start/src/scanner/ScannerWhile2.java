package scanner;

import java.util.Scanner;

public class ScannerWhile2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
           int intValue1 = sc.nextInt();
           int intValue2 = sc.nextInt();
            System.out.print(intValue1+intValue2);
           if (intValue1 == 0 && intValue2 == 0) {
               break;
           }
        }
    }
}
