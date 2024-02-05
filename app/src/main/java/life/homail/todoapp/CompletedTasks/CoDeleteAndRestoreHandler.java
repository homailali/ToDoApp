package life.homail.todoapp.CompletedTasks;
import android.content.Context;
import android.content.SharedPreferences;

import life.homail.todoapp.ClassesInstances.HomePageMainInstance;
import life.homail.todoapp.SPKeys.SPCodeAndKeys;
import life.homail.todoapp.SingleTon.TasksDataHolderAndOtherStaticMethods;
public class CoDeleteAndRestoreHandler {
    // Fields
    private CompletedTasksMain completedTasksMain;
    // Constructor
    public CoDeleteAndRestoreHandler(CompletedTasksMain completedTasksMain) {
        this.completedTasksMain = completedTasksMain;
    }
    // Methods
    protected void restoreBtnHandler(int position){
        TasksDataHolderAndOtherStaticMethods.getInstance().addOneRemainingTask(TasksDataHolderAndOtherStaticMethods.getInstance().getCompletedTaskAt(position));
        TasksDataHolderAndOtherStaticMethods.getInstance().getCompletedTasks().remove(position);
        this.completedTasksMain.ctAdapter.notifyDataSetChanged();
        this.completedTasksMain.ctUserSettingsHandler.ctUserSettingsMain("Task restored");
        this.removeTasksFormCoSharedPreference();
        this.addDataToRemainingSharedPreference();
    }
    protected void deleteBtnHandler(int position){
        TasksDataHolderAndOtherStaticMethods.getInstance().getCompletedTasks().remove(position);
        this.completedTasksMain.ctAdapter.notifyDataSetChanged();
        this.completedTasksMain.ctUserSettingsHandler.ctUserSettingsMain("Task permanently deleted");
        this.removeTasksFormCoSharedPreference();
    }
    // Re sp settings
    private void addDataToRemainingSharedPreference(){
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
}