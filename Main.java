import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        taskManager.loadTasksFromFile();  // Load tasks at the beginning
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Task Tracker CLI!");

        while (true) {
            System.out.print("Enter command (add/list/exit): ");
            String command = scanner.nextLine();

            switch (command) {
                case "add":
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    taskManager.addTask(description);
                    break;
                case "list":
                    taskManager.listTasks();
                    break;
                case "exit":
                    taskManager.saveTasksToFile();  // Save tasks before exiting
                    System.out.println("Exiting Task Tracker. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid command. Try again.");
            }
        }
    }
}
