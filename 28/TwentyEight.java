import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите строку: ");
        String line = scanner.nextLine();

        System.out.println("Введите направление (справа/слева): ");
        String direction = scanner.nextLine();

        System.out.println("Введите сдвиг: ");
        int shift = scanner.nextInt();

        char[] matrixWords = generateMatrixWords();

        System.out.println("Результат работы: " + caesarsCipher(line, direction, shift, matrixWords));
    }

    private static char[] generateMatrixWords() {
        char[] matrixWords = new char[32];
        int j = 0;
        for (char i = 'а'; i <= 'я'; ++i) {
            matrixWords[j++] = i;
        }
        System.out.println(Arrays.toString(matrixWords));
        return matrixWords;
    }

    private static StringBuilder caesarsCipher(String line, String direction, int shift, char[] matrixWords) {
        StringBuilder result = new StringBuilder();
        for (int j = 0; j < line.length(); j++) {
            char currentChar = line.charAt(j);
            if (currentChar == ' ') {
                result.append(' ');
                continue;
            }
            int index = new String(matrixWords).indexOf(currentChar);
            if (direction.equalsIgnoreCase("справа")) {
                result.append(matrixWords[(index + shift) % matrixWords.length]);
            } else if (direction.equalsIgnoreCase("слева")) {
                result.append(matrixWords[(index - shift + matrixWords.length) % matrixWords.length]);
            }
        }
        return result;
    }
}
