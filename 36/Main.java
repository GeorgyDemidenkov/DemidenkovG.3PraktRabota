import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку: ");
        String line = scanner.nextLine();
        
        System.out.println("Введите слово ключ: ");
        String wordKey = scanner.nextLine();

        char[] matrixWords = generateMatrixWords();
        
        System.out.println("Результат работы: " + caesarsCipher(line, wordKey, matrixWords));
    }

    private static char[] generateMatrixWords() {
        char[] matrixWords = new char[32];
        for (int i = 0; i < matrixWords.length; i++) {
            matrixWords[i] = (char) ('а' + i);
        }
        System.out.println(Arrays.toString(matrixWords));
        return matrixWords;
    }

    private static StringBuilder caesarsCipher(String line, String wordKey, char[] matrixWords) {
        StringBuilder result = new StringBuilder();
        int shift = 0;
        for (int j = 0; j < wordKey.length(); j++) {
            int k = 0, c = 0;
            for (int i = 0; i < matrixWords.length; i++) {
                if (wordKey.charAt(j) == matrixWords[i]) k = i;
                if (line.charAt(j) == matrixWords[i]) c = i;
            }
            shift = c - k;
        }

        for (int j = 0; j < line.length(); j++) {
            char currentChar = line.charAt(j);
            if (currentChar == ' ') {
                result.append(' ');
                continue;
            }
            int index = findCharIndex(matrixWords, currentChar);
            int newIndex = (index - shift + matrixWords.length) % matrixWords.length;
            result.append(matrixWords[newIndex]);
        }
        return result;
    }

    private static int findCharIndex(char[] array, char target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
