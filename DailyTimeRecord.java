import java.util.Scanner;
import java.util.HashMap;

public class DailyTimeRecord {
    private static HashMap<String, String> timeRecords = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    logTimeIn(scanner);
                    break;
                case 2:
                    logTimeOut(scanner);
                    break;
                case 3:
                    displayTimeRecords();
                    break;
                case 4:
                    System.out.println("Exiting the Daily Time Record system. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\n=== Daily Time Record System ===");
        System.out.println("1. Log Time In");
        System.out.println("2. Log Time Out");
        System.out.println("3. Display Time Records");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void logTimeIn(Scanner scanner) {
        System.out.print("Enter your employee ID: ");
        String employeeId = scanner.nextLine();
        String timeIn = getTime();

        timeRecords.put(employeeId, timeIn);

        System.out.println("Time in recorded for employee " + employeeId + ": " + timeIn);
    }

    private static void logTimeOut(Scanner scanner) {
        System.out.print("Enter your employee ID: ");
        String employeeId = scanner.nextLine();

        if (timeRecords.containsKey(employeeId)) {
            String timeOut = getTime();
            System.out.println("Time out recorded for employee " + employeeId + ": " + timeOut);
            timeRecords.remove(employeeId); // Remove the entry after logging time out
        } else {
            System.out.println("No time in record found for employee " + employeeId);
        }
    } 

   private static void displayTimeRecords() {
        System.out.println("\n=== Time Records ===");
        if (timeRecords.isEmpty()) {
            System.out.println("No time records available.");
        } else {
            for (String employeeId : timeRecords.keySet()) {
                String timeIn = timeRecords.get(employeeId);
                System.out.println("Employee " + employeeId + ": Time In - " + timeIn);
            }
        }
    }

    private static String getTime() {
        // In a real application, you might use a proper date/time library.
        // For simplicity, this example uses the current system time in milliseconds.
        return String.valueOf(System.currentTimeMillis());
    }
}
