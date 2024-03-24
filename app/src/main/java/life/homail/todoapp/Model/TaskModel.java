package life.homail.todoapp.Model;

public class TaskModel {
    private String actualTask;
    private long taskNumber;
    private String time;
    private String date;



    public TaskModel(long taskNumber,String actualTask, String time, String date) {
        this.actualTask = actualTask;
        this.taskNumber = taskNumber;
        this.time = time;
        this.date = date;
    }

    public String getActualTask() {
        return actualTask;
    }

    public void setActualTask(String actualTask) {
        this.actualTask = actualTask;
    }


    public long getTaskNumber() {
        return taskNumber;
    }

    public void setTaskNumber(long taskNumber) {
        this.taskNumber = taskNumber;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}