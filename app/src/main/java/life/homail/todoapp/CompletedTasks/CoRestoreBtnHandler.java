package life.homail.todoapp.CompletedTasks;

import life.homail.todoapp.Model.TaskModel;
import life.homail.todoapp.MyToast.MyToast;
import life.homail.todoapp.SingleTon.SingleTon;

public class CoRestoreBtnHandler {
    private int position;
    private TaskModel receivedTaskModel;
    private CompletedTasksMain completedTasksMain;

    public CoRestoreBtnHandler(CompletedTasksMain completedTasksMain) {
        this.completedTasksMain = completedTasksMain;
    }
    protected void coRestoreBtnHandlerMain(int receivedPosition){
        if (receivedPosition<0  || receivedPosition>SingleTon.getSingleTon().getCompletedTasksArr().size()-1) return;
        this.position=receivedPosition;
        this.receivedTaskModel=SingleTon.getSingleTon().getCompletedTasksArr().get(position);
        boolean bool= SingleTon.getSingleTon().getHomePageMain().getCompletedTasksDB().deleteCompletedTaskFromDB(receivedTaskModel);
        if (bool) this.addTaskToRemainingDB();
        else MyToast.makeToast("Error restoring task",this.completedTasksMain);
    }
    private void addTaskToRemainingDB(){
        boolean bool=SingleTon.getSingleTon().getHomePageMain().getRemainingTasksDB().addRemainingTaskToDB(receivedTaskModel);
        if (bool) this.ifTaskSuccessfullyAdded();
        else {
            SingleTon.getSingleTon().getHomePageMain().getCompletedTasksDB().addCompletedTaskToDB(receivedTaskModel);
            MyToast.makeToast("Error restoring task",this.completedTasksMain);
        }
    }
    private void ifTaskSuccessfullyAdded(){
        MyToast.makeToast("Task restored successfully",this.completedTasksMain);
        SingleTon.getSingleTon().getCompletedTasksArr().remove(position);
        SingleTon.getSingleTon().getRemainingTasksArr().add(receivedTaskModel);
        this.completedTasksMain.ctAdapter.notifyItemRemoved(position);
        this.completedTasksMain.setVisibilityOfNoTasksCompletedTv();
    }
}
