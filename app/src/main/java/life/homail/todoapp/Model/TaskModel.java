package life.homail.todoapp.Model;

public class TaskModel {
    private String actualTask;


    public TaskModel(String actualTask) {
        this.actualTask = actualTask;
    }

    public String getActualTask() {
        return actualTask;
    }

    public void setActualTask(String actualTask) {
        this.actualTask = actualTask;
    }


}
