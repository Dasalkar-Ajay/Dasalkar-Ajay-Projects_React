import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkShortener linkShortener = new LinkShortener();

        System.out.println("Welcome to the Link Shortener!");

        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Shorten a URL");
            System.out.println("2. Expand a short URL");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    System.out.print("Enter the long URL to shorten: ");
                    String longUrl = scanner.nextLine();
                    String shortUrl = linkShortener.shortenUrl(longUrl);
                    System.out.println("Shortened URL: " + shortUrl);
                    break;

                case 2:
                    System.out.print("Enter the short URL to expand: ");
                    String shortUrlInput = scanner.nextLine();
                    String expandedUrl = linkShortener.expandUrl(shortUrlInput);
                    System.out.println("Expanded URL: " + expandedUrl);
                    break;

                case 3:
                    System.out.println("Exiting the application.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
