package life.homail.todoapp.AddTasks;
import android.widget.Button;
import android.widget.EditText;

import life.homail.todoapp.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
public class AddTaskView {
    private AddTasksMain addTasksMain;
    protected Button submitBtn;
    protected Button navHomeBtn;
    protected EditText editText;
    protected AddTaskView(AddTasksMain addTasksMain){
        this.addTasksMain=addTasksMain;
        this.initializeViews();
        this.setEventHandlersForButtons();
    }
    private void initializeViews(){
        this.submitBtn=this.addTasksMain.findViewById(R.id.submitTask);
        this.navHomeBtn=this.addTasksMain.findViewById(R.id.homePage);
        this.editText=this.addTasksMain.findViewById(R.id.editText);
    }
    private void setEventHandlersForButtons(){
        this.submitBtn.setOnClickListener(this.addTasksMain.submitBtnHandler);
        this.navHomeBtn.setOnClickListener(e->this.addTasksMain.changeViewToHome());
    }

}