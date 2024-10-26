import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App {

    public int add(String input) {
        if(input.isEmpty()) 
            return 0;
        String subStr = input;
        String delimiter = ",|\n";
        if(input.startsWith("//")) {
            int index = input.indexOf("\n");
            delimiter = input.substring(2, index);
            input = input.split("\n")[1];
        }
        String[] splitArr = input.split(delimiter);
        return getSum(splitArr);
    }

    private int getSum(String[] numberArray) {
        int sum = 0;
        List<Integer> negativeNumbers = new ArrayList<>();

        for (String numStr : numberArray) {
            if (!numStr.isEmpty()) {
                int num = Integer.parseInt(numStr);
                if (num < 0) {
                    negativeNumbers.add(num);
                } else {
                    sum += num;
                }
            }
        }

        if (!negativeNumbers.isEmpty()) {
            throw new IllegalArgumentException("Negative numbers not allowed: " + negativeNumbers);
        }

        return sum;
    }

    public static void main(String[] args) {
        App obj = new App();
        System.out.println(obj.add("")); // 0
        System.out.println(obj.add("1")); // 1
        System.out.println(obj.add("1,5")); // 6
        System.out.println(obj.add("1\n2,3")); // 6
        System.out.println(obj.add("//;\n1;2")); // 3
    }
}
