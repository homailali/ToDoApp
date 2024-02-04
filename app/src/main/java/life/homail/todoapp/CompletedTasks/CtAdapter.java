package life.homail.todoapp.CompletedTasks;
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
public class CtAdapter extends RecyclerView.Adapter<CtAdapter.ViewHolder> {
    private Context context;
    private CompletedTasksMain completedTasksMain;
    public CtAdapter(Context context, CompletedTasksMain completedTasksMain) {
        this.context = context;
        this.completedTasksMain = completedTasksMain;
    }
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(this.context).inflate(R.layout.row_design_for_deleted_completed_tasks,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }
    // Bind settings
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
         holder.userTasks.setText(TasksDataHolder.getInstance().getCompletedTaskAt(position));
         holder.deleteBtn.setOnClickListener(e->this.deleteBtnHandler(position));
         holder.restoreBtn.setOnClickListener(e->this.restoreBtnHandler(position));
    }
    private void restoreBtnHandler(int position){
        TasksDataHolder.getInstance().addOneRemainingTask(TasksDataHolder.getInstance().getCompletedTaskAt(position));
        TasksDataHolder.getInstance().getCompletedTasks().remove(position);
        super.notifyDataSetChanged();
        this.completedTasksMain.ctUserSettingsHandler.ctUserSettingsMain("Task restored");
    }
    private void deleteBtnHandler(int position){
        TasksDataHolder.getInstance().getCompletedTasks().remove(position);
        super.notifyDataSetChanged();
        this.completedTasksMain.ctUserSettingsHandler.ctUserSettingsMain("Task permanently deleted");
    }
    // Bind settings end
    public int getItemCount() {
        return TasksDataHolder.getInstance().getCompletedTasks().size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView userTasks;
        Button deleteBtn;
        Button restoreBtn;
        public ViewHolder(View itemView){
            super(itemView);
            this.userTasks=itemView.findViewById(R.id.userTask);
            this.deleteBtn=itemView.findViewById(R.id.deleteBtn);
            this.restoreBtn=itemView.findViewById(R.id.restoreBtn);
        }
    }
}