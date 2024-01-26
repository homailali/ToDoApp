package life.homail.todoapp.SingleTon;

import java.util.ArrayList;

public class TasksDataHolder {
    private static final TasksDataHolder TASKS_DATA_HOLDER=new TasksDataHolder();
    private ArrayList<String> remainingTasks=new ArrayList<>();
    private ArrayList<String> deletedTasks=new ArrayList<>();
    private ArrayList<String> completedTasks=new ArrayList<>();
    public static TasksDataHolder getInstance(){
        return TasksDataHolder.TASKS_DATA_HOLDER;
    }



    public void addOneTask(String task){
        this.remainingTasks.add(task);
    }
    public void addManyTasks(ArrayList<String> remainingTasks){
        this.remainingTasks.addAll(remainingTasks);
    }
    public String getTaskAt(int position){
        return this.remainingTasks.get(position);
    }
    public void deleteTaskAt(int position){
        this.remainingTasks.remove(position);
    }
    public ArrayList<String> getTasks(){
        return this.remainingTasks;
    }




    public void addCompletedTask(String completedTask){
        this.completedTasks.add(completedTask);
    }
    public String getCompletedTaskAt(int position){
        return this.completedTasks.get(position);
    }


    public String getDeletedTaskAt(int position){
        return this.deletedTasks.get(position);
    }
    public void addDeletedTask(String deletedTask){
        this.deletedTasks.add(deletedTask);
    }
}
