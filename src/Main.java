import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();

        System.out.print("Enter title: ");
        String title = input.nextLine();

        System.out.print("Enter description: ");
        String description = input.nextLine();

        Task task = new Task();
        task.setId(1L);
        task.setTitle(title);
        task.setDescription(description);
        task.setStatus(Status.STATUS_PENDING);

        taskManager.addTask(task);
    }
}