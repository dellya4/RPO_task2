import java.util.ArrayList;
import java.util.List;

/**
 * Manages operations related to tasks such as adding, listing, completing, and deleting.
 */
public class TaskManager {
    private List<Task> tasks = new ArrayList<>();

    public TaskManager() {}

    public TaskManager(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    /**
     * Adds a new task. Automatically calculates and assigns the next available ID.
     * @param task The task to be added.
     */
    public void addTask(Task task) {
        long maxId = tasks.stream().mapToLong(Task::getId).max().orElse(0L);
        task.setId(maxId + 1);
        task.setStatus(Status.PENDING);
        tasks.add(task);
    }

    /**
     * Marks a task as completed based on its ID.
     * @param id The ID of the task to complete.
     */
    public void completedTask(Long id) {
        for (Task task : tasks) {
            if (task.getId().equals(id)) {
                task.setStatus(Status.COMPLETED);
                return; // Early exit once found
            }
        }
    }

    /**
     * Prints all current tasks to the console.
     */
    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
            return;
        }
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    /**
     * Deletes a task by its ID.
     * @param id The ID of the task to delete.
     */
    public void deleteTask(Long id) {
        tasks.removeIf(task -> task.getId().equals(id));
    }
}