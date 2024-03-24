package life.homail.todoapp.RemainingTasks;
import life.homail.todoapp.Model.TaskModel;
import life.homail.todoapp.MyToast.MyToast;
import life.homail.todoapp.SingleTon.SingleTon;

public class ReMarkCompleteBtnHandler {
    private int position;
    private TaskModel receivedTaskModel;
    private RemainingTasksMain remainingTasksMain;

    public ReMarkCompleteBtnHandler(RemainingTasksMain remainingTasksMain) {
        this.remainingTasksMain = remainingTasksMain;
    }
    protected void reMarkCompleteBtnHandlerMain(int receivedPosition) {
        if (receivedPosition<0 || receivedPosition>SingleTon.getSingleTon().getRemainingTasksArr().size()-1) return;
        this.position=receivedPosition;
        this.receivedTaskModel=SingleTon.getSingleTon().getRemainingTasksArr().get(position);
        boolean bool = SingleTon.getSingleTon().getHomePageMain().getRemainingTasksDB().deleteRemainingTaskFromDB(receivedTaskModel);
        if (bool) this.addTaskModelToCompletedTasksDB(receivedTaskModel);
        else MyToast.makeToast("Error marking the task as complete", this.remainingTasksMain);
    }
    private void addTaskModelToCompletedTasksDB(TaskModel taskModel) {
        boolean bool = SingleTon.getSingleTon().getHomePageMain().getCompletedTasksDB().addCompletedTaskToDB(taskModel);
        if (bool) this.ifTaskSuccessfullyAddedInDB();
        else {
            MyToast.makeToast("Error marking the task as complete", this.remainingTasksMain);
            SingleTon.getSingleTon().getHomePageMain().getRemainingTasksDB().addRemainingTaskToDB(taskModel);
        }
    }
    private void ifTaskSuccessfullyAddedInDB(){
        MyToast.makeToast("Task marked as completed", this.remainingTasksMain);
        SingleTon.getSingleTon().getRemainingTasksArr().remove(position);
        SingleTon.getSingleTon().getCompletedTasksArr().add(receivedTaskModel);
        this.remainingTasksMain.getRtAdapter().notifyItemRemoved(position);
        this.remainingTasksMain.setVisibilityOfNoTasksRemainingTv();
    }
}