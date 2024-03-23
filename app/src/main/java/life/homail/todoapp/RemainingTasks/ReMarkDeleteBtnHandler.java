package life.homail.todoapp.RemainingTasks;

import life.homail.todoapp.Model.TaskModel;
import life.homail.todoapp.MyToast.MyToast;
import life.homail.todoapp.SingleTon.SingleTon;

public class ReMarkDeleteBtnHandler {
    private RemainingTasksMain remainingTasksMain;
    public ReMarkDeleteBtnHandler(RemainingTasksMain remainingTasksMain) {
        this.remainingTasksMain = remainingTasksMain;
    }
    protected void reMarkDeleteBtnHandlerMain(TaskModel taskModel){
        boolean bool= SingleTon.getSingleTon().getHomePageMain().getRemainingTasksDB().deleteRemainingTaskFromDB(taskModel);
        if (bool) this.addTaskModelToDeletedTasksDB(taskModel);
        else MyToast.makeToast("Error deleting task",this.remainingTasksMain);
    }
    private void addTaskModelToDeletedTasksDB(TaskModel taskModel){
        boolean bool=SingleTon.getSingleTon().getHomePageMain().getDeletedTasksDB().addDeletedTaskToDB(taskModel);
        if (bool){
            MyToast.makeToast("Task deleted successfully",this.remainingTasksMain);
            SingleTon.getSingleTon().setDeletedTasksArr(SingleTon.getSingleTon().getHomePageMain().getDeletedTasksDB().getAllDeletedTasksFromDB());
            SingleTon.getSingleTon().setRemainingTasksArr(SingleTon.getSingleTon().getHomePageMain().getRemainingTasksDB().getAllRemainingTasksFromDB());
            this.remainingTasksMain.getRtAdapter().notifyDataSetChanged();
            this.remainingTasksMain.setVisibilityOfNoTasksRemainingTv();
        } else {
            SingleTon.getSingleTon().getHomePageMain().getRemainingTasksDB().addRemainingTaskToDB(taskModel);
            MyToast.makeToast("Error deleting task",this.remainingTasksMain);
        }
    }
}
