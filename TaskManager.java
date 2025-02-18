import java.util.ArrayList;
import java.util.List;
import java.io.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

public class TaskManager {
    private List<Task> tasks;

    public TaskManager() {
        this.tasks = new ArrayList<>();
    }

    // Method to add a new task
    public void addTask(String description) {
        int id = tasks.size() + 1; // generate a new ID based on the current size of the list
        Task newTask = new Task(id, description);
        tasks.add(newTask);
        System.out.println("Task added successfully (ID: " + id + ")");
    }

    // Method to list all tasks
    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
            return;
        }
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    // Method to update tasks
    public void updateTask(int id, String newDescription) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.setDescription(newDescription);
                System.out.println("Task updated successfully");
                return;
            }
        }
        System.out.println("Task not found.");
    }

    // Method to delete tasks
    public void deleteTask(int id) {
        boolean removed = tasks.removeIf(task -> task.getId() == id);
        if (removed) {
            System.out.println("Task deleted successfully.");
        } else {
            System.out.println("Task not found.");
        }
    }

    public void loadTasksFromFile() {
        File file = new File("tasks.json");
        if (!file.exists()) {
            System.out.println("No tasks to load.");
            return;  // If the file doesn't exist, there are no tasks to load
        }

        Gson gson = new Gson();
        try (Reader reader = new FileReader(file)) {
            Type listType = new TypeToken<ArrayList<Task>>() {}.getType();
            tasks = gson.fromJson(reader, listType);  // Convert JSON back to a list of Task objects
            if (tasks == null) {
                tasks = new ArrayList<>();
            }
            System.out.println("Tasks loaded successfully!");
        } catch (IOException e) {
            System.out.println("Error loading tasks: " + e.getMessage());
        }
    }

    public void saveTasksToFile() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();  // For nice formatting
        try (Writer writer = new FileWriter("tasks.json")) {
            gson.toJson(tasks, writer);  // Convert the tasks list to JSON and write it to the file
            System.out.println("Tasks saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }
}