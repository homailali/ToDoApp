package life.homail.todoapp.RemainingTasks;
import life.homail.todoapp.Model.TaskModel;
import life.homail.todoapp.MyToast.MyToast;
import life.homail.todoapp.SingleTon.SingleTon;

public class ReMarkCompleteBtnHandler {
    private RemainingTasksMain remainingTasksMain;

    public ReMarkCompleteBtnHandler(RemainingTasksMain remainingTasksMain) {
        this.remainingTasksMain = remainingTasksMain;
    }
    protected void reMarkCompleteBtnHandlerMain(TaskModel taskModel) {
        boolean bool = SingleTon.getSingleTon().getHomePageMain().getRemainingTasksDB().deleteRemainingTaskFromDB(taskModel);
        if (bool) this.addTaskModelToCompletedTasksDB(taskModel);
        else MyToast.makeToast("Error marking the task as complete", this.remainingTasksMain);
    }
    private void addTaskModelToCompletedTasksDB(TaskModel taskModel) {
        boolean bool = SingleTon.getSingleTon().getHomePageMain().getCompletedTasksDB().addCompletedTaskToDB(taskModel);
        if (bool) {
            MyToast.makeToast("Task marked as completed", this.remainingTasksMain);
            SingleTon.getSingleTon().setRemainingTasksArr(SingleTon.getSingleTon().getHomePageMain().getRemainingTasksDB().getAllRemainingTasksFromDB());
            SingleTon.getSingleTon().setCompletedTasksArr(SingleTon.getSingleTon().getHomePageMain().getCompletedTasksDB().getAllCompletedTasksFromDB());
            this.remainingTasksMain.getRtAdapter().notifyDataSetChanged();
            this.remainingTasksMain.setVisibilityOfNoTasksRemainingTv();
        } else {
            MyToast.makeToast("Error marking the task as complete", this.remainingTasksMain);
            SingleTon.getSingleTon().getHomePageMain().getRemainingTasksDB().addRemainingTaskToDB(taskModel);
        }
    }
}