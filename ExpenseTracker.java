import java.io.*;
import java.util.*;

class Expense {
    double amount;
    String category;
    String date;
    String description;

    Expense(double amount, String category, String date, String description) {
        this.amount = amount;
        this.category = category;
        this.date = date;
        this.description = description;
    }

    // Convert object to string (for saving)
    public String toString() {
        return amount + "," + category + "," + date + "," + description;
    }

    // Convert string back to object (for loading)
    static Expense fromString(String line) {
        String[] parts = line.split(",");
        return new Expense(
                Double.parseDouble(parts[0]),
                parts[1],
                parts[2],
                parts[3]
        );
    }

    void display() {
        System.out.println("Amount: " + amount +
                " | Category: " + category +
                " | Date: " + date +
                " | Desc: " + description);
    }
}

public class ExpenseTracker {

    static ArrayList<Expense> expenses = new ArrayList<>();
    static String FILE_NAME;

    public static void main(String[] args) {

        // Command Line Argument
        if (args.length == 0) {
            System.out.println("Usage: java ExpenseTracker <filename>");
            return;
        }

        FILE_NAME = args[0];

        Scanner sc = new Scanner(System.in);
        loadFromFile();

        while (true) {
            System.out.println("\n===== Expense Tracker =====");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Total Expense");
            System.out.println("4. Search by Category");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addExpense(sc);
                    break;
                case 2:
                    viewExpenses();
                    break;
                case 3:
                    totalExpense();
                    break;
                case 4:
                    searchByCategory(sc);
                    break;
                case 5:
                    saveToFile();
                    System.out.println("Data saved. Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // Add Expense
    static void addExpense(Scanner sc) {
        System.out.print("Enter amount: ");
        double amount = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter category: ");
        String category = sc.nextLine();

        System.out.print("Enter date: ");
        String date = sc.nextLine();

        System.out.print("Enter description: ");
        String desc = sc.nextLine();

        Expense e = new Expense(amount, category, date, desc);
        expenses.add(e);

        saveToFile(); // auto-save
        System.out.println("Expense added successfully!");
    }

    // View Expenses
    static void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses found.");
            return;
        }

        System.out.println("\n--- All Expenses ---");
        for (Expense e : expenses) {
            e.display();
        }
    }

    // Total Expense
    static void totalExpense() {
        double total = 0;
        for (Expense e : expenses) {
            total += e.amount;
        }
        System.out.println("Total Expense: " + total);
    }

    // Search Feature
    static void searchByCategory(Scanner sc) {
        System.out.print("Enter category to search: ");
        String search = sc.nextLine();

        boolean found = false;

        System.out.println("\n--- Search Results ---");
        for (Expense e : expenses) {
            if (e.category.equalsIgnoreCase(search)) {
                e.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No expenses found for this category.");
        }
    }

    // Save to File
    static void saveToFile() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Expense e : expenses) {
                pw.println(e.toString());
            }
        } catch (IOException e) {
            System.out.println("Error saving file.");
        }
    }

    // Load from File
    static void loadFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                expenses.add(Expense.fromString(line));
            }
        } catch (IOException e) {
            System.out.println("No previous data found.");
        }
    }
}