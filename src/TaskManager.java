import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> tasks = new ArrayList<Task>();

    public TaskManager() {
    }

    public TaskManager(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void addTask(Task task) {
        task.setId((long) tasks.size());
        task.setStatus(Status.STATUS_PENDING);
        tasks.add(task);
    }

    public void completedTask(Long id) {
        for (Task task : tasks) {
            if (task.getId().equals(id)) {
                task.setStatus(Status.STATUS_COMPLETED);
            }
        }
    }

    public void listTasks() {
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    public void deleteTask(Long id) {
        tasks.removeIf(task -> task.getId().equals(id));
    }

}
