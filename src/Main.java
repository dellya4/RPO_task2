import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        FileManager fileManager = new FileManager("tasks.csv");

        TaskManager taskManager = new TaskManager(fileManager.loadTasks());

        boolean running = true;
        while (running) {
            System.out.println("    Task Manager    ");
            System.out.println("1 - add task\n2 - list tasks\n3 - complete task\n4 - delete task\n5 - save\n6 - exit");
            System.out.print("Enter your choice: ");

            String choice = input.nextLine();
            switch (choice) {
                case "1":
                    System.out.print("Enter title: ");
                    String title = input.nextLine();
                    System.out.print("Enter description: ");
                    String description = input.nextLine();

                    Task task = new Task();
                    task.setTitle(title);
                    task.setDescription(description);

                    taskManager.addTask(task);
                    break;
                case "2":
                    taskManager.listTasks();
                    break;
                case "3":
                    System.out.println("Enter task id: ");
                    long completeId = Long.parseLong(input.nextLine());
                    taskManager.completedTask(completeId);
                    System.out.println("Task completed successfully");
                    break;
                case "4":
                    System.out.println("Enter task id: ");
                    long deleteId = Long.parseLong(input.nextLine());
                    taskManager.deleteTask(deleteId);
                    System.out.println("Task has been deleted.");
                    break;
                case "5":
                    fileManager.saveTasks(taskManager.getTasks());
                    System.out.println("Task list has been saved");
                    break;
                case "6":
                    System.out.println("Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }





    }
}