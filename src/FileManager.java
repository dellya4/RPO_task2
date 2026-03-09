import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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


}
