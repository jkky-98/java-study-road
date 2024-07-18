package task.easy.lostedbracket1541;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String formula = br.readLine();
        List<Character> operands = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < formula.length(); i++) {
            if (formula.charAt(i) == '+' || formula.charAt(i) == '-') {
                operands.add(formula.charAt(i));
            }
        }

        String[] split = formula.split("[-+]");
        for (String s : split) {
            numbers.add(Integer.parseInt(s));
        }

        System.out.println(FindMinResult(operands, numbers));
    }

    public static int FindMinResult(List<Character> operands, List<Integer> numbers) {
        while (operands.contains('-')) {
            int indexProcess = operands.indexOf('-');
            operands.set(indexProcess, '^');
            while (true) {
                if (indexProcess + 1 > operands.size()-1) {
                    break;
                }
                if (operands.get(indexProcess + 1) == '-') {
                    break;
                }
                if (operands.get(indexProcess + 1) == '+') {
                    numbers.set(indexProcess + 2, numbers.get(indexProcess+1) + numbers.get(indexProcess+2));
                    numbers.remove(indexProcess + 1);
                    operands.remove(indexProcess + 1);
                }
            }
        }
        if (operands.contains('+')) {
            while(operands.contains('+')) {
                int indexProcess = operands.indexOf('+');
                numbers.set(indexProcess+1, numbers.get(indexProcess) + numbers.get(indexProcess+1));
                numbers.remove(indexProcess);
                operands.remove(indexProcess);
            }
        }

        int result = numbers.get(0);

        if (numbers.size() == 1) {
            return numbers.get(0);
        }

        for (int i = 1; i < numbers.size(); i++) {
            result -= numbers.get(i);
        }

        return result;
    }
}
