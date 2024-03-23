package life.homail.todoapp.deletedTasks;
import android.widget.Button;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import life.homail.todoapp.R;
public class DeletedTaskViews {
    private DeletedTasksMain deletedTasksMain;
    protected Button navHomeBtn;
    protected RecyclerView dtRecyclerView;
    protected CardView dtCardView;
    private TextView noTasksDeletedTv;

    protected DeletedTaskViews(DeletedTasksMain deletedTasksMain) {
        this.deletedTasksMain = deletedTasksMain;
        this.initializeViews();
        this.setEventListeners();
    }
    private void initializeViews(){
        this.navHomeBtn=this.deletedTasksMain.findViewById(R.id.home);
        this.dtRecyclerView=this.deletedTasksMain.findViewById(R.id.dtRecyclerView);
        this.dtCardView=this.deletedTasksMain.findViewById(R.id.dtCardView);
        this.noTasksDeletedTv=this.deletedTasksMain.findViewById(R.id.noTasksDeletedTv);
    }
    private void setEventListeners(){
        this.navHomeBtn.setOnClickListener(this.deletedTasksMain.dtNavBtnHandler);

    }

    public TextView getNoTasksDeletedTv() {
        return noTasksDeletedTv;
    }

    public void setNoTasksDeletedTv(TextView noTasksDeletedTv) {
        this.noTasksDeletedTv = noTasksDeletedTv;
    }
}
