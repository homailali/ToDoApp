package life.homail.todoapp.AddTasks;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import life.homail.todoapp.HomePage.HomePageMain;
import life.homail.todoapp.Model.TaskModel;
import life.homail.todoapp.MyToast.MyToast;
import life.homail.todoapp.SingleTon.SingleTon;
public class SubmitBtnHandler implements View.OnClickListener {
    // Fields
    private AddTasksMain addTasksMain;
    private HomePageMain homePageMain;
    // Constructor
    protected SubmitBtnHandler(AddTasksMain addTasksMain) {
        this.addTasksMain = addTasksMain;
        this.homePageMain=SingleTon.getSingleTon().getHomePageMain();
    }
    // Methods
    public void onClick(View view) {

       this.addTask();
    }
    private void addTask(){
        if (String.valueOf(this.addTasksMain.addTaskView.editText.getText()).isBlank()) MyToast.makeToast("Invalid task",this.addTasksMain);
        else this.addingTask();
    }


    private void addingTask(){
        TaskModel taskModel=this.getTaskModel();
        boolean bool=SingleTon.getSingleTon().getHomePageMain().getRemainingTasksDB().addRemainingTaskToDB(taskModel);
        if (bool) this.onTaskSuccessfullyAddedInDB(taskModel);
        else {
            homePageMain.setIdCount(homePageMain.getIdCount()-1);
            MyToast.makeToast("Error adding the task",this.addTasksMain);
        }
    }


    private void onTaskSuccessfullyAddedInDB(TaskModel taskModel){
        MyToast.makeToast("Task added",this.addTasksMain);
        SingleTon.getSingleTon().getRemainingTasksArr().add(taskModel);
        this.addTasksMain.addTaskView.editText.setText(null);
        this.insertIdCountValueInSharedPref();
    }

    private TaskModel getTaskModel(){
        homePageMain.setIdCount(homePageMain.getIdCount()+1);
        String userTask=String.valueOf(this.addTasksMain.addTaskView.editText.getText());
        return new TaskModel(homePageMain.getIdCount(),userTask, this.getTime(), this.getDate());
    }

    private String  getDate(){
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String date = localDateTime.format(dateTimeFormatter);
        return date;
    }
    private String getTime(){
        LocalDateTime localDateTime=LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("hh:mm a");
        String time= localDateTime.format(dateTimeFormatter);
        return time;
    }

    private void insertIdCountValueInSharedPref(){
        SharedPreferences sharedPreferences= homePageMain.getSharedPreferences(HomePageMain.HOME_SP_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= sharedPreferences.edit();
        editor.putLong(HomePageMain.ID_COUNT_KEY, homePageMain.getIdCount());
        editor.apply();
    }
}