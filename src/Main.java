import java.util.Scanner;

/**
 * Entry point for the CLI Task Manager application.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileManager fileManager = new FileManager("tasks.csv");
        TaskManager taskManager = new TaskManager(fileManager.loadTasks());

        boolean isRunning = true;
        while (isRunning) {
            printMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    handleAddTask(scanner, taskManager);
                    break;
                case "2":
                    taskManager.listTasks();
                    break;
                case "3":
                    handleCompleteTask(scanner, taskManager);
                    break;
                case "4":
                    handleDeleteTask(scanner, taskManager);
                    break;
                case "5":
                    fileManager.saveTasks(taskManager.getTasks());
                    System.out.println("Task list has been saved.");
                    break;
                case "6":
                    System.out.println("Goodbye!");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please select a number from 1 to 6.");
            }
        }
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n--- Task Manager ---");
        System.out.println("1 - Add task");
        System.out.println("2 - List tasks");
        System.out.println("3 - Complete task");
        System.out.println("4 - Delete task");
        System.out.println("5 - Save");
        System.out.println("6 - Exit");
        System.out.print("Enter your choice: ");
    }

    private static void handleAddTask(Scanner scanner, TaskManager taskManager) {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter description: ");
        String description = scanner.nextLine();

        Task task = new Task();
        task.setTitle(title);
        task.setDescription(description);

        taskManager.addTask(task);
        System.out.println("Task added successfully.");
    }

    private static void handleCompleteTask(Scanner scanner, TaskManager taskManager) {
        System.out.print("Enter task ID to complete: ");
        try {
            long completeId = Long.parseLong(scanner.nextLine());
            taskManager.completedTask(completeId);
            System.out.println("Task marked as completed.");
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid ID format. Please enter a valid number.");
        }
    }

    private static void handleDeleteTask(Scanner scanner, TaskManager taskManager) {
        System.out.print("Enter task ID to delete: ");
        try {
            long deleteId = Long.parseLong(scanner.nextLine());
            taskManager.deleteTask(deleteId);
            System.out.println("Task has been deleted.");
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid ID format. Please enter a valid number.");
        }
    }
}