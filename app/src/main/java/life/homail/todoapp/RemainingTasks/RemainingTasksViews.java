package life.homail.todoapp.RemainingTasks;
import android.widget.Button;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import life.homail.todoapp.R;
public class RemainingTasksViews {
    // Fields
    private RemainingTasksMain remainingTasksMain;
    protected Button navHomeBtn;
    protected Button navDeletedTasksBtn;
    protected Button navCompletedTasksBtn;
    protected CardView rtCardView;
    protected RecyclerView rtRecyclerView;
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
        this.navDeletedTasksBtn=this.remainingTasksMain.findViewById(R.id.deletedTasks);
        this.navCompletedTasksBtn=this.remainingTasksMain.findViewById(R.id.completedTasks);


    }
    private void initializeContainers(){
        this.rtCardView=this.remainingTasksMain.findViewById(R.id.dtCardView);
        this.rtRecyclerView=this.remainingTasksMain.findViewById(R.id.dtRecyclerView);
    }
    private void setEventHandler(){
        this.navHomeBtn.setOnClickListener(this.remainingTasksMain.rtNavBtnHandler);
        this.navDeletedTasksBtn.setOnClickListener(this.remainingTasksMain.rtNavBtnHandler);
        this.navCompletedTasksBtn.setOnClickListener(this.remainingTasksMain.rtNavBtnHandler);
    }
}