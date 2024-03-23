package life.homail.todoapp.CompletedTasks;

import life.homail.todoapp.Model.TaskModel;
import life.homail.todoapp.MyToast.MyToast;
import life.homail.todoapp.SingleTon.SingleTon;

public class CoRestoreBtnHandler {
    private CompletedTasksMain completedTasksMain;

    public CoRestoreBtnHandler(CompletedTasksMain completedTasksMain) {
        this.completedTasksMain = completedTasksMain;
    }
    protected void coRestoreBtnHandlerMain(TaskModel taskModel){
        boolean bool= SingleTon.getSingleTon().getHomePageMain().getCompletedTasksDB().deleteCompletedTaskFromDB(taskModel);
        if (bool) this.addTaskToRemainingDB(taskModel);
        else MyToast.makeToast("Error restoring task",this.completedTasksMain);
    }
    private void addTaskToRemainingDB(TaskModel taskModel){
        boolean bool=SingleTon.getSingleTon().getHomePageMain().getRemainingTasksDB().addRemainingTaskToDB(taskModel);
        if (bool){
            MyToast.makeToast("Task restored successfully",this.completedTasksMain);
            SingleTon.getSingleTon().setCompletedTasksArr(SingleTon.getSingleTon().getHomePageMain().getCompletedTasksDB().getAllCompletedTasksFromDB());
            SingleTon.getSingleTon().setRemainingTasksArr(SingleTon.getSingleTon().getHomePageMain().getRemainingTasksDB().getAllRemainingTasksFromDB());
            this.completedTasksMain.ctAdapter.notifyDataSetChanged();
            this.completedTasksMain.setVisibilityOfNoTasksCompletedTv();
        } else {
            SingleTon.getSingleTon().getHomePageMain().getCompletedTasksDB().addCompletedTaskToDB(taskModel);
            MyToast.makeToast("Error restoring task",this.completedTasksMain);
        }
    }
}
