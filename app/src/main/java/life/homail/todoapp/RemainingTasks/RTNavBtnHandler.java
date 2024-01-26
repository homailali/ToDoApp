package life.homail.todoapp.RemainingTasks;
import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import life.homail.todoapp.CompletedTasks.CompletedTasksMain;
import life.homail.todoapp.HomePage.HomePageMain;
import life.homail.todoapp.deletedTasks.DeletedTasksMain;
public class RTNavBtnHandler implements View.OnClickListener{
    private RemainingTasksMain remainingTasksMain;
    protected RTNavBtnHandler(RemainingTasksMain remainingTasksMain){
        this.remainingTasksMain=remainingTasksMain;
    }
    public void onClick(View view){
        this.findButtonAndPerformActionAccordingly(view);
    }
    private void findButtonAndPerformActionAccordingly(View view){
        if (view.getId()==this.remainingTasksMain.remainingTasksViews.navHomeBtn.getId()){
            this.changeActivity(HomePageMain.class);
        } else if (view.getId()==this.remainingTasksMain.remainingTasksViews.navDeletedTasksBtn.getId()){
            this.changeActivity(DeletedTasksMain.class);
        } else if (view.getId()==this.remainingTasksMain.remainingTasksViews.navCompletedTasksBtn.getId()){
            this.changeActivity(CompletedTasksMain.class);
        }
    }
    private void changeActivity(Class<? extends AppCompatActivity> classToSwitch){
        Intent intent=new Intent(this.remainingTasksMain,classToSwitch);
        this.remainingTasksMain.startActivity(intent);
    }
}