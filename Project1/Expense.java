import java.time.LocalDate;

public class Expense {
    private float amount;
    private String category;
    private String description;
    private LocalDate date;

    public Expense(float amount, String category, String description, LocalDate date) {
        this.amount = amount;
        this.category = category;
        this.description = description;
        this.date = date;
    }

    public float getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date.toString();
    }

    public String toString() {
        return "Amount: $" + amount + ", Category: " + category + ", Description: " + description + ", Date: " + date;
    }
}
