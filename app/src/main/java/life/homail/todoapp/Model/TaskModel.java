package life.homail.todoapp.Model;

public class TaskModel {
    private String actualTask;
    private int taskNumber;

    public TaskModel(String actualTask, int taskNumber) {
        this.actualTask = actualTask;
        this.taskNumber = taskNumber;
    }

    public TaskModel(String actualTask) {
        this.actualTask = actualTask;
    }

    public String getActualTask() {
        return actualTask;
    }

    public void setActualTask(String actualTask) {
        this.actualTask = actualTask;
    }


    public int getTaskNumber() {
        return taskNumber;
    }

    public void setTaskNumber(int taskNumber) {
        this.taskNumber = taskNumber;
    }
}