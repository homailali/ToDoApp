package life.homail.todoapp.deletedTasks;

import life.homail.todoapp.Model.TaskModel;
import life.homail.todoapp.MyToast.MyToast;
import life.homail.todoapp.SingleTon.SingleTon;

public class DTDeleteBtnHandler {
    private int position;
    private TaskModel receivedTaskModel;
    private DeletedTasksMain deletedTasksMain;
    public DTDeleteBtnHandler(DeletedTasksMain deletedTasksMain) {
        this.deletedTasksMain = deletedTasksMain;
    }
    protected void dtDeleteBtnHandlerMain(int receivedPosition){
        if (receivedPosition<0  || receivedPosition>SingleTon.getSingleTon().getDeletedTasksArr().size()-1) return;
        this.position=receivedPosition;
        this.receivedTaskModel=SingleTon.getSingleTon().getDeletedTasksArr().get(position);
        boolean bool= SingleTon.getSingleTon().getHomePageMain().getDeletedTasksDB().deleteDeletedTaskFromDB(receivedTaskModel);
        if (bool) this.onTaskSuccessfullyDeletedFromDB();
        else MyToast.makeToast("Could not delete task",this.deletedTasksMain);
    }

    private void onTaskSuccessfullyDeletedFromDB(){
        MyToast.makeToast("Task deleted successfully",this.deletedTasksMain);
        SingleTon.getSingleTon().getDeletedTasksArr().remove(position);
        this.deletedTasksMain.getDtAdapter().notifyItemRemoved(position);
        this.deletedTasksMain.setVisibilityOfNoTasksDeletedTv();
    }
}
