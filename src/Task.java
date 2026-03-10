/**
 * Represents a single task with an ID, title, description, and completion status.
 */
public class Task {
    private Long id;
    private String title;
    private String description;
    private Status status;

    public Task() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }

    @Override
    public String toString() {
        return "id = " + getId() + ", title = " + getTitle() + ", description = " + getDescription() + ", status = " + getStatus();
    }

    /**
     * Converts task data to a CSV formatted string.
     * @return String formatted with semicolons for file saving.
     */
    public String toFileString() {
        return getId() + ";" + getTitle() + ";" + getDescription() + ";" + getStatus();
    }
}