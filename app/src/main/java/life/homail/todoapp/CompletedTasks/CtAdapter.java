package life.homail.todoapp.CompletedTasks;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
        View view= LayoutInflater.from(this.context).inflate(R.layout.row_design_with_only_task,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        try {
            holder.userTasks.setText(TasksDataHolder.getInstance().getCompletedTaskAt(position));
        } catch (Exception exception){}
    }
    public int getItemCount() {
        return TasksDataHolder.getInstance().getTasks().size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView userTasks;
        public ViewHolder(View itemView){
            super(itemView);
            this.userTasks=itemView.findViewById(R.id.userTask);
        }
    }
}
