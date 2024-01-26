package life.homail.todoapp.RemainingTasks;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import life.homail.todoapp.R;
import life.homail.todoapp.SingleTon.TasksDataHolder;
public class RTAdapter extends RecyclerView.Adapter<RTAdapter.ViewHolder> {

    private Context context;
    private RemainingTasksMain remainingTasksMain;

    public RTAdapter(Context context, RemainingTasksMain remainingTasksMain) {
        this.context = context;
        this.remainingTasksMain = remainingTasksMain;
    }

    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(this.context).inflate(R.layout.row_with_delete_complete_btn_design,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.userTask.setText(TasksDataHolder.getInstance().getTasks().get(position));
        holder.deleteBtn.setOnClickListener(e->this.deleteAt(position));
        holder.completedBtn.setOnClickListener(e->this.markCompleteAt(position));
    }

    protected void deleteAt(int position){
        TasksDataHolder.getInstance().addDeletedTask(TasksDataHolder.getInstance().getTaskAt(position));
        TasksDataHolder.getInstance().deleteTaskAt(position);
        this.remainingTasksMain.rtAdapter.notifyDataSetChanged();
    }
    protected void markCompleteAt(int position){
        TasksDataHolder.getInstance().addCompletedTask(TasksDataHolder.getInstance().getTaskAt(position));
        TasksDataHolder.getInstance().deleteTaskAt(position);
        this.remainingTasksMain.rtAdapter.notifyDataSetChanged();
    }



    public int getItemCount() {
        return TasksDataHolder.getInstance().getTasks().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        Button deleteBtn;
        Button completedBtn;
        TextView userTask;
        public ViewHolder(View itemView){
            super(itemView);
            this.deleteBtn=itemView.findViewById(R.id.deleteBtn);
            this.completedBtn=itemView.findViewById(R.id.completedBtn);
            this.userTask=itemView.findViewById(R.id.userTask);
        }
    }
}
