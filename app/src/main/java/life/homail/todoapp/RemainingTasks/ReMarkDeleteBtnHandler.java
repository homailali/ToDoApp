package life.homail.todoapp.RemainingTasks;

import life.homail.todoapp.Model.TaskModel;
import life.homail.todoapp.MyToast.MyToast;
import life.homail.todoapp.SingleTon.SingleTon;

public class ReMarkDeleteBtnHandler {
    private int position;
    private TaskModel receivedTaskModel;
    private RemainingTasksMain remainingTasksMain;
    public ReMarkDeleteBtnHandler(RemainingTasksMain remainingTasksMain) {
        this.remainingTasksMain = remainingTasksMain;
    }
    protected void reMarkDeleteBtnHandlerMain(int receivedPosition){
        if (receivedPosition<0  || receivedPosition>SingleTon.getSingleTon().getRemainingTasksArr().size()-1) return;
        this.position=receivedPosition;
        this.receivedTaskModel=SingleTon.getSingleTon().getRemainingTasksArr().get(position);
        boolean bool= SingleTon.getSingleTon().getHomePageMain().getRemainingTasksDB().deleteRemainingTaskFromDB(receivedTaskModel);
        if (bool) this.addTaskModelToDeletedTasksDB();
        else MyToast.makeToast("Error deleting task",this.remainingTasksMain);
    }
    private void addTaskModelToDeletedTasksDB(){
        boolean bool=SingleTon.getSingleTon().getHomePageMain().getDeletedTasksDB().addDeletedTaskToDB(receivedTaskModel);
        if (bool) this.ifTaskSuccessfullyTransferred();
        else {
            SingleTon.getSingleTon().getHomePageMain().getRemainingTasksDB().addRemainingTaskToDB(receivedTaskModel);
            MyToast.makeToast("Error deleting task",this.remainingTasksMain);
        }
    }
    private void ifTaskSuccessfullyTransferred(){
        MyToast.makeToast("Task deleted successfully",this.remainingTasksMain);
        SingleTon.getSingleTon().getRemainingTasksArr().remove(position);
        SingleTon.getSingleTon().getDeletedTasksArr().add(receivedTaskModel);
        this.remainingTasksMain.getRtAdapter().notifyItemRemoved(position);
        this.remainingTasksMain.setVisibilityOfNoTasksRemainingTv();
    }
}