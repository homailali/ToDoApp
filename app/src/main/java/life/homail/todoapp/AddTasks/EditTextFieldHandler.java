package life.homail.todoapp.AddTasks;
import android.text.Editable;
import android.text.TextWatcher;
public class EditTextFieldHandler implements TextWatcher{
    private AddTasksMain addTasksMain;
    protected EditTextFieldHandler(AddTasksMain addTasksMain){

        this.addTasksMain=addTasksMain;
    }
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
    public void onTextChanged(CharSequence s, int start, int before, int count) {}
    public void afterTextChanged(Editable editable) {
        if (String.valueOf(this.addTasksMain.addTaskView.textInputEditText.getText()).isEmpty()){
            this.addTasksMain.addTaskView.textInputEditText.setHint("Enter your task");
        }
    }
}