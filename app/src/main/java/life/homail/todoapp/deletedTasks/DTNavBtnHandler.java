package life.homail.todoapp.deletedTasks;
import android.view.View;

public class DTNavBtnHandler implements View.OnClickListener{
    private DeletedTasksMain deletedTasksMain;
    protected DTNavBtnHandler (DeletedTasksMain deletedTasksMain){
        this.deletedTasksMain=deletedTasksMain;
    }
    public void onClick(View view){
         this.changeActivity();
    }

    private void changeActivity(){
       this.deletedTasksMain.finish();
    }
}