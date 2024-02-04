package life.homail.todoapp.RemainingTasks;
import android.widget.Button;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import life.homail.todoapp.R;
public class RemainingTasksViews {
    // Fields
    private RemainingTasksMain remainingTasksMain;
    protected Button navHomeBtn;
    protected CardView rtCardView;
    protected RecyclerView rtRecyclerView;
    protected TextView someInfoForTheUserAtTheTop;
    // Constructor
    public RemainingTasksViews(RemainingTasksMain remainingTasksMain) {
        this.remainingTasksMain = remainingTasksMain;
        this.initializeNavViews();
        this.initializeContainers();
        this.setEventHandler();
    }
    // Methods
    private void initializeNavViews(){
        this.navHomeBtn=this.remainingTasksMain.findViewById(R.id.homeBtn);
        this.someInfoForTheUserAtTheTop=this.remainingTasksMain.findViewById(R.id.someInfoForTheUserAtTheTop);
    }
    private void initializeContainers(){
        this.rtCardView=this.remainingTasksMain.findViewById(R.id.dtCardView);
        this.rtRecyclerView=this.remainingTasksMain.findViewById(R.id.dtRecyclerView);
    }
    private void setEventHandler(){
        this.navHomeBtn.setOnClickListener(this.remainingTasksMain.rtNavBtnHandler);
    }
}