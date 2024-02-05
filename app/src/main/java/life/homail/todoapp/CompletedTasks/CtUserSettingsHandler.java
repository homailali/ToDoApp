package life.homail.todoapp.CompletedTasks;
import android.os.Handler;
import life.homail.todoapp.SingleTon.TasksDataHolder;
public class CtUserSettingsHandler {
    // Fields
    private CompletedTasksMain completedTasksMain;
    private Handler handler=new Handler();
    private int handlerPostDelayedTime;
    // Constructor
    public CtUserSettingsHandler(CompletedTasksMain completedTasksMain) {
        this.completedTasksMain = completedTasksMain;
    }
    protected void ctUserSettingsMain(String title){
        this.handlerPostDelayedTime+=2000;
        this.completedTasksMain.completedTasksViews.someInfoForTheUserAtTheTop.setText(title);
        handler.postDelayed(()->this.resetCompletedCountOnTextView(),this.handlerPostDelayedTime);
    }
    protected void resetCompletedCountOnTextView(){
        this.completedTasksMain.completedTasksViews.someInfoForTheUserAtTheTop.setAlpha(1f);
        if (TasksDataHolder.getInstance().getCompletedTasks().isEmpty()){
            this.completedTasksMain.completedTasksViews.someInfoForTheUserAtTheTop.setText("No task completed");
        } else {
            this.completedTasksMain.completedTasksViews.someInfoForTheUserAtTheTop.setText(
                    TasksDataHolder.getInstance().getCompletedTasks().size()>1
                    ?TasksDataHolder.getInstance().getCompletedTasks().size()+" completed tasks"
                    :"1 completed task"
            );
        }
        this.handlerPostDelayedTime=0;
    }
}