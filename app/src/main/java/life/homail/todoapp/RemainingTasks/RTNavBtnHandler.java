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
        this.changeActivity();
    }

    private void changeActivity(){
        this.remainingTasksMain.finish();
    }
}