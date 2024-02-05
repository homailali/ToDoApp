package life.homail.todoapp.CompletedTasks;
import android.animation.ObjectAnimator;

public class CtUserSettingsHandler {
    // Fields
    private CompletedTasksMain completedTasksMain;
    // Constructor
    public CtUserSettingsHandler(CompletedTasksMain completedTasksMain) {
        this.completedTasksMain = completedTasksMain;
    }
    protected void ctUserSettingsMain(String title){
        this.completedTasksMain.completedTasksViews.someInfoForTheUserAtTheTop.setAlpha(1f);
        this.completedTasksMain.completedTasksViews.someInfoForTheUserAtTheTop.setText(title);
        this.makeAnimation();
    }
    private void makeAnimation(){
        ObjectAnimator objectAnimator=ObjectAnimator.ofFloat(this.completedTasksMain.completedTasksViews.someInfoForTheUserAtTheTop,"alpha",1f,0f);
        objectAnimator.setDuration(3000);
        objectAnimator.start();
    }
}