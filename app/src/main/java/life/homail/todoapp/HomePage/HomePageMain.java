package life.homail.todoapp.HomePage;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import life.homail.todoapp.Model.TaskModel;
import life.homail.todoapp.R;
import life.homail.todoapp.SingleTon.SingleTon;
public class HomePageMain extends AppCompatActivity{
    private long idCount;

    public static final String HOME_SP_NAME="HomeSharedPref";
    public static final String ID_COUNT_KEY="countId";

    private HomePageViews homePageViews;
    private NavBtnHandler navBtnHandler=new NavBtnHandler(this);
    private DeletedTasksDB deletedTasksDB=new DeletedTasksDB(this);
    private CompletedTasksDB completedTasksDB=new CompletedTasksDB(this);
    private RemainingTasksDB remainingTasksDB=new RemainingTasksDB(this);
    protected PlusTaskBtnHandler plusTaskBtnHandler=new PlusTaskBtnHandler(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.home_xml);
        this.createSomeObjects();
        this.retrieveDataFromDB();
        this.setIdCountValue();
        this.setValuesForTheNumberOfTasks();
        SingleTon.getSingleTon().setHomePageMain(this);
    }


    private void setIdCountValue() {
        SharedPreferences sharedPreferences=super.getSharedPreferences(HOME_SP_NAME,MODE_PRIVATE);
        this.idCount=sharedPreferences.getLong(ID_COUNT_KEY,0);
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
        this.homePageViews.noOfDeletedTasks.setText("Deleted : "+ SingleTon.getSingleTon().getDeletedTasksArr().size());
        this.homePageViews.noOfCompletedTasks.setText("Completed : "+ SingleTon.getSingleTon().getCompletedTasksArr().size());
        this.homePageViews.noOfRemainingTasks.setText("Remaining : "+ SingleTon.getSingleTon().getRemainingTasksArr().size());
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

    public HomePageViews getHomePageViews() {
        return homePageViews;
    }

    public void setHomePageViews(HomePageViews homePageViews) {
        this.homePageViews = homePageViews;
    }

    public NavBtnHandler getNavBtnHandler() {
        return navBtnHandler;
    }

    public void setNavBtnHandler(NavBtnHandler navBtnHandler) {
        this.navBtnHandler = navBtnHandler;
    }

    public PlusTaskBtnHandler getPlusTaskBtnHandler() {
        return plusTaskBtnHandler;
    }

    public void setPlusTaskBtnHandler(PlusTaskBtnHandler plusTaskBtnHandler) {
        this.plusTaskBtnHandler = plusTaskBtnHandler;
    }

    public long getIdCount() {
        return idCount;
    }

    public void setIdCount(long idCount) {
        this.idCount = idCount;
    }

}