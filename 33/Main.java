import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число: ");
        int number = scanner.nextInt();

        if (number >= 1 && number <= Math.pow(10, 18)) {
            System.out.println("Результат работы программы " + countSticks(number));
        } else {
            System.out.println("Число должно быть от 1 до 10^18");
        }
    }

    private static int countSticks(int number) {
        if (number % 2 == 0) {
            Scanner in = new Scanner(System.in);
            System.out.println("Сколько взять: ");
            String howMuch = in.nextLine();
            if (howMuch.equalsIgnoreCase("Половину")) {
                return number / 2;
            }
        }
        return 1;
    }
}
