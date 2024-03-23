package life.homail.todoapp.RemainingTasks;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import life.homail.todoapp.R;
import life.homail.todoapp.SingleTon.SingleTon;

public class RemainingTasksMain extends AppCompatActivity {
    // fields
    protected RTAdapter rtAdapter;
    protected RemainingTasksViews remainingTasksViews;
    protected RTNavBtnHandler rtNavBtnHandler=new RTNavBtnHandler(this);
    private ReMarkDeleteBtnHandler reMarkDeleteBtnHandler=new ReMarkDeleteBtnHandler(this);
    private ReMarkCompleteBtnHandler reMarkCompleteBtnHandler=new ReMarkCompleteBtnHandler(this);
    // methods
    @Override
    public void onCreate(Bundle getCodeFromParent){
        super.onCreate(getCodeFromParent);
        super.setContentView(R.layout.remaining_tasksxml);
        this.doSomeThingsAfterLayoutHasBeenSetUp();
        this.manageSomeRecyclerViewThings();
        this.setVisibilityOfNoTasksRemainingTv();
    }
    private void manageSomeRecyclerViewThings(){
        this.rtAdapter=new RTAdapter(this,this);
        this.remainingTasksViews.rtRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.remainingTasksViews.rtRecyclerView.setAdapter(this.rtAdapter);
    }
    private void doSomeThingsAfterLayoutHasBeenSetUp(){
        this.remainingTasksViews=new RemainingTasksViews(this);
    }

    protected void setVisibilityOfNoTasksRemainingTv(){
        boolean bool= SingleTon.getSingleTon().getRemainingTasksArr().size()==0;
        this.remainingTasksViews.getNoTasksRemainingTv().setVisibility(bool? View.VISIBLE:View.INVISIBLE);
    }
    public ReMarkDeleteBtnHandler getReMarkDeleteBtnHandler() {
        return reMarkDeleteBtnHandler;
    }

    public void setReMarkDeleteBtnHandler(ReMarkDeleteBtnHandler reMarkDeleteBtnHandler) {
        this.reMarkDeleteBtnHandler = reMarkDeleteBtnHandler;
    }

    public ReMarkCompleteBtnHandler getReMarkCompleteBtnHandler() {
        return reMarkCompleteBtnHandler;
    }

    public void setReMarkCompleteBtnHandler(ReMarkCompleteBtnHandler reMarkCompleteBtnHandler) {
        this.reMarkCompleteBtnHandler = reMarkCompleteBtnHandler;
    }

    public RTAdapter getRtAdapter() {
        return rtAdapter;
    }

    public void setRtAdapter(RTAdapter rtAdapter) {
        this.rtAdapter = rtAdapter;
    }

    public RemainingTasksViews getRemainingTasksViews() {
        return remainingTasksViews;
    }

    public void setRemainingTasksViews(RemainingTasksViews remainingTasksViews) {
        this.remainingTasksViews = remainingTasksViews;
    }

    public RTNavBtnHandler getRtNavBtnHandler() {
        return rtNavBtnHandler;
    }

    public void setRtNavBtnHandler(RTNavBtnHandler rtNavBtnHandler) {
        this.rtNavBtnHandler = rtNavBtnHandler;
    }
}
