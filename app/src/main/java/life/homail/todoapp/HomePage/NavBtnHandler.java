package life.homail.todoapp.HomePage;
import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import life.homail.todoapp.CompletedTasks.CompletedTasksMain;
import life.homail.todoapp.RemainingTasks.RemainingTasksMain;
import life.homail.todoapp.deletedTasks.DeletedTasksMain;
public class NavBtnHandler implements View.OnClickListener{
    private HomePageMain homePageMain;
    public NavBtnHandler(HomePageMain homePageMain) {
        this.homePageMain = homePageMain;
    }

    public void onClick(View view){
        this.findTheButtonClicked(view);
    }


    private void findTheButtonClicked(View view){
        if (view.getId()==this.homePageMain.homePageViews.navDeletedTasks.getId()){
            this.changeView(DeletedTasksMain.class);
        } else if (view.getId()==this.homePageMain.homePageViews.navCompletedTasks.getId()){
            this.changeView(CompletedTasksMain.class);
        } else if (view.getId()==this.homePageMain.homePageViews.navRemainingTasks.getId()){
            this.changeView(RemainingTasksMain.class);
        }
    }

    private void changeView(Class<? extends AppCompatActivity> changeViewTo){
        Intent intent=new Intent(this.homePageMain,changeViewTo);
        this.homePageMain.startActivity(intent);
    }
}
