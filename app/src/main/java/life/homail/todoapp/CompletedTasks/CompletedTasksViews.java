package life.homail.todoapp.CompletedTasks;


import android.widget.Button;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import life.homail.todoapp.R;

public class CompletedTasksViews {
    private CompletedTasksMain completedTasksMain;
    protected Button navHomeBtn;
    protected CardView ctCardView;
    protected RecyclerView ctRecyclerView;
    protected TextView someInfoForTheUserAtTheTop;


    protected CompletedTasksViews (CompletedTasksMain completedTasksMain){
        this.completedTasksMain=completedTasksMain;
        this.initializeViews();
        this.initializeSomeContainers();
        this.setEventHandler();
    }


    private void initializeViews(){
       this.navHomeBtn=this.completedTasksMain.findViewById(R.id.homeBtn);
       this.someInfoForTheUserAtTheTop=this.completedTasksMain.findViewById(R.id.someInfoForTheUserAtTheTop);
    }

    private void initializeSomeContainers(){
        this.ctCardView=this.completedTasksMain.findViewById(R.id.dtCardView);
        this.ctRecyclerView=this.completedTasksMain.findViewById(R.id.dtRecyclerView);
    }

    private void setEventHandler(){
        this.navHomeBtn.setOnClickListener(this.completedTasksMain.ctNavBtnHandler);
    }
}
