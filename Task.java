import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// properties representing different characteristics of a task
public class Task {
    private int id;
    private String description;
    private String status; // possible values: "todo", "in-progress", "done"
    private String createdAt;
    private String updatedAt;

    // constructors to be called when we create a new task
    // it sets id, description, and initializes status as "todo"
    // also captures the current date and time for createdAt and updatedAt
    public Task(int id, String description) {
        this.id = id;
        this.description = description;
        this.status = "todo"; // default when a task is created
        this.createdAt = getCurrentTimestamp();
        this.updatedAt = this.createdAt;
    }

    // method to get the current date and time as a string
    private String getCurrentTimestamp() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    // getters to access task properties
    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    // setters to modify task properties
    public void setDescription(String description) {
        this.description = description;
        this.updatedAt = getCurrentTimestamp();
    }

    public void setStatus(String status) {
        this.status = status;
        this.updatedAt = getCurrentTimestamp();
    }

    // toString method to print task details in a readable format
    @Override
    public String toString() {
        return "Task ID: " + id + ", Description: " + description + ", Status: " + status + 
               ", Created At: " + createdAt + ", Updated At: " + updatedAt;
    }
}
