package life.homail.todoapp.deletedTasks;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import life.homail.todoapp.R;
public class DeletedTasksMain extends AppCompatActivity {
    protected DeletedTaskViews deletedTaskViews;
    protected DTNavBtnHandler dtNavBtnHandler=new DTNavBtnHandler(this);
    @Override
    public void onCreate(Bundle getCodeFromParent){
        super.onCreate(getCodeFromParent);
        super.setContentView(R.layout.deleted_tasksxml);
        this.doSomeThingsAfterLayoutHasBeenSetUp();
    }
    private void doSomeThingsAfterLayoutHasBeenSetUp(){

        this.deletedTaskViews=new DeletedTaskViews(this);
    }
}
