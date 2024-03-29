package life.homail.todoapp.RemainingTasks;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import life.homail.todoapp.R;
import life.homail.todoapp.SingleTon.SingleTon;
public class RTAdapter extends RecyclerView.Adapter<RTAdapter.MyViewHolder> {

    private Context context;
    private RemainingTasksMain remainingTasksMain;

    public RTAdapter(Context context, RemainingTasksMain remainingTasksMain) {
        this.context = context;
        this.remainingTasksMain = remainingTasksMain;
    }

    @NonNull
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(this.context).inflate(R.layout.row_design_for_remaining_tasks,parent,false);
        return new MyViewHolder(view);
    }

    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        this.setTextOnFields(holder,position);
        this.setEventHandlers(holder,position);
        Log.d("position",String.valueOf(position));
    }

    private void setEventHandlers(MyViewHolder holder,int position){
        holder.deleteBtn.setOnClickListener(e-> this.remainingTasksMain.getReMarkDeleteBtnHandler().reMarkDeleteBtnHandlerMain(position));
        holder.completedBtn.setOnClickListener(e->this.remainingTasksMain.getReMarkCompleteBtnHandler().reMarkCompleteBtnHandlerMain(position));
    }

    private void setTextOnFields(MyViewHolder holder,int position){
        holder.userTask.setText(SingleTon.getSingleTon().getRemainingTasksArr().get(position).getActualTask());
        holder.timeTv.setText(SingleTon.getSingleTon().getRemainingTasksArr().get(position).getTime());
        holder.dateTv.setText(SingleTon.getSingleTon().getRemainingTasksArr().get(position).getDate());
    }

    public int getItemCount() {
        return SingleTon.getSingleTon().getRemainingTasksArr().size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        Button deleteBtn;
        Button completedBtn;
        TextView userTask;
        TextView dateTv;
        TextView timeTv;
        public MyViewHolder(View itemView){
            super(itemView);
            this.deleteBtn=itemView.findViewById(R.id.deleteBtn);
            this.completedBtn=itemView.findViewById(R.id.restoreBtn);
            this.userTask=itemView.findViewById(R.id.userTask);
            this.dateTv=itemView.findViewById(R.id.dateTv);
            this.timeTv=itemView.findViewById(R.id.timeTv);
        }
    }
}