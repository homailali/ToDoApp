package life.homail.todoapp.RemainingTasks;
import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import life.homail.todoapp.SingleTon.TasksDataHolder;
public class RTUserInfoSettings {
    private RemainingTasksMain remainingTasksMain;
    private AnimatorHandlerInner animatorHandlerInner=new AnimatorHandlerInner(this);
    public RTUserInfoSettings(RemainingTasksMain remainingTasksMain) {
        this.remainingTasksMain = remainingTasksMain;
    }
    protected void rtUserInfoSettingsMain(String title){
        this.remainingTasksMain.remainingTasksViews.someInfoForTheUserAtTheTop.setText(title);
        ObjectAnimator objectAnimator=ObjectAnimator.ofFloat(
                this.remainingTasksMain.remainingTasksViews.someInfoForTheUserAtTheTop,"alpha",1f,0f
        );
        objectAnimator.setDuration(2000);
        objectAnimator.start();
        objectAnimator.addListener(this.animatorHandlerInner);
    }

    private static class AnimatorHandlerInner implements Animator.AnimatorListener{
        // Fields
        private RTUserInfoSettings rtUserInfoSettings;
        // Constructor
        public AnimatorHandlerInner(RTUserInfoSettings rtUserInfoSettings){

            this.rtUserInfoSettings = rtUserInfoSettings;
        }
        // Methods
        @Override
        public void onAnimationEnd(@NonNull Animator animation) {
            this.rtUserInfoSettings.resetRemainingTasksCount();
        }
        @Override
        public void onAnimationStart(@NonNull Animator animation){}
        @Override
        public void onAnimationCancel(@NonNull Animator animation){}
        @Override
        public void onAnimationRepeat(@NonNull Animator animation){}
    }
    protected void resetRemainingTasksCount(){
        this.remainingTasksMain.remainingTasksViews.someInfoForTheUserAtTheTop.setAlpha(1f);
        if (TasksDataHolder.getInstance().getRemainingTasks().isEmpty()){
            this.remainingTasksMain.remainingTasksViews.someInfoForTheUserAtTheTop.setText("No task remaining");
        } else {
            this.remainingTasksMain.remainingTasksViews.someInfoForTheUserAtTheTop.setText(
                    TasksDataHolder.getInstance().getRemainingTasks().size()>1
                            ?TasksDataHolder.getInstance().getRemainingTasks().size()+" remaining tasks"
                            :"1 remaining task"
                    );
        }
    }
}