package life.homail.todoapp.HomePage;
import android.content.Intent;
import android.view.View;
import life.homail.todoapp.AddTasks.AddTasksMain;
public class PlusTaskBtnHandler implements View.OnClickListener{
    private HomePageMain homePageMain;
    protected PlusTaskBtnHandler(HomePageMain homePageMain){

        this.homePageMain=homePageMain;
    }
    public void onClick(View view){
        this.changeActivity();
    }
    private void changeActivity(){
        Intent intent=new Intent(this.homePageMain, AddTasksMain.class);
        this.homePageMain.startActivity(intent);
    }
}