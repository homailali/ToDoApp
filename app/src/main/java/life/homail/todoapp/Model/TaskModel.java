package life.homail.todoapp.Model;

public class TasksModel {
    private String actualTask;
    private int taskNumber;


    public TasksModel(int taskNumber,String actualTask) {
        this.actualTask = actualTask;
        this.taskNumber = taskNumber;
    }
    public TasksModel(String actualTask) {
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
