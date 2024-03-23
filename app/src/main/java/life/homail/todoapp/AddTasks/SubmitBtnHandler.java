package life.homail.todoapp.AddTasks;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;

import life.homail.todoapp.Model.TaskModel;
import life.homail.todoapp.MyToast.MyToast;
import life.homail.todoapp.SingleTon.SingleTon;
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
        if (String.valueOf(this.addTasksMain.addTaskView.textInputEditText.getText()).isBlank()) {
            MyToast.makeToast("Invalid task",this.addTasksMain);
        } else {
            TaskModel taskModel=new TaskModel(String.valueOf(this.addTasksMain.addTaskView.textInputEditText.getText()));
            boolean bool=SingleTon.getSingleTon().getHomePageMain().getRemainingTasksDB().addRemainingTaskToDB(taskModel);
            if (bool){
                MyToast.makeToast("Task added",this.addTasksMain);
                SingleTon.getSingleTon().setRemainingTasksArr(SingleTon.getSingleTon().getHomePageMain().getRemainingTasksDB().getAllRemainingTasksFromDB());
                this.addTasksMain.addTaskView.textInputEditText.setText(null);
            } else MyToast.makeToast("Error adding the task",this.addTasksMain);
        }
    }
}
