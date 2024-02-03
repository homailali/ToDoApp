package life.homail.todoapp.CompletedTasks;
import android.view.View;

public class CTNavBtnHandler implements View.OnClickListener{
    private CompletedTasksMain completedTasksMain;
    public CTNavBtnHandler(CompletedTasksMain completedTasksMain) {
        this.completedTasksMain = completedTasksMain;
    }
    public void onClick(View view){
        this.changeActivity();
    }
    private void changeActivity(){
        this.completedTasksMain.finish();
    }
}