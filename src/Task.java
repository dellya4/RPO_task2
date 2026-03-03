

public class Task {
    private Long id;
    private String Title;
    private String Description;
    private Status Status;

    public Task() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Status getStatus() {
        return Status;
    }

    public void setStatus(Status status) {
        Status = status;
    }

    @Override
    public String toString() {
        return "id = " + id + ", title = " + Title + ", description = " + Description + ", status = " + Status;
    }
}
