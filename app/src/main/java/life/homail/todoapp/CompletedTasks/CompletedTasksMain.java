package life.homail.todoapp.CompletedTasks;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import life.homail.todoapp.R;
import life.homail.todoapp.SingleTon.SingleTon;

public class CompletedTasksMain extends AppCompatActivity {
    protected CtAdapter ctAdapter;
    protected CompletedTasksViews completedTasksViews;
    protected CTNavBtnHandler ctNavBtnHandler =new CTNavBtnHandler(this);
    protected CoDeleteBtnHandler coDeleteBtnHandler=new CoDeleteBtnHandler(this);
    protected CoRestoreBtnHandler coRestoreBtnHandler=new CoRestoreBtnHandler(this);
    @Override
    public void onCreate(Bundle getCodeFromParent){
        super.onCreate(getCodeFromParent);
        super.setContentView(R.layout.completed_tasksxml);
        this.doSomeThingAfterLayoutHasBeenSetUp();
        this.adapterSettings();
        this.recyclerViewSettings();
        this.setVisibilityOfNoTasksCompletedTv();
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
    protected void setVisibilityOfNoTasksCompletedTv(){
        boolean bool= SingleTon.getSingleTon().getCompletedTasksArr().size()==0;
        this.completedTasksViews.getNoTasksCompletedTv().setVisibility(bool? View.VISIBLE:View.INVISIBLE);
    }
}