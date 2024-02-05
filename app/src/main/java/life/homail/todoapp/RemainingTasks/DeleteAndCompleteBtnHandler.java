package life.homail.todoapp.RemainingTasks;
import android.content.Context;
import android.content.SharedPreferences;
import life.homail.todoapp.ClassesInstances.HomePageMainInstance;
import life.homail.todoapp.SPKeys.SPCodeAndKeys;
import life.homail.todoapp.SingleTon.TasksDataHolderAndOtherStaticMethods;
public class DeleteAndCompleteBtnHandler {
    // Fields
    private RemainingTasksMain remainingTasksMain;
    // Constructor
    public DeleteAndCompleteBtnHandler(RemainingTasksMain remainingTasksMain) {

        this.remainingTasksMain = remainingTasksMain;
    }
    // Methods
    protected void deleteAt(int position){
        TasksDataHolderAndOtherStaticMethods.getInstance().addDeletedTask(TasksDataHolderAndOtherStaticMethods.getInstance().getRemainingTaskAt(position));
        TasksDataHolderAndOtherStaticMethods.getInstance().deleteRemainingTaskAt(position);
        this.remainingTasksMain.rtAdapter.notifyDataSetChanged();
        this.remainingTasksMain.rtUserInfoSettings.rtUserInfoSettingsMain("Task marked as deleted");
        this.removeTasksFormReSharedPreference();
        this.removeTasksFormDeSharedPreference();
    }
    protected void markCompleteAt(int position){
        TasksDataHolderAndOtherStaticMethods.getInstance().addCompletedTask(TasksDataHolderAndOtherStaticMethods.getInstance().getRemainingTaskAt(position));
        TasksDataHolderAndOtherStaticMethods.getInstance().deleteRemainingTaskAt(position);
        this.remainingTasksMain.rtAdapter.notifyDataSetChanged();
        this.remainingTasksMain.rtUserInfoSettings.rtUserInfoSettingsMain("Task marked as completed");
        this.removeTasksFormReSharedPreference();
        this.removeTasksFormCoSharedPreference();
    }
    // Co sp settings
    private void removeTasksFormCoSharedPreference(){
        SharedPreferences sharedPreferences= HomePageMainInstance.homePageMain.getSharedPreferences(SPCodeAndKeys.CO_DATA_SP_CODE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.clear();
        editor.apply();
        this.againEnterDataToCoSharedPreference(editor);
        editor.apply();
    }
    private void againEnterDataToCoSharedPreference(SharedPreferences.Editor editor){
        for (int i = 0; i< TasksDataHolderAndOtherStaticMethods.getInstance().getCompletedTasks().size(); i++){
            editor.putString(String.valueOf(i), TasksDataHolderAndOtherStaticMethods.getInstance().getCompletedTaskAt(i));
        }
        SPCodeAndKeys.coDataCountKey= TasksDataHolderAndOtherStaticMethods.getInstance().getCompletedTasks().size();
    }

    // De Sp settings
    private void removeTasksFormDeSharedPreference(){
        SharedPreferences sharedPreferences= HomePageMainInstance.homePageMain.getSharedPreferences(SPCodeAndKeys.DE_DATA_SP_CODE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= sharedPreferences.edit();
        editor.clear();
        editor.apply();
        this.againEnterDataToDeSharedPref(editor);
        editor.apply();
    }
    private void againEnterDataToDeSharedPref(SharedPreferences.Editor editor){
        for (int i = 0; i< TasksDataHolderAndOtherStaticMethods.getInstance().getDeletedTasks().size(); i++){
            editor.putString(String.valueOf(i), TasksDataHolderAndOtherStaticMethods.getInstance().getDeletedTaskAt(i));
        }
        SPCodeAndKeys.deDataCountKey= TasksDataHolderAndOtherStaticMethods.getInstance().getDeletedTasks().size();
    }
    // Re Sp Settings
    private void removeTasksFormReSharedPreference(){
        SharedPreferences sharedPreferences= HomePageMainInstance.homePageMain.getSharedPreferences(SPCodeAndKeys.RE_DATA_SP_CODE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.clear();
        editor.apply();
        this.againEnterDataToReSharedPref(editor);
        editor.apply();
    }
    private void againEnterDataToReSharedPref(SharedPreferences.Editor editor){
        for (int i = 0; i< TasksDataHolderAndOtherStaticMethods.getInstance().getRemainingTasks().size(); i++){
            editor.putString(String.valueOf(i), TasksDataHolderAndOtherStaticMethods.getInstance().getRemainingTaskAt(i));
        }
        SPCodeAndKeys.reDataCountKey= TasksDataHolderAndOtherStaticMethods.getInstance().getRemainingTasks().size();
    }
}