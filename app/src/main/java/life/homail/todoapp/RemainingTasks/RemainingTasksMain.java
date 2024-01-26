package life.homail.todoapp.RemainingTasks;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;

import life.homail.todoapp.R;
public class RemainingTasksMain extends AppCompatActivity {
    protected RemainingTasksViews remainingTasksViews;
    protected RTNavBtnHandler rtNavBtnHandler=new RTNavBtnHandler(this);
    protected RTAdapter rtAdapter;
    @Override
    public void onCreate(Bundle getCodeFromParent){
        super.onCreate(getCodeFromParent);
        super.setContentView(R.layout.remaining_tasksxml);
        this.doSomeThingsAfterLayoutHasBeenSetUp();
        this.manageSomeRecyclerViewThings();
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
