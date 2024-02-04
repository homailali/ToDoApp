package life.homail.todoapp.CompletedTasks;

import android.animation.Animator;
import android.animation.ObjectAnimator;

import androidx.annotation.NonNull;

import life.homail.todoapp.SingleTon.TasksDataHolder;

public class CtUserSettingsHandler {
    // Fields
    private CompletedTasksMain completedTasksMain;
    private CtAnimatorHandler ctAnimatorHandle=new CtAnimatorHandler(this);
    // Constructor
    public CtUserSettingsHandler(CompletedTasksMain completedTasksMain) {
        this.completedTasksMain = completedTasksMain;
    }

    protected void ctUserSettingsMain(String title){
        this.completedTasksMain.completedTasksViews.someInfoForTheUserAtTheTop.setText(title);
        this.makeAnimation();
    }

    private void makeAnimation(){
        ObjectAnimator objectAnimator=ObjectAnimator.ofFloat(
                this.completedTasksMain.completedTasksViews.someInfoForTheUserAtTheTop,"ALPHA",1f,0f
        );
        objectAnimator.setDuration(2000);
        objectAnimator.start();
        objectAnimator.addListener(this.ctAnimatorHandle);
    }




    private static class CtAnimatorHandler implements Animator.AnimatorListener{
        // Fields
        private CtUserSettingsHandler ctUserSettingsHandler;
        // Constructor
        public CtAnimatorHandler(CtUserSettingsHandler ctUserSettingsHandler) {
            this.ctUserSettingsHandler = ctUserSettingsHandler;
        }
        // Methods
        @Override
        public void onAnimationEnd(@NonNull Animator animation){
            this.ctUserSettingsHandler.resetCompletedCountOnTextView();
        }
        @Override
        public void onAnimationStart(@NonNull Animator animation){}
        @Override
        public void onAnimationCancel(@NonNull Animator animation){}
        @Override
        public void onAnimationRepeat(@NonNull Animator animation){}
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
    }
}
