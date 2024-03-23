package life.homail.todoapp.HomePage;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import life.homail.todoapp.R;
import life.homail.todoapp.SingleTon.SingleTon;
public class HomePageMain extends AppCompatActivity{
    protected HomePageViews homePageViews;
    private DeletedTasksDB deletedTasksDB=new DeletedTasksDB(this);
    private CompletedTasksDB completedTasksDB=new CompletedTasksDB(this);
    private RemainingTasksDB remainingTasksDB=new RemainingTasksDB(this);
    protected NavBtnHandler navBtnHandler=new NavBtnHandler(this);
    protected PlusTaskBtnHandler plusTaskBtnHandler=new PlusTaskBtnHandler(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.home_xml);
        this.createSomeObjects();
        this.retrieveDataFromDB();
        this.setValuesForTheNumberOfTasks();
        SingleTon.getSingleTon().setHomePageMain(this);
    }


    private void retrieveDataFromDB(){
        SingleTon.getSingleTon().setDeletedTasksArr(this.deletedTasksDB.getAllDeletedTasksFromDB());
        SingleTon.getSingleTon().setCompletedTasksArr(this.completedTasksDB.getAllCompletedTasksFromDB());
        SingleTon.getSingleTon().setRemainingTasksArr(this.remainingTasksDB.getAllRemainingTasksFromDB());

    }


    private void createSomeObjects(){
        this.homePageViews=new HomePageViews(this);
    }

    @Override
    protected void onResume(){
        super.onResume();
        this.setValuesForTheNumberOfTasks();
    }
    protected void setValuesForTheNumberOfTasks(){
        this.homePageViews.noOfDeletedTasks.setText("Deleted "+ SingleTon.getSingleTon().getDeletedTasksArr().size());
        this.homePageViews.noOfCompletedTasks.setText("Completed "+ SingleTon.getSingleTon().getCompletedTasksArr().size());
        this.homePageViews.noOfRemainingTasks.setText("Remaining "+ SingleTon.getSingleTon().getRemainingTasksArr().size());
    }

    public DeletedTasksDB getDeletedTasksDB() {
        return deletedTasksDB;
    }

    public void setDeletedTasksDB(DeletedTasksDB deletedTasksDB) {
        this.deletedTasksDB = deletedTasksDB;
    }

    public CompletedTasksDB getCompletedTasksDB() {
        return completedTasksDB;
    }

    public void setCompletedTasksDB(CompletedTasksDB completedTasksDB) {
        this.completedTasksDB = completedTasksDB;
    }

    public RemainingTasksDB getRemainingTasksDB() {
        return remainingTasksDB;
    }

    public void setRemainingTasksDB(RemainingTasksDB remainingTasksDB) {
        this.remainingTasksDB = remainingTasksDB;
    }
}