package life.homail.todoapp.deletedTasks;
import android.animation.ObjectAnimator;

public class DtUserInfoSettings{
    // Fields
    private DeletedTasksMain deletedTasksMain;
    // Constructor
    public DtUserInfoSettings(DeletedTasksMain deletedTasksMain){
        this.deletedTasksMain = deletedTasksMain;
    }
    // Methods
    protected void dtUserInfoSettingsMain(String title){
        this.deletedTasksMain.deletedTaskViews.someInfoForTheUserAtTheTop.setAlpha(1f);
        this.deletedTasksMain.deletedTaskViews.someInfoForTheUserAtTheTop.setText(title);
        this.makeAnimation();
    }
    private void makeAnimation(){
        ObjectAnimator objectAnimator=ObjectAnimator.ofFloat(this.deletedTasksMain.deletedTaskViews.someInfoForTheUserAtTheTop,"alpha",1f,0f);
        objectAnimator.setDuration(3000);
        objectAnimator.start();
    }
}