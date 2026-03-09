import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    private String fileName;

    public FileManager(String fileName) {
        this.fileName = fileName;
    }

    public FileManager() {}

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void saveTasks(List<Task> tasks) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (Task task : tasks) {
                writer.println(task.toFileString());
            }
        } catch (IOException e) {
            System.out.println("Error while saving tasks: " + e.getMessage());
        }
    }

    public List<Task> loadTasks() {
        List<Task> tasks = new ArrayList<>();
        File file = new File(fileName);

        if (!file.exists()) {
            System.out.println("File does not exist");
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
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
        } catch (IOException e) {
            System.out.println("Error while reading file: " + e.getMessage());
        }
        return tasks;
    }

}
