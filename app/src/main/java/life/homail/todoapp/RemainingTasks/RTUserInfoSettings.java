package life.homail.todoapp.RemainingTasks;
import android.os.Handler;
import life.homail.todoapp.SingleTon.TasksDataHolder;
public class RTUserInfoSettings {
    // Fields
    private RemainingTasksMain remainingTasksMain;
    private Handler handler=new Handler();
    private int handlerPostDelayedTime;
    // Constructor
    public RTUserInfoSettings(RemainingTasksMain remainingTasksMain){
        this.remainingTasksMain = remainingTasksMain;
    }
    // Methods
    protected void rtUserInfoSettingsMain(String title){
        this.handlerPostDelayedTime+=2000;
        this.remainingTasksMain.remainingTasksViews.someInfoForTheUserAtTheTop.setText(title);
        handler.postDelayed(()->this.resetRemainingTasksCount(),this.handlerPostDelayedTime);
    }
    protected void resetRemainingTasksCount(){
        if (TasksDataHolder.getInstance().getRemainingTasks().isEmpty()){
            this.remainingTasksMain.remainingTasksViews.someInfoForTheUserAtTheTop.setText("No task remaining");
        } else {
            this.remainingTasksMain.remainingTasksViews.someInfoForTheUserAtTheTop.setText(
                    TasksDataHolder.getInstance().getRemainingTasks().size()>1
                            ?TasksDataHolder.getInstance().getRemainingTasks().size()+" remaining tasks"
                            :"1 remaining task"
            );
        }
        this.handlerPostDelayedTime=0;
    }
}