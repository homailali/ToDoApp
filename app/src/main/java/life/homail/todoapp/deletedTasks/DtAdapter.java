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
import life.homail.todoapp.SingleTon.TasksDataHolder;
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
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    // Bind Settings
    public void onBindViewHolder(ViewHolder holder,int position){
        holder.userTasks.setText(TasksDataHolder.getInstance().getDeletedTaskAt(position));
        holder.restoreBtn.setOnClickListener(e->this.restoreHandler(position));
        holder.deleteBtn.setOnClickListener(e->this.deleteBtnHandler(position));
    }
    private void restoreHandler(int position){
       TasksDataHolder.getInstance().addOneRemainingTask(TasksDataHolder.getInstance().getDeletedTaskAt(position));
       TasksDataHolder.getInstance().getDeletedTasks().remove(position);
       super.notifyDataSetChanged();
    }
    private void deleteBtnHandler(int position){
        TasksDataHolder.getInstance().getDeletedTasks().remove(position);
        super.notifyDataSetChanged();
    }
    // BindSettingsEnd


    public int getItemCount(){
        return TasksDataHolder.getInstance().getDeletedTasks().size();
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
