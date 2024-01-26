package life.homail.todoapp.AddTasks;
import android.widget.Button;
import life.homail.todoapp.R;
import com.google.android.material.textfield.TextInputEditText;
public class AddTaskView {
    private AddTasksMain addTasksMain;
    protected Button submitBtn;
    protected Button navHomeBtn;
    protected TextInputEditText textInputEditText;
    protected AddTaskView(AddTasksMain addTasksMain){
        this.addTasksMain=addTasksMain;
        this.initializeViews();
        this.setEventHandlersForButtons();
        this.setEditTextHintText();
    }
    private void initializeViews(){
        this.submitBtn=this.addTasksMain.findViewById(R.id.submitTask);
        this.navHomeBtn=this.addTasksMain.findViewById(R.id.homePage);
        this.textInputEditText=this.addTasksMain.findViewById(R.id.editText);
    }
    private void setEventHandlersForButtons(){
        this.submitBtn.setOnClickListener(this.addTasksMain.submitBtnHandler);
        this.navHomeBtn.setOnClickListener(e->this.addTasksMain.changeViewToHome());
        this.textInputEditText.addTextChangedListener(this.addTasksMain.editTextFieldHandler);
    }
    private void setEditTextHintText(){

        this.textInputEditText.setHint("Enter your task");
    }
}
