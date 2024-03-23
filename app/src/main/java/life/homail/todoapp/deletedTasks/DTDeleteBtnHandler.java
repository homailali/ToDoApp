package life.homail.todoapp.deletedTasks;

import life.homail.todoapp.Model.TaskModel;
import life.homail.todoapp.MyToast.MyToast;
import life.homail.todoapp.SingleTon.SingleTon;

public class DTDeleteBtnHandler {
    private DeletedTasksMain deletedTasksMain;
    public DTDeleteBtnHandler(DeletedTasksMain deletedTasksMain) {
        this.deletedTasksMain = deletedTasksMain;
    }
    protected void dtDeleteBtnHandlerMain(TaskModel taskModel){
        boolean bool= SingleTon.getSingleTon().getHomePageMain().getDeletedTasksDB().deleteDeletedTaskFromDB(taskModel);
        if (bool){
            MyToast.makeToast("Task deleted successfully",this.deletedTasksMain);
            SingleTon.getSingleTon().setDeletedTasksArr(SingleTon.getSingleTon().getHomePageMain().getDeletedTasksDB().getAllDeletedTasksFromDB());
            this.deletedTasksMain.getDtAdapter().notifyDataSetChanged();
            this.deletedTasksMain.setVisibilityOfNoTasksDeletedTv();
        } else MyToast.makeToast("Could not delete task",this.deletedTasksMain);
    }
}
