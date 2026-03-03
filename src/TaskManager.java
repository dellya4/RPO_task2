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

    public void addTasks(Task new_task) {
        tasks.add(new_task);
    }

    public void completedTask(Task task) {
    }
}
