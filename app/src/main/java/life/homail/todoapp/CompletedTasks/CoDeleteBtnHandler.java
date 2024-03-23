package life.homail.todoapp.CompletedTasks;

import life.homail.todoapp.Model.TaskModel;
import life.homail.todoapp.MyToast.MyToast;
import life.homail.todoapp.SingleTon.SingleTon;

public class CoDeleteBtnHandler {
    private CompletedTasksMain completedTasksMain;

    public CoDeleteBtnHandler(CompletedTasksMain completedTasksMain) {
        this.completedTasksMain = completedTasksMain;
    }
    protected void coDeleteBtnHandlerMain(TaskModel taskModel){
        boolean bool=SingleTon.getSingleTon().getHomePageMain().getCompletedTasksDB().deleteCompletedTaskFromDB(taskModel);
        if (bool) this.addTaskModelToDeleteDB(taskModel);
        else MyToast.makeToast("Could  not delete task",this.completedTasksMain);
    }
    private void addTaskModelToDeleteDB(TaskModel taskModel){
        boolean bool=SingleTon.getSingleTon().getHomePageMain().getDeletedTasksDB().addDeletedTaskToDB(taskModel);
        if (bool){
            MyToast.makeToast("Task deleted successfully",this.completedTasksMain);
            SingleTon.getSingleTon().setCompletedTasksArr(SingleTon.getSingleTon().getHomePageMain().getCompletedTasksDB().getAllCompletedTasksFromDB());
            SingleTon.getSingleTon().setDeletedTasksArr(SingleTon.getSingleTon().getHomePageMain().getDeletedTasksDB().getAllDeletedTasksFromDB());
            this.completedTasksMain.ctAdapter.notifyDataSetChanged();
            this.completedTasksMain.setVisibilityOfNoTasksCompletedTv();
        } else {
            SingleTon.getSingleTon().getHomePageMain().getCompletedTasksDB().addCompletedTaskToDB(taskModel);
            MyToast.makeToast("Could not delete task",this.completedTasksMain);
        }
    }
}