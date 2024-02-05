package life.homail.todoapp.AddTasks;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;

import life.homail.todoapp.ClassesInstances.HomePageMainInstance;
import life.homail.todoapp.SPKeys.SPCodeAndKeys;
import life.homail.todoapp.SingleTon.TasksDataHolderAndOtherStaticMethods;
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
            TasksDataHolderAndOtherStaticMethods.getInstance().addOneRemainingTask(String.valueOf(this.addTasksMain.addTaskView.textInputEditText.getText()));
            this.addTasksMain.addTaskView.textInputEditText.setHint("Task added successfully");
            this.addDataToRemainingSharedPreference(String.valueOf(
                    this.addTasksMain.addTaskView.textInputEditText.getText()
            ));
            this.addTasksMain.addTaskView.textInputEditText.setText(null);
        }
    }
    private void addDataToRemainingSharedPreference(String dataToAdd){
        SharedPreferences sharedPreferences= HomePageMainInstance.homePageMain.getSharedPreferences(SPCodeAndKeys.RE_DATA_SP_CODE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString(String.valueOf(SPCodeAndKeys.reDataCountKey),dataToAdd);
        SPCodeAndKeys.reDataCountKey++;
        editor.apply();
        this.storeReDataCountKeyInSp();
    }
    private void storeReDataCountKeyInSp(){
        SharedPreferences sharedPreferences= HomePageMainInstance.homePageMain.getSharedPreferences(SPCodeAndKeys.RE_COUNT_SP_CODE,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putInt(SPCodeAndKeys.keyToStoreReDataCountKey,SPCodeAndKeys.reDataCountKey);
        editor.apply();
    }
}
