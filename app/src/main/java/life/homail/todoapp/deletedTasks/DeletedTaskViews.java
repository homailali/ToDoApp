package life.homail.todoapp.deletedTasks;

import android.widget.Button;

import life.homail.todoapp.R;

public class DeletedTaskViews {
    private DeletedTasksMain deletedTasksMain;
    protected Button navHomeBtn;
    protected Button navCompletedBtn;
    protected Button navRemainingTasks;

    protected DeletedTaskViews(DeletedTasksMain deletedTasksMain) {
        this.deletedTasksMain = deletedTasksMain;
        this.initializeViews();
        this.setEventListeners();
    }


    private void initializeViews(){
        this.navHomeBtn=this.deletedTasksMain.findViewById(R.id.home);
        this.navCompletedBtn=this.deletedTasksMain.findViewById(R.id.completedTasks);
        this.navRemainingTasks=this.deletedTasksMain.findViewById(R.id.remainingTasks);
    }
    private void setEventListeners(){
        this.navHomeBtn.setOnClickListener(this.deletedTasksMain.dtNavBtnHandler);
        this.navCompletedBtn.setOnClickListener(this.deletedTasksMain.dtNavBtnHandler);
        this.navRemainingTasks.setOnClickListener(this.deletedTasksMain.dtNavBtnHandler);
    }
}
