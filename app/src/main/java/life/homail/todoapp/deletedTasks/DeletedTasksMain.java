package life.homail.todoapp.deletedTasks;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import life.homail.todoapp.R;
import life.homail.todoapp.SingleTon.SingleTon;

public class DeletedTasksMain extends AppCompatActivity {
    protected DtAdapter dtAdapter;
    protected DeletedTaskViews deletedTaskViews;
    protected DTNavBtnHandler dtNavBtnHandler=new DTNavBtnHandler(this);
    private DTDeleteBtnHandler dtDeleteBtnHandler=new DTDeleteBtnHandler(this);
    private DtRestoreBtnHandler dtRestoreBtnHandler=new DtRestoreBtnHandler(this);
    @Override
    public void onCreate(Bundle getCodeFromParent){
        super.onCreate(getCodeFromParent);
        super.setContentView(R.layout.deleted_tasksxml);
        this.doSomeThingsAfterLayoutHasBeenSetUp();
        this.dtAdapterSettings();
        this.dtRecyclerViewSettings();
        this.setVisibilityOfNoTasksDeletedTv();
    }



    protected void setVisibilityOfNoTasksDeletedTv(){
        boolean bool= SingleTon.getSingleTon().getDeletedTasksArr().size()==0;
        this.deletedTaskViews.getNoTasksDeletedTv().setVisibility(bool? View.VISIBLE:View.INVISIBLE);
    }

    private void dtRecyclerViewSettings(){
        this.deletedTaskViews.dtRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.deletedTaskViews.dtRecyclerView.setAdapter(this.dtAdapter);
    }
    private void dtAdapterSettings(){
        this.dtAdapter=new DtAdapter(this,this);
    }

    private void doSomeThingsAfterLayoutHasBeenSetUp(){

        this.deletedTaskViews=new DeletedTaskViews(this);
    }

    public DtAdapter getDtAdapter() {
        return dtAdapter;
    }

    public void setDtAdapter(DtAdapter dtAdapter) {
        this.dtAdapter = dtAdapter;
    }

    public DeletedTaskViews getDeletedTaskViews() {
        return deletedTaskViews;
    }

    public void setDeletedTaskViews(DeletedTaskViews deletedTaskViews) {
        this.deletedTaskViews = deletedTaskViews;
    }

    public DTNavBtnHandler getDtNavBtnHandler() {
        return dtNavBtnHandler;
    }

    public void setDtNavBtnHandler(DTNavBtnHandler dtNavBtnHandler) {
        this.dtNavBtnHandler = dtNavBtnHandler;
    }

    public DTDeleteBtnHandler getDtDeleteBtnHandler() {
        return dtDeleteBtnHandler;
    }

    public void setDtDeleteBtnHandler(DTDeleteBtnHandler dtDeleteBtnHandler) {
        this.dtDeleteBtnHandler = dtDeleteBtnHandler;
    }

    public DtRestoreBtnHandler getDtRestoreBtnHandler() {
        return dtRestoreBtnHandler;
    }

    public void setDtRestoreBtnHandler(DtRestoreBtnHandler dtRestoreBtnHandler) {
        this.dtRestoreBtnHandler = dtRestoreBtnHandler;
    }
}
