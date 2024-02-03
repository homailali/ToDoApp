package life.homail.todoapp.AddTasks;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import life.homail.todoapp.HomePage.HomePageMain;
import life.homail.todoapp.R;
public class AddTasksMain extends AppCompatActivity{
    protected AddTaskView addTaskView;
    protected SubmitBtnHandler submitBtnHandler=new SubmitBtnHandler(this);
    protected EditTextFieldHandler editTextFieldHandler=new EditTextFieldHandler(this);
    @Override
    public void onCreate(Bundle getCodeFromParent){
        super.onCreate(getCodeFromParent);
        super.setContentView(R.layout.add_task_xml);
        this.doSomeThingWhenLayoutIsSetUp();
    }
    private void doSomeThingWhenLayoutIsSetUp(){
        this.addTaskView=new AddTaskView(this);

    }
    // nav btn handler
    protected void changeViewToHome(){
        super.finish();
    }
}