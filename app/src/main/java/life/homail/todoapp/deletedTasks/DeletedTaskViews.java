package life.homail.todoapp.deletedTasks;

import android.widget.Button;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import life.homail.todoapp.R;

public class DeletedTaskViews {
    private DeletedTasksMain deletedTasksMain;
    protected Button navHomeBtn;
    protected Button navCompletedBtn;
    protected Button navRemainingTasks;
    protected RecyclerView dtRecyclerView;
    protected CardView dtCardView;

    protected DeletedTaskViews(DeletedTasksMain deletedTasksMain) {
        this.deletedTasksMain = deletedTasksMain;
        this.initializeViews();
        this.setEventListeners();
    }


    private void initializeViews(){
        this.navHomeBtn=this.deletedTasksMain.findViewById(R.id.home);
        this.navCompletedBtn=this.deletedTasksMain.findViewById(R.id.completedTasks);
        this.navRemainingTasks=this.deletedTasksMain.findViewById(R.id.remainingTasks);

        this.dtRecyclerView=this.deletedTasksMain.findViewById(R.id.dtRecyclerView);
        this.dtCardView=this.deletedTasksMain.findViewById(R.id.dtCardView);
    }
    private void setEventListeners(){
        this.navHomeBtn.setOnClickListener(this.deletedTasksMain.dtNavBtnHandler);
        this.navCompletedBtn.setOnClickListener(this.deletedTasksMain.dtNavBtnHandler);
        this.navRemainingTasks.setOnClickListener(this.deletedTasksMain.dtNavBtnHandler);
    }
}
