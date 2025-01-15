
import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        ExpenseManager expenseManager = new ExpenseManager();
        Scanner scanner = new Scanner(System.in);
        char ch;
        do {
            System.out.println("\n1. Add Expense");
            System.out.println("2. View Day's Summary");
            System.out.println("3. View Weekly Summary");
            System.out.println("4. View Monthly Summary");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount: ");
                    float amount = scanner.nextFloat();
                    System.out.print("Enter category: Food || Travel || Utility\n");
                    String category = scanner.next();
                    System.out.print("Enter description:\n ");
                    String description = scanner.next();
                    expenseManager.addExpense(amount, category, description, LocalDate.now());
                    break;

                case 2:
                    System.out.print("Enter today's date (YYYY-MM-DD):(2025-12-29) ");
                    String today = scanner.nextLine();
                    expenseManager.getDailyTotal(today);
                    break;

                case 3:
                    System.out.print("Enter start date (YYYY-MM-DD):(2025-12-29) ");
                    String startDate = scanner.nextLine();
                    System.out.print("Enter end date (YYYY-MM-DD): (2025-12-29)");
                    String endDate = scanner.nextLine();
                    expenseManager.getWeeklyTotal(startDate, endDate);

                    break;

                case 4:
                    System.out.print("Enter month (YYYY-MM): (2025-12)");
                    String month = scanner.nextLine();
                    expenseManager.getMonthlyTotal(month);
                    break;

                case 5:
                    System.out.println("Exiting... All data saved.");
                    System.exit(0);

                default:
                    System.out.println("Invalid option, try again.");
            }
            System.out.println("if you want to continue Enter y || Y");

            ch = scanner.next().charAt(0);
        } while (ch == 'y' || ch == 'Y');
        scanner.close();
    }
}