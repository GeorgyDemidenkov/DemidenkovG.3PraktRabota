import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите длину ряда: ");
        int numbers = scanner.nextInt();

        System.out.println("Введите стартовое число: ");
        int start = scanner.nextInt();

        System.out.println("Результат работы: " + scriptMath(numbers, start));
    }

    private static String scriptMath(int numbers, int start) {
        int sum = 0;

        String result = "";
        for (int i = 0; i < Integer.toString(start).length(); i++) {
            int digit = Character.getNumericValue(Integer.toString(start).charAt(i));
            sum += Math.pow(digit, numbers);
            result += digit + "^" + numbers + (i + 1 == Integer.toString(start).length() ? "" : "+");
            numbers++;
        }

        return result + "=" + start + "*" + (numbers - 1);
    }
}
