import java.util.Scanner;

public class TwentyEight {
    public static void main(String[] args) {
        TwentyEight twentyEight = new TwentyEight();
        String line = twentyEight.userPutString("Введите строку: ");
        String direction = twentyEight.userPutString("Введите направление (справа/слева): ");
        int shift = twentyEight.userPutInt("Введите сдвиг: ");
        char[] matrixWords = twentyEight.generateMatrixWords();

        System.out.println("Результат работы: " + caesarsCipher(line, direction, shift, matrixWords));
    }

    private String userPutString(String prompt) {
        System.out.println(prompt);
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    private int userPutInt(String prompt) {
        System.out.println(prompt);
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    private char[] generateMatrixWords() {
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
            int index = findCharIndex(matrixWords, currentChar);
            if (direction.equalsIgnoreCase("справа")) {
                result.append(matrixWords[(index + shift) % matrixWords.length]);
            } else if (direction.equalsIgnoreCase("слева")) {
                result.append(matrixWords[(index - shift + matrixWords.length) % matrixWords.length]);
            }
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
