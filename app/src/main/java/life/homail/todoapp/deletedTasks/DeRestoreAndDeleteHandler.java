package life.homail.todoapp.deletedTasks;
import android.content.Context;
import android.content.SharedPreferences;
import life.homail.todoapp.ClassesInstances.HomePageMainInstance;
import life.homail.todoapp.SPKeys.SPCodeAndKeys;
import life.homail.todoapp.SingleTon.TasksDataHolderAndOtherStaticMethods;
public class DeRestoreAndDeleteHandler {
    // Fields
    private DeletedTasksMain deletedTasksMain;
    // Constructor
    public DeRestoreAndDeleteHandler(DeletedTasksMain deletedTasksMain) {
        this.deletedTasksMain = deletedTasksMain;
    }
    // Methods
    protected void restoreHandler(int position){
        TasksDataHolderAndOtherStaticMethods.getInstance().addOneRemainingTask(TasksDataHolderAndOtherStaticMethods.getInstance().getDeletedTaskAt(position));
        TasksDataHolderAndOtherStaticMethods.getInstance().getDeletedTasks().remove(position);
        this.deletedTasksMain.dtAdapter.notifyDataSetChanged();
        this.deletedTasksMain.dtUserInfoSettings.dtUserInfoSettingsMain("Task restored");
        this.removeTasksFormDeSharedPreference();
        this.addDataToRemainingSharedPreference();
    }
    protected void deleteBtnHandler(int position){
        TasksDataHolderAndOtherStaticMethods.getInstance().getDeletedTasks().remove(position);
        this.deletedTasksMain.dtAdapter.notifyDataSetChanged();
        this.deletedTasksMain.dtUserInfoSettings.dtUserInfoSettingsMain("Task permanently deleted");
        this.removeTasksFormDeSharedPreference();
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
    // De sp Settings
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
}