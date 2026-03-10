import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Handles saving and loading tasks to and from a CSV file.
 */
public class FileManager {
    private String fileName;

    public FileManager(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Saves the list of tasks to the specified file.
     * @param tasks The list of tasks to save.
     */
    public void saveTasks(List<Task> tasks) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (Task task : tasks) {
                writer.println(task.toFileString());
            }
        } catch (IOException e) {
            System.out.println("Error while saving tasks: " + e.getMessage());
        }
    }

    /**
     * Loads tasks from the specified file.
     * @return A list of tasks read from the file.
     */
    public List<Task> loadTasks() {
        List<Task> tasks = new ArrayList<>();
        File file = new File(fileName);

        if (!file.exists()) {
            return tasks; // It's normal for the file not to exist on first run
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 4) {
                    Task task = new Task();
                    task.setId(Long.parseLong(parts[0]));
                    task.setTitle(parts[1]);
                    task.setDescription(parts[2]);
                    task.setStatus(Status.valueOf(parts[3]));
                    tasks.add(task);
                }
            }
        } catch (IOException | IllegalArgumentException e) {
            System.out.println("Error while reading file: " + e.getMessage());
        }
        return tasks;
    }
}