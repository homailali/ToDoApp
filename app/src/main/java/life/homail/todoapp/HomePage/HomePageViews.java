package life.homail.todoapp.HomePage;
import android.content.SharedPreferences;
import android.widget.Button;
import life.homail.todoapp.R;
public class HomePageViews {
    // Fields
    private HomePageMain homePageMain;
    protected Button plusTaskBtn;
    protected Button navCompletedTasks;
    protected Button navRemainingTasks;
    protected Button navDeletedTasks;
    // Constructor
    protected HomePageViews(HomePageMain homePageMain){
        this.homePageMain = homePageMain;
        this.initializeViews();
        this.setEventHandlerForNavBtn();
        this.setSomeOtherEventHandlers();
    }




    private void initializeViews(){
        this.plusTaskBtn=this.homePageMain.findViewById(R.id.plusTaskBtn);
        this.navRemainingTasks=this.homePageMain.findViewById(R.id.remainingTasks);
        this.navCompletedTasks=this.homePageMain.findViewById(R.id.completedTasks);
        this.navDeletedTasks=this.homePageMain.findViewById(R.id.deletedTasks);
    }



    private void setSomeOtherEventHandlers(){
        this.plusTaskBtn.setOnClickListener(this.homePageMain.plusTaskBtnHandler);
    }
    private void setEventHandlerForNavBtn(){
        this.navDeletedTasks.setOnClickListener(this.homePageMain.navBtnHandler);
        this.navCompletedTasks.setOnClickListener(this.homePageMain.navBtnHandler);
        this.navRemainingTasks.setOnClickListener(this.homePageMain.navBtnHandler);
    }
}
