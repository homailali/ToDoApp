package life.homail.todoapp.HomePage;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import life.homail.todoapp.ClassesInstances.HomePageMainInstance;
import life.homail.todoapp.R;
import life.homail.todoapp.SingleTon.TasksDataHolderAndOtherStaticMethods;
public class HomePageMain extends AppCompatActivity{
    protected HomePageViews homePageViews;
    protected SpSettings spSettings=new SpSettings(this);
    protected NavBtnHandler navBtnHandler=new NavBtnHandler(this);
    protected PlusTaskBtnHandler plusTaskBtnHandler=new PlusTaskBtnHandler(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.home_xml);
        HomePageMainInstance.initializeHomePageMain(this);
        this.doSomeThingsAfterLayoutHasBeenSetup();
    }
    private void doSomeThingsAfterLayoutHasBeenSetup(){
        this.homePageViews=new HomePageViews(this);
        if (TasksDataHolderAndOtherStaticMethods.ifAllowedToGetSpData()) this.spSettings.SpSettingsMain();
    }
    @Override
    protected void onResume(){
        super.onResume();
        this.setValuesForTheNumberOfTasks();
    }
    protected void setValuesForTheNumberOfTasks(){
        this.homePageViews.noOfDeletedTasks.setText("Deleted "+ TasksDataHolderAndOtherStaticMethods.getInstance().getDeletedTasks().size());
        this.homePageViews.noOfCompletedTasks.setText("Completed "+ TasksDataHolderAndOtherStaticMethods.getInstance().getCompletedTasks().size());
        this.homePageViews.noOfRemainingTasks.setText("Remaining "+ TasksDataHolderAndOtherStaticMethods.getInstance().getRemainingTasks().size());
    }
}