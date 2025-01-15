import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    public static void writeFile(float amount, String category, String description, LocalDate now) {
        try (FileWriter writer = new FileWriter("Expense.txt", true)) {
            writer.write("Date: " + now + "\n");
            writer.write("Amount: " + amount + "\n");
            writer.write("Category: " + category + "\n");
            writer.write("Description: " + description + "\n");
            writer.write("\n");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }

    public static List<String> retrieveRecords(String date) {
        List<String> result = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("Expense.txt"))) {
            String line;
            StringBuilder record = new StringBuilder();
            boolean matchingRecord = false;

            while ((line = reader.readLine()) != null) {
                record.append(line).append("\n");

                if (line.startsWith("Date:")) {
                    String recordDate = line.substring(6);

                    if (date != null && !recordDate.equals(date)) {
                        matchingRecord = false;
                    } else {
                        matchingRecord = true;
                    }
                }

                if (matchingRecord && line.isEmpty()) {
                    result.add(record.toString());
                    record.setLength(0);
                    matchingRecord = false;
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }

        return result;
    }

    public static void getWeeklyTotal(String startDateStr, String endDateStr) {

        LocalDate startDate = LocalDate.parse(startDateStr);
        LocalDate endDate = LocalDate.parse(endDateStr);

        LocalDate currentDate = startDate;
        while (!currentDate.isAfter(endDate)) {
            if (currentDate.getDayOfWeek() == DayOfWeek.MONDAY) {

                for (int i = 0; i < 7; i++) {
                    LocalDate date = currentDate.plusDays(i);
                    if (!date.isAfter(endDate)) {
                        System.out.println(retrieveRecords(date.toString()));
                    }
                }
            }
            currentDate = currentDate.plusDays(1);
        }
    }

    public static void getMonthlyTotal(String month) {
        List<String> result = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("Expense.txt"))) {
            String line;
            StringBuilder record = new StringBuilder();
            boolean matchingRecord = false;

            while ((line = reader.readLine()) != null) {
                record.append(line).append("\n");

                if (line.startsWith("Date:")) {
                    String recordDate = line.substring(6, 13);

                    if (month != null && !recordDate.equals(month)) {
                        matchingRecord = false;
                    } else {
                        matchingRecord = true;
                    }
                }

                if (matchingRecord && line.isEmpty()) {
                    result.add(record.toString());
                    record.setLength(0);
                    matchingRecord = false;
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
        System.out.println(result);
        // return result;
    }
}