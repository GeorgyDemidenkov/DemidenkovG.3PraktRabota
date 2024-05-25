import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите длину массива: ");
        int length = scanner.nextInt();
        scanner.nextLine(); // consume newline character

        System.out.println("Введите числа в массив: ");
        String[] inputMass = new String[length];
        for (int i = 0; i < length; i++) {
            inputMass[i] = scanner.nextLine();
        }

        System.out.println(Arrays.toString(sortBySum(inputMass)));
    }

    private static String[] sortBySum(String[] inputMass) {
        boolean needIteration = true;
        while (needIteration) {
            needIteration = false;
            for (int i = 0; i < inputMass.length - 1; i++) {
                for (int j = i + 1; j < inputMass.length; j++) {
                    int sum1 = calculateSum(inputMass[i]);
                    int sum2 = calculateSum(inputMass[j]);
                    if (sum1 >= sum2) {
                        String temp = inputMass[i];
                        inputMass[i] = inputMass[j];
                        inputMass[j] = temp;
                        needIteration = true;
                    }
                }
            }
        }
        return inputMass;
    }

    private static int calculateSum(String number) {
        int sum = 0;
        for (char digit : number.toCharArray()) {
            sum += Character.getNumericValue(digit);
        }
        return sum;
    }
}
