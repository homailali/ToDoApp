package life.homail.todoapp.CompletedTasks;


import android.widget.Button;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import life.homail.todoapp.R;

public class CompletedTasksViews {
    private CompletedTasksMain completedTasksMain;
    protected Button navHomeBtn;
    protected Button navRemainingTasksBtn;
    protected Button navDeletedTasksBtn;
    protected CardView ctCardView;
    protected RecyclerView ctRecyclerView;


    protected CompletedTasksViews (CompletedTasksMain completedTasksMain){
        this.completedTasksMain=completedTasksMain;
        this.initializeViews();
        this.initializeSomeContainers();
        this.setEventHandler();
    }


    private void initializeViews(){
       this.navHomeBtn=this.completedTasksMain.findViewById(R.id.homeBtn);
       this.navDeletedTasksBtn=this.completedTasksMain.findViewById(R.id.deletedTasks);
       this.navRemainingTasksBtn=this.completedTasksMain.findViewById(R.id.remainingTasks);
    }

    private void initializeSomeContainers(){
        this.ctCardView=this.completedTasksMain.findViewById(R.id.ctCardView);
        this.ctRecyclerView=this.completedTasksMain.findViewById(R.id.ctRecyclerView);
    }

    private void setEventHandler(){
        this.navHomeBtn.setOnClickListener(this.completedTasksMain.ctNavBtnHandler);
        this.navDeletedTasksBtn.setOnClickListener(this.completedTasksMain.ctNavBtnHandler);
        this.navRemainingTasksBtn.setOnClickListener(this.completedTasksMain.ctNavBtnHandler);
    }
}
