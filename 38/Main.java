import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println(everyThree());
    }

    private static ArrayList<Integer> createParticipantsList() {
        System.out.println("Введите количество участников: ");
        Scanner scanner = new Scanner(System.in);
        int longArray = scanner.nextInt();
        ArrayList<Integer> participantsList = new ArrayList<>(longArray);
        for (int i = 0; i < longArray; ++i) {
            participantsList.add(i + 1);
        }
        System.out.println(participantsList);
        return participantsList;
    }

    private static int getStartIndex() {
        System.out.println("Введите номер первого участника: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static String everyThree() {
        ArrayList<Integer> participantsList = createParticipantsList();
        int startIndex = getStartIndex() - 1;
        ArrayList<Integer> resultOrder = new ArrayList<>();
        int count = participantsList.size();

        while (!participantsList.isEmpty()) {
            resultOrder.add(participantsList.get(startIndex));
            participantsList.remove(startIndex);
            startIndex = (startIndex + 2) % participantsList.size();
        }

        return resultOrder.get(resultOrder.size() - 1) + " победил. Результат: " + resultOrder;
    }
}
