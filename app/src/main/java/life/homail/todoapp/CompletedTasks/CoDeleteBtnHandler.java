package life.homail.todoapp.CompletedTasks;

import life.homail.todoapp.Model.TaskModel;
import life.homail.todoapp.MyToast.MyToast;
import life.homail.todoapp.SingleTon.SingleTon;

public class CoDeleteBtnHandler {
    private int position;
    private TaskModel receivedTaskModel;
    private CompletedTasksMain completedTasksMain;

    public CoDeleteBtnHandler(CompletedTasksMain completedTasksMain) {
        this.completedTasksMain = completedTasksMain;
    }
    protected void coDeleteBtnHandlerMain(int receivedPosition){
        if (receivedPosition<0  || receivedPosition>SingleTon.getSingleTon().getCompletedTasksArr().size()-1) return;
        this.position=receivedPosition;
        this.receivedTaskModel=SingleTon.getSingleTon().getCompletedTasksArr().get(position);
        boolean bool=SingleTon.getSingleTon().getHomePageMain().getCompletedTasksDB().deleteCompletedTaskFromDB(receivedTaskModel);
        if (bool) this.addTaskModelToDeleteDB();
        else MyToast.makeToast("Could  not delete task",this.completedTasksMain);
    }
    private void addTaskModelToDeleteDB(){
        boolean bool=SingleTon.getSingleTon().getHomePageMain().getDeletedTasksDB().addDeletedTaskToDB(receivedTaskModel);
        if (bool) this.ifTaskSuccessfullyMoved();
        else {
            SingleTon.getSingleTon().getHomePageMain().getCompletedTasksDB().addCompletedTaskToDB(receivedTaskModel);
            MyToast.makeToast("Could not delete task",this.completedTasksMain);
        }
    }
    private void ifTaskSuccessfullyMoved(){
        MyToast.makeToast("Task deleted successfully",this.completedTasksMain);
        SingleTon.getSingleTon().getCompletedTasksArr().remove(position);
        SingleTon.getSingleTon().getDeletedTasksArr().add(receivedTaskModel);
        this.completedTasksMain.ctAdapter.notifyItemRemoved(position);
        this.completedTasksMain.setVisibilityOfNoTasksCompletedTv();
    }
}