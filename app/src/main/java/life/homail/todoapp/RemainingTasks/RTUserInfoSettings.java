package life.homail.todoapp.RemainingTasks;
import android.animation.ObjectAnimator;
public class RTUserInfoSettings {
    // Fields
    private RemainingTasksMain remainingTasksMain;
    // Constructor
    public RTUserInfoSettings(RemainingTasksMain remainingTasksMain){
        this.remainingTasksMain = remainingTasksMain;
    }
    // Methods
    protected void rtUserInfoSettingsMain(String title){
        this.remainingTasksMain.remainingTasksViews.someInfoForTheUserAtTheTop.setAlpha(1f);
        this.remainingTasksMain.remainingTasksViews.someInfoForTheUserAtTheTop.setText(title);
        this.makeAnimation();
    }
    private void makeAnimation(){
        ObjectAnimator objectAnimator=ObjectAnimator.ofFloat(this.remainingTasksMain.remainingTasksViews.someInfoForTheUserAtTheTop,"alpha",1f,0f);
        objectAnimator.setDuration(3000);
        objectAnimator.start();
    }

}