import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Consumer consumer = new Consumer();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Please choose an option:");
            System.out.println("1 - accept");
            System.out.println("2 - mean");
            System.out.println("3 - exit");

            int option = scanner.nextInt();

            if (option == 1) {
                System.out.println("Enter a number to consume:");
                int number = scanner.nextInt();
                consumer.accept(number);
            } else if (option == 2) {
                System.out.println("The mean of numbers consumed in the last 5 minutes is: " + consumer.mean());
            } else if (option == 3) {
                System.out.println("Exit");
                break;
            } else {
                System.out.println("Invalid option.");
            }
        }

        scanner.close();
    }
}