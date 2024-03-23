package life.homail.todoapp.deletedTasks;

import life.homail.todoapp.Model.TaskModel;
import life.homail.todoapp.MyToast.MyToast;
import life.homail.todoapp.SingleTon.SingleTon;

public class DtRestoreBtnHandler {
    private DeletedTasksMain deletedTasksMain;

    public DtRestoreBtnHandler(DeletedTasksMain deletedTasksMain) {
        this.deletedTasksMain = deletedTasksMain;
    }
    protected void DtRestoreBtnHandlerMain(TaskModel taskModel){
        boolean bool= SingleTon.getSingleTon().getHomePageMain().getDeletedTasksDB().deleteDeletedTaskFromDB(taskModel);
        if (bool) this.addTaskModelToRemainingTasksDB(taskModel);
        else MyToast.makeToast("Error restoring the task",this.deletedTasksMain);
    }
    private void addTaskModelToRemainingTasksDB(TaskModel taskModel){
        boolean bool=SingleTon.getSingleTon().getHomePageMain().getRemainingTasksDB().addRemainingTaskToDB(taskModel);
        if (bool){
            SingleTon.getSingleTon().setDeletedTasksArr(SingleTon.getSingleTon().getHomePageMain().getDeletedTasksDB().getAllDeletedTasksFromDB());
            SingleTon.getSingleTon().setRemainingTasksArr(SingleTon.getSingleTon().getHomePageMain().getRemainingTasksDB().getAllRemainingTasksFromDB());
            this.deletedTasksMain.getDtAdapter().notifyDataSetChanged();
            this.deletedTasksMain.setVisibilityOfNoTasksDeletedTv();
            MyToast.makeToast("Task restored successfully",this.deletedTasksMain);
        } else {
            SingleTon.getSingleTon().getHomePageMain().getDeletedTasksDB().addDeletedTaskToDB(taskModel);
            MyToast.makeToast("Error restoring the task",this.deletedTasksMain);
        }
    }
}