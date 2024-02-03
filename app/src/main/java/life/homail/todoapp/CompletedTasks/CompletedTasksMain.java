package life.homail.todoapp.CompletedTasks;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import life.homail.todoapp.R;
public class CompletedTasksMain extends AppCompatActivity {
    protected CompletedTasksViews completedTasksViews;
    protected CTNavBtnHandler ctNavBtnHandler =new CTNavBtnHandler(this);
    protected CtAdapter ctAdapter;
    @Override
    public void onCreate(Bundle getCodeFromParent){
        super.onCreate(getCodeFromParent);
        super.setContentView(R.layout.completed_tasksxml);
        this.doSomeThingAfterLayoutHasBeenSetUp();
        this.adapterSettings();
        this.recyclerViewSettings();
    }
    private void recyclerViewSettings(){
        this.completedTasksViews.ctRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.completedTasksViews.ctRecyclerView.setAdapter(this.ctAdapter);
    }
    private void adapterSettings(){
        this.ctAdapter=new CtAdapter(this,this);
    }

    private void doSomeThingAfterLayoutHasBeenSetUp(){
        this.completedTasksViews=new CompletedTasksViews(this);
    }
}