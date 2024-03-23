package life.homail.todoapp.HomePage;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import life.homail.todoapp.Model.TaskModel;
public class CompletedTasksDB extends SQLiteOpenHelper {
    // fields
    private final static String ID_COLUMN_NAME="idColumn";
    private final static String TABLE_NAME="CompletedTasksTable";
    private final static String ACTUAL_TASKS_COLUMN_NAME="CompletedTasks";

    private static final Integer DB_VERSION=1;
    private static final String DB_NAME="CompletedTasksDB";
    // constructor
    public CompletedTasksDB(HomePageMain homePageMain){
        super(homePageMain,DB_NAME,null,DB_VERSION);
    }
    // methods
    public void onCreate(SQLiteDatabase sqLiteDatabase){
        String query=
                "create table "+TABLE_NAME+
                 "("+
                   ID_COLUMN_NAME+" integer primary key autoincrement ,"+
                   ACTUAL_TASKS_COLUMN_NAME+" text"
                 +")"
                ;
        sqLiteDatabase.execSQL(query);
    }
    public void onUpgrade(SQLiteDatabase sqLiteDatabase,int oldVersion,int newVersion){}
    public boolean addCompletedTaskToDB(TaskModel taskModel){
        SQLiteDatabase sqLiteDatabase=super.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(ACTUAL_TASKS_COLUMN_NAME, taskModel.getActualTask());
        long temp=sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        sqLiteDatabase.close();
        return temp!=-1;
    }

    public ArrayList<TaskModel> getAllCompletedTasksFromDB(){
        ArrayList<TaskModel> returnList=new ArrayList<>();
        SQLiteDatabase sqLiteDatabase=super.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("select * from "+TABLE_NAME,null);
        if (cursor.moveToFirst()){
            do {
                int taskNumber=cursor.getInt(0);
                String completedTask= cursor.getString(1);
                TaskModel taskModel =new TaskModel(completedTask,taskNumber);
                returnList.add(taskModel);
            } while (cursor.moveToNext());
        }
        cursor.close();
        sqLiteDatabase.close();
        return returnList;
    }
    public boolean deleteCompletedTaskFromDB(TaskModel taskModel){
        SQLiteDatabase sqLiteDatabase=super.getWritableDatabase();
        long temp=sqLiteDatabase.delete(TABLE_NAME,ID_COLUMN_NAME+"=?",new String[]{String.valueOf(taskModel.getTaskNumber())});
        sqLiteDatabase.close();
        return temp!=0;
    }
}
