import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println(changeText() + " ауч");
    }

    private static String inputStr() {
        System.out.println("Введите строку");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static String changeText() {
        String inputStr = inputStr();
        char prevChar = ' ';
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < inputStr.length(); ++i) {
            if (prevChar == ' ') {
                prevChar = inputStr.charAt(i);
                continue;
            }
            
            if (inputStr.charAt(i) == ' ') {
                result.append(prevChar).append(' ');
                prevChar = inputStr.charAt(i + 1);
                i++;
            } else {
                result.append(inputStr.charAt(i));
            }
        }
        
        result.append(prevChar);
        return result.toString();
    }
}
