package life.homail.todoapp.HomePage;
import android.content.SharedPreferences;
import life.homail.todoapp.SPKeys.SPCodeAndKeys;
import life.homail.todoapp.SingleTon.TasksDataHolderAndOtherStaticMethods;
import static android.content.Context.MODE_PRIVATE;
public class SpSettings {
    // Fields
    private HomePageMain homePageMain;
    // Constructor
    public SpSettings(HomePageMain homePageMain){
        this.homePageMain = homePageMain;
    }
    // Methods
    protected void SpSettingsMain(){
        this.deletedSpSettings();
        this.remainingSpSettings();
        this.completedSpSettings();
    }
    // Deleted Share preferences
    private void deletedSpSettings(){
        this.initializeDeDataCountKey();
        this.getDataFromDeSharedPreferences();
    }
    private void getDataFromDeSharedPreferences(){
        int count=0;
        SharedPreferences sharedPreferences=this.homePageMain.getSharedPreferences(SPCodeAndKeys.DE_DATA_SP_CODE,MODE_PRIVATE);
        while (true){
            String oldData=sharedPreferences.getString(String.valueOf(count),null);
            if (oldData==null) break;
            TasksDataHolderAndOtherStaticMethods.getInstance().addDeletedTask(oldData);
            count++;
        }
    }
    private void initializeDeDataCountKey(){
        SharedPreferences sharedPreferences=this.homePageMain.getSharedPreferences(SPCodeAndKeys.DE_COUNT_SP_CODE,MODE_PRIVATE);
        SPCodeAndKeys.deDataCountKey=sharedPreferences.getInt(SPCodeAndKeys.keyToStoreDeDataCountKey,0);
    }
    // Completed Shared preferences
    private void completedSpSettings(){
        this.initializeCoDataCountKey();
        this.getDataFormCoSharedPreferences();
    }
    private void getDataFormCoSharedPreferences(){
        int count=0;
        SharedPreferences sharedPreferences=this.homePageMain.getSharedPreferences(SPCodeAndKeys.CO_DATA_SP_CODE,MODE_PRIVATE);
        while (true){
            String oldData=sharedPreferences.getString(String.valueOf(count),null);
            if (oldData==null) break;
            TasksDataHolderAndOtherStaticMethods.getInstance().addCompletedTask(oldData);
            count++;
        }
    }
    private void initializeCoDataCountKey(){
        SharedPreferences sharedPreferences=this.homePageMain.getSharedPreferences(SPCodeAndKeys.CO_COUNT_SP_CODE,MODE_PRIVATE);
        SPCodeAndKeys.coDataCountKey=sharedPreferences.getInt(SPCodeAndKeys.keyToStoreCoDataCountKey,0);
    }
    // Remaining shared preferences
    private void remainingSpSettings(){
        this.initializeReDataCountKey();
        this.getDataFromReSharedPreferences();
    }
    private void getDataFromReSharedPreferences(){
        int count=0;
        SharedPreferences sharedPreferences=this.homePageMain.getSharedPreferences(SPCodeAndKeys.RE_DATA_SP_CODE, MODE_PRIVATE);
        while (true){
            String oldData=sharedPreferences.getString(String.valueOf(count),null);
            System.out.println(oldData);
            if (oldData==null) break;
            TasksDataHolderAndOtherStaticMethods.getInstance().addOneRemainingTask(oldData);
            count++;
        }
    }
    private void initializeReDataCountKey(){
        SharedPreferences sharedPreferences=this.homePageMain.getSharedPreferences(SPCodeAndKeys.RE_COUNT_SP_CODE,MODE_PRIVATE);
        SPCodeAndKeys.reDataCountKey=sharedPreferences.getInt(SPCodeAndKeys.keyToStoreReDataCountKey,0);
    }
}