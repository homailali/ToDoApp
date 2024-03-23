package life.homail.todoapp.SingleTon;

import java.util.ArrayList;

public class TasksDataHolderAndOtherStaticMethods {

    private static boolean bool=true;

    private static final TasksDataHolderAndOtherStaticMethods TASKS_DATA_HOLDER=new TasksDataHolderAndOtherStaticMethods();
    private ArrayList<String> remainingTasks=new ArrayList<>();
    private ArrayList<String> deletedTasks=new ArrayList<>();
    private ArrayList<String> completedTasks=new ArrayList<>();
    public static TasksDataHolderAndOtherStaticMethods getInstance(){
        return TasksDataHolderAndOtherStaticMethods.TASKS_DATA_HOLDER;
    }



    public void addOneRemainingTask(String task){
        this.remainingTasks.add(task);
    }
    public String getRemainingTaskAt(int position){
        return this.remainingTasks.get(position);
    }
    public void deleteRemainingTaskAt(int position){
        this.remainingTasks.remove(position);
    }
    public ArrayList<String> getRemainingTasks(){
        return this.remainingTasks;
    }




    public void addCompletedTask(String completedTask){
        this.completedTasks.add(completedTask);
    }
    public String getCompletedTaskAt(int position){
        return this.completedTasks.get(position);
    }
    public ArrayList<String> getCompletedTasks(){
        return this.completedTasks;
    }


    public ArrayList<String> getDeletedTasks(){
        return this.deletedTasks;
    }
    public String getDeletedTaskAt(int position){
        return this.deletedTasks.get(position);
    }
    public void addDeletedTask(String deletedTask){
        this.deletedTasks.add(deletedTask);
    }

    public static boolean ifAllowedToGetSpData(){
        if (bool){
            bool = false;
            return true;
        }
        return false;
    }
}