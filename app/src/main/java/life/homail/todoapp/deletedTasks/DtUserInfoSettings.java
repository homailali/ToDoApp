package life.homail.todoapp.deletedTasks;
import android.os.Handler;
import life.homail.todoapp.SingleTon.TasksDataHolder;
public class DtUserInfoSettings{
    // Fields
    private DeletedTasksMain deletedTasksMain;
    private Handler handler=new Handler();
    private int handlerPostDelayTime;
    // Constructor
    public DtUserInfoSettings(DeletedTasksMain deletedTasksMain){
        this.deletedTasksMain = deletedTasksMain;
    }
    // Methods
    protected void dtUserInfoSettingsMain(String title){
        this.handlerPostDelayTime+=2000;
        this.deletedTasksMain.deletedTaskViews.someInfoForTheUserAtTheTop.setText(title);
        this.handler.postDelayed(this::resetNoOfDeletedTasks,handlerPostDelayTime);
    }
    protected void resetNoOfDeletedTasks(){
        if (TasksDataHolder.getInstance().getDeletedTasks().isEmpty()){
            this.deletedTasksMain.deletedTaskViews.someInfoForTheUserAtTheTop.setText("No task deleted");
        } else {
            this.deletedTasksMain.deletedTaskViews.someInfoForTheUserAtTheTop.setText(
                    TasksDataHolder.getInstance().getDeletedTasks().size()>1
                            ?TasksDataHolder.getInstance().getDeletedTasks().size()+" deleted tasks"
                            :"1 deleted task"
            );
        }
        handlerPostDelayTime=0;
    }
}