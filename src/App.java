import java.util.Arrays;

public class App {

    public int add(String input) {
        if(input.isEmpty()) 
            return 0;
        String subStr = input;
        String delimiter = ",|\n";
        if(input.startsWith("//")) {
            int index = input.indexOf("\n");
            System.out.println(index);
            delimiter = input.substring(2, index);
            input = input.split("\n")[1];
        }
        String[] splitArr = input.split(delimiter);
        int[] numberArray = Arrays.stream(splitArr).mapToInt(Integer::parseInt).toArray();
        return getSum(numberArray);
    }

    private int getSum(int[] intArr) {
        return Arrays.stream(intArr).reduce(0, (a, b) -> a + b);
    }

    public static void main(String[] args) {
        App obj = new App();
        System.out.println(obj.add("//;\n1;2"));
    }
}
