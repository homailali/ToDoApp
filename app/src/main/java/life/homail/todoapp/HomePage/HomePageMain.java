package life.homail.todoapp.HomePage;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
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

    }
    private void doSomeThingsAfterLayoutHasBeenSetup(){
        this.homePageViews=new HomePageViews(this);
    }
}