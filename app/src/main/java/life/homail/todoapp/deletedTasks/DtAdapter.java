package life.homail.todoapp.deletedTasks;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import life.homail.todoapp.R;
import life.homail.todoapp.SingleTon.SingleTon;
public class DtAdapter extends RecyclerView.Adapter<DtAdapter.ViewHolder>{
    private Context context;
    private DeletedTasksMain deletedTasksMain;
    public DtAdapter(Context context, DeletedTasksMain deletedTasksMain) {
        this.context = context;
        this.deletedTasksMain = deletedTasksMain;
    }
    @NonNull
    public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        View view= LayoutInflater.from(this.context).inflate(R.layout.row_design_for_deleted_completed_tasks,parent,false);
        return new ViewHolder(view);
    }
    // Bind Settings
    public void onBindViewHolder(ViewHolder holder,int position){
        holder.userTasks.setText(SingleTon.getSingleTon().getDeletedTasksArr().get(position).getActualTask());
        holder.restoreBtn.setOnClickListener(e->this.deletedTasksMain.getDtRestoreBtnHandler().DtRestoreBtnHandlerMain(SingleTon.getSingleTon().getDeletedTasksArr().get(position)));
        holder.deleteBtn.setOnClickListener(e->this.deletedTasksMain.getDtDeleteBtnHandler().dtDeleteBtnHandlerMain(SingleTon.getSingleTon().getDeletedTasksArr().get(position)));
    }
    // BindSettingsEnd
    public int getItemCount(){
        return SingleTon.getSingleTon().getDeletedTasksArr().size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView userTasks;
        Button deleteBtn;
        Button restoreBtn;
        public ViewHolder (View itemView){
            super(itemView);
            this.userTasks=itemView.findViewById(R.id.userTask);
            this.deleteBtn=itemView.findViewById(R.id.deleteBtn);
            this.restoreBtn=itemView.findViewById(R.id.restoreBtn);
        }

    }
}
