package life.homail.todoapp.HomePage;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import life.homail.todoapp.R;
public class HomePageMain extends AppCompatActivity {
    protected HomePageViews homePageViews;
    protected NavBtnHandler navBtnHandler=new NavBtnHandler(this);
    protected PlusTaskBtnHandler plusTaskBtnHandler=new PlusTaskBtnHandler(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.home_xml);
        this.doSomeThingsAfterLayoutHasBeenSetup();

        Log.i("Life cycle","Home page on create triggered");

    }
    private void doSomeThingsAfterLayoutHasBeenSetup(){
        this.homePageViews=new HomePageViews(this);
    }


    @Override
    protected void onStart(){
        super.onStart();
        Log.i("Life cycle","Home page on start triggered");
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.i("Life cycle","Home page on resume triggered");
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.i("Life cycle","Home page on pause triggered");
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.i("Life cycle","Home page on stop triggered");
    }
    @Override
    protected void onRestart(){
        super.onRestart();
        Log.i("Life cycle","Home page on restart triggered");
    }
    @Override
    protected void onDestroy(){
        Log.i("Life cycle","Home page on destroy triggered");

        super.onDestroy();
    }
}