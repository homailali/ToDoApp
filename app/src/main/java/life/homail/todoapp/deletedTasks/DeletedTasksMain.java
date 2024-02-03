package life.homail.todoapp.deletedTasks;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import life.homail.todoapp.R;
public class DeletedTasksMain extends AppCompatActivity {
    protected DeletedTaskViews deletedTaskViews;
    protected DTNavBtnHandler dtNavBtnHandler=new DTNavBtnHandler(this);
    protected DtAdapter dtAdapter;
    @Override
    public void onCreate(Bundle getCodeFromParent){
        super.onCreate(getCodeFromParent);
        super.setContentView(R.layout.deleted_tasksxml);
        this.doSomeThingsAfterLayoutHasBeenSetUp();
        this.dtAdapterSettings();
        this.dtRecyclerViewSettings();
    }


    private void dtRecyclerViewSettings(){
        this.deletedTaskViews.dtRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.deletedTaskViews.dtRecyclerView.setAdapter(this.dtAdapter);
    }
    private void dtAdapterSettings(){
        this.dtAdapter=new DtAdapter(this,this);
    }

    private void doSomeThingsAfterLayoutHasBeenSetUp(){

        this.deletedTaskViews=new DeletedTaskViews(this);
    }
}
