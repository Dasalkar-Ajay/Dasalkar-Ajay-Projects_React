import java.time.LocalDate;

public class ExpenseManager {

    public void addExpense(float amount, String category, String description, LocalDate now) {
        FileHandler.writeFile(amount, category, description, now);
        System.out.println("Added successfully:");
    }

    public void getDailyTotal(String today) {
        System.out.println(FileHandler.retrieveRecords(today));
    }

    public void getWeeklyTotal(String startDate, String endDate) {
        FileHandler.getWeeklyTotal(startDate, endDate);
    }

    public void getMonthlyTotal(String month) {
        FileHandler.getMonthlyTotal(month);
    }

}