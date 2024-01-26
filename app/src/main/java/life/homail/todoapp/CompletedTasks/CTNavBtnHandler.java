package life.homail.todoapp.CompletedTasks;
import android.content.Intent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import life.homail.todoapp.HomePage.HomePageMain;
import life.homail.todoapp.RemainingTasks.RemainingTasksMain;
import life.homail.todoapp.deletedTasks.DeletedTasksMain;

public class CTNavBtnHandler implements View.OnClickListener{
    private CompletedTasksMain completedTasksMain;
    public CTNavBtnHandler(CompletedTasksMain completedTasksMain) {
        this.completedTasksMain = completedTasksMain;
    }

    public void onClick(View view){

        this.findButtonAndPerformOperationsAccordingly(view);
    }

    private void findButtonAndPerformOperationsAccordingly(View view){
        if (view.getId()==this.completedTasksMain.completedTasksViews.navHomeBtn.getId()){
            this.changeActivity(HomePageMain.class);
        } else if (view.getId()==this.completedTasksMain.completedTasksViews.navDeletedTasksBtn.getId()){
            this.changeActivity(DeletedTasksMain.class);
        } else if (view.getId()==this.completedTasksMain.completedTasksViews.navRemainingTasksBtn.getId()){
            this.changeActivity(RemainingTasksMain.class);
        }
    }
    private void changeActivity(Class<? extends AppCompatActivity> switchToClass){
        Intent intent=new Intent(this.completedTasksMain,switchToClass);
        this.completedTasksMain.startActivity(intent);
    }
}