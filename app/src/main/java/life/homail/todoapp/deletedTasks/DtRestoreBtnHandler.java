package life.homail.todoapp.deletedTasks;

import life.homail.todoapp.Model.TaskModel;
import life.homail.todoapp.MyToast.MyToast;
import life.homail.todoapp.SingleTon.SingleTon;

public class DtRestoreBtnHandler {
    private int position;
    private TaskModel receivedTaskModel;
    private DeletedTasksMain deletedTasksMain;

    public DtRestoreBtnHandler(DeletedTasksMain deletedTasksMain) {
        this.deletedTasksMain = deletedTasksMain;
    }
    protected void DtRestoreBtnHandlerMain(int receivedPosition){
        if (receivedPosition<0  || receivedPosition>SingleTon.getSingleTon().getDeletedTasksArr().size()-1) return;
        this.position=receivedPosition;
        this.receivedTaskModel=SingleTon.getSingleTon().getDeletedTasksArr().get(position);
        boolean bool= SingleTon.getSingleTon().getHomePageMain().getDeletedTasksDB().deleteDeletedTaskFromDB(receivedTaskModel);
        if (bool) this.addTaskModelToRemainingTasksDB();
        else MyToast.makeToast("Error restoring the task",this.deletedTasksMain);
    }
    private void addTaskModelToRemainingTasksDB(){
        boolean bool=SingleTon.getSingleTon().getHomePageMain().getRemainingTasksDB().addRemainingTaskToDB(receivedTaskModel);
        if (bool) this.ifTaskSuccessfullyMoved();
        else {
            SingleTon.getSingleTon().getHomePageMain().getDeletedTasksDB().addDeletedTaskToDB(receivedTaskModel);
            MyToast.makeToast("Error restoring the task",this.deletedTasksMain);
        }
    }
    private void ifTaskSuccessfullyMoved(){
        MyToast.makeToast("Task restored successfully",this.deletedTasksMain);
        SingleTon.getSingleTon().getDeletedTasksArr().remove(position);
        SingleTon.getSingleTon().getRemainingTasksArr().add(receivedTaskModel);
        this.deletedTasksMain.getDtAdapter().notifyItemRemoved(position);
        this.deletedTasksMain.setVisibilityOfNoTasksDeletedTv();
    }
}