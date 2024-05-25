import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int number = userPutInt("Введите число: ");
        System.out.println("Результат работы: " + differenceSquare(number));
    }

    private static int userPutInt(String prompt) {
        System.out.println(prompt);
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    private static String differenceSquare(int number) {
        int a = number + (int)Math.sqrt(number);
        int b = number - (int)Math.sqrt(number);
        return number + "=" + a + "-" + b;
    }
}
