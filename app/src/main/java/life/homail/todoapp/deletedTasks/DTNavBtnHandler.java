package life.homail.todoapp.deletedTasks;
import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import life.homail.todoapp.CompletedTasks.CompletedTasksMain;
import life.homail.todoapp.HomePage.HomePageMain;
import life.homail.todoapp.RemainingTasks.RemainingTasksMain;

public class DTNavBtnHandler implements View.OnClickListener{
    private DeletedTasksMain deletedTasksMain;
    protected DTNavBtnHandler (DeletedTasksMain deletedTasksMain){
        this.deletedTasksMain=deletedTasksMain;
    }
    public void onClick(View view){
        this.performActionsBasedOnTheButtonClicked(view);
    }
    private void performActionsBasedOnTheButtonClicked(View view){
        if (view.getId()==this.deletedTasksMain.deletedTaskViews.navHomeBtn.getId()){
            this.changeActivity(HomePageMain.class);
        } else if (view.getId()==this.deletedTasksMain.deletedTaskViews.navCompletedBtn.getId()){
            this.changeActivity(CompletedTasksMain.class);
        } else if (view.getId()==this.deletedTasksMain.deletedTaskViews.navRemainingTasks.getId()){
            this.changeActivity(RemainingTasksMain.class);
        }
    }
    private void changeActivity(Class<? extends AppCompatActivity> classToSwitch){
        Intent intent=new Intent(this.deletedTasksMain,classToSwitch);
        this.deletedTasksMain.startActivity(intent);
    }
}