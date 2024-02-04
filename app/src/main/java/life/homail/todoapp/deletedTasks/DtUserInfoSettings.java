package life.homail.todoapp.deletedTasks;
import android.animation.Animator;
import android.animation.ObjectAnimator;
import androidx.annotation.NonNull;
import life.homail.todoapp.SingleTon.TasksDataHolder;
public class DtUserInfoSettings {
    // Fields
    private DeletedTasksMain deletedTasksMain;
    private AnimatorHandler animatorHandler=new AnimatorHandler(this);
    // Constructor
    public DtUserInfoSettings(DeletedTasksMain deletedTasksMain) {
        this.deletedTasksMain = deletedTasksMain;
    }
    // Methods
    protected void dtUserInfoSettingsMain(String title){
        this.deletedTasksMain.deletedTaskViews.someInfoForTheUserAtTheTop.setText(title);
        this.makeAnimation();
    }

    private void makeAnimation(){
        ObjectAnimator objectAnimator=ObjectAnimator.ofFloat(
                this.deletedTasksMain.deletedTaskViews.someInfoForTheUserAtTheTop,"alpha",1f,0f
        );
        objectAnimator.setDuration(2000);
        objectAnimator.start();
        objectAnimator.addListener(this.animatorHandler);
    }

    private static class AnimatorHandler implements Animator.AnimatorListener{
        // Fields
        private DtUserInfoSettings dtUserInfoSettings;
        // Constructor
        public AnimatorHandler(DtUserInfoSettings dtUserInfoSettings) {
            this.dtUserInfoSettings = dtUserInfoSettings;
        }
        // Methods
        @Override
        public void onAnimationEnd(@NonNull Animator animation){
            this.dtUserInfoSettings.resetNoOfDeletedTasks();
        }


        @Override
        public void onAnimationStart(@NonNull Animator animation){}
        @Override
        public void onAnimationCancel(@NonNull Animator animation){}
        @Override
        public void onAnimationRepeat(@NonNull Animator animation){}
    }
    protected void resetNoOfDeletedTasks(){
        this.deletedTasksMain.deletedTaskViews.someInfoForTheUserAtTheTop.setAlpha(1f);
        if (TasksDataHolder.getInstance().getDeletedTasks().isEmpty()){
            this.deletedTasksMain.deletedTaskViews.someInfoForTheUserAtTheTop.setText("No deleted task");
        } else {
            this.deletedTasksMain.deletedTaskViews.someInfoForTheUserAtTheTop.setText(
                    TasksDataHolder.getInstance().getDeletedTasks().size()>1
                            ?TasksDataHolder.getInstance().getDeletedTasks().size()+" deleted tasks"
                            :"1 deleted task"
            );
        }
    }
}
