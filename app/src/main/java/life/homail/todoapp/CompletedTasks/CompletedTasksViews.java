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
    private TextView noTasksCompletedTv;

    protected CompletedTasksViews (CompletedTasksMain completedTasksMain){
        this.completedTasksMain=completedTasksMain;
        this.initializeViews();
        this.initializeSomeContainers();
        this.setEventHandler();
    }


    private void initializeViews(){
        this.navHomeBtn=this.completedTasksMain.findViewById(R.id.homeBtn);
        this.noTasksCompletedTv=this.completedTasksMain.findViewById(R.id.noTasksCompletedTv);
    }

    private void initializeSomeContainers(){
        this.ctCardView=this.completedTasksMain.findViewById(R.id.dtCardView);
        this.ctRecyclerView=this.completedTasksMain.findViewById(R.id.dtRecyclerView);
    }

    private void setEventHandler(){
        this.navHomeBtn.setOnClickListener(this.completedTasksMain.ctNavBtnHandler);
    }

    public TextView getNoTasksCompletedTv() {
        return noTasksCompletedTv;
    }

    public void setNoTasksCompletedTv(TextView noTasksCompletedTv) {
        this.noTasksCompletedTv = noTasksCompletedTv;
    }
}
