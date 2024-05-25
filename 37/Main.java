import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println(solvingNumbers());
    }

    private static String solvingNumbers() {
        int[] arrayComparison = collectingArray();
        int count = 0;
        for (int i = 0; i < 20; ++i) {
            int[] arrayMake = makeNumber();
            count = countMatches(arrayMake, arrayComparison);
            if (count == 4) {
                System.out.println("Вы отгадали");
                return Arrays.toString(arrayComparison);
            } else {
                System.out.println("Вы не отгадали, попробуйте еще раз. Количество совпадений: " + count);
            }
        }
        return "Вы исчерпали все 20 попыток";
    }

    private static int[] collectingArray() {
        System.out.println("Введите строку из 4 чисел: ");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        int[] arrayComparison = new int[4];
        for (int i = 0; i < arrayComparison.length; ++i) {
            arrayComparison[i] = Character.getNumericValue(userInput.charAt(i));
        }
        System.out.println(Arrays.toString(arrayComparison));
        return arrayComparison;
    }

    private static int[] makeNumber() {
        int[] arrayMake = new int[4];
        for (int i = 0; i < arrayMake.length; i++) {
            arrayMake[i] = (int) (Math.random() * 10);
        }
        return arrayMake;
    }

    private static int countMatches(int[] array1, int[] array2) {
        int count = 0;
        for (int i = 0; i < array1.length; ++i) {
            if (array1[i] == array2[i]) {
                ++count;
            }
        }
        return count;
    }
}
