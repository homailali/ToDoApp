package life.homail.todoapp.SingleTon;
import java.util.ArrayList;

import life.homail.todoapp.HomePage.HomePageMain;
import life.homail.todoapp.Model.TaskModel;
public class SingleTon {
    private static final SingleTon TASKS_DATA_HOLDER=new SingleTon();
    private HomePageMain homePageMain;
    private ArrayList<TaskModel> remainingTasksArr=new ArrayList<>();
    private ArrayList<TaskModel> deletedTasksArr=new ArrayList<>();
    private ArrayList<TaskModel> completedTasksArr=new ArrayList<>();
    public static SingleTon getSingleTon(){
        return SingleTon.TASKS_DATA_HOLDER;
    }

    public HomePageMain getHomePageMain() {
        return homePageMain;
    }

    public void setHomePageMain(HomePageMain homePageMain) {
        this.homePageMain = homePageMain;
    }

    public ArrayList<TaskModel> getRemainingTasksArr() {
        return remainingTasksArr;
    }

    public void setRemainingTasksArr(ArrayList<TaskModel> remainingTasksArr) {
        this.remainingTasksArr = remainingTasksArr;
    }

    public ArrayList<TaskModel> getDeletedTasksArr() {
        return deletedTasksArr;
    }

    public void setDeletedTasksArr(ArrayList<TaskModel> deletedTasksArr) {
        this.deletedTasksArr = deletedTasksArr;
    }

    public ArrayList<TaskModel> getCompletedTasksArr() {
        return completedTasksArr;
    }

    public void setCompletedTasksArr(ArrayList<TaskModel> completedTasksArr) {
        this.completedTasksArr = completedTasksArr;
    }



}