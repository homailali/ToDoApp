package life.homail.todoapp.Model;

public class TimeAndTask {
    // Fields
    private String task;
    private String date;
    private String time;
    // Constructor
    public TimeAndTask(String task, String date, String time) {
        this.task = task;
        this.date = date;
        this.time = time;
    }
    // Methods
    // Setters
    public void setTask(String task) {
        this.task = task;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public void setTime(String time) {
        this.time = time;
    }
    // Getters
    public String getTask() {
        return this.task;
    }
    public String getDate() {
        return this.date;
    }
    public String getTime() {
        return this.time;
    }
}
