package life.homail.todoapp.RemainingTasks;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;

import life.homail.todoapp.R;
import life.homail.todoapp.SingleTon.TasksDataHolder;

public class RemainingTasksMain extends AppCompatActivity {
    protected RTAdapter rtAdapter;
    protected RemainingTasksViews remainingTasksViews;
    protected RTNavBtnHandler rtNavBtnHandler=new RTNavBtnHandler(this);
    protected RTUserInfoSettings rtUserInfoSettings=new RTUserInfoSettings(this);
    @Override
    public void onCreate(Bundle getCodeFromParent){
        super.onCreate(getCodeFromParent);
        super.setContentView(R.layout.remaining_tasksxml);
        this.doSomeThingsAfterLayoutHasBeenSetUp();
        this.manageSomeRecyclerViewThings();
        this.rtUserInfoSettings.resetRemainingTasksCount();
    }

    private void manageSomeRecyclerViewThings(){
        this.rtAdapter=new RTAdapter(this,this);
        this.remainingTasksViews.rtRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.remainingTasksViews.rtRecyclerView.setAdapter(this.rtAdapter);
    }
    private void doSomeThingsAfterLayoutHasBeenSetUp(){
        this.remainingTasksViews=new RemainingTasksViews(this);
    }


}
