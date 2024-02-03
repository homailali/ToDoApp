package life.homail.todoapp.AddTasks;
import android.view.View;
import life.homail.todoapp.SingleTon.TasksDataHolder;
public class SubmitBtnHandler implements View.OnClickListener {
    // Fields
    private AddTasksMain addTasksMain;
    // Constructor
    protected SubmitBtnHandler(AddTasksMain addTasksMain) {
        this.addTasksMain = addTasksMain;
    }
    // Methods
    public void onClick(View view) {

       this.addTask();
    }
    private void addTask(){
        if (String.valueOf(this.addTasksMain.addTaskView.textInputEditText.getText()).isEmpty()) {
            this.addTasksMain.addTaskView.textInputEditText.setHint("Invalid task");
        } else {
            TasksDataHolder.getInstance().addOneRemainingTask(String.valueOf(this.addTasksMain.addTaskView.textInputEditText.getText()));
            this.addTasksMain.addTaskView.textInputEditText.setText(null);
            this.addTasksMain.addTaskView.textInputEditText.setHint("Task added successfully");
        }
    }
}
