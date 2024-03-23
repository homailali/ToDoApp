package life.homail.todoapp.MyToast;

import android.content.Context;
import android.widget.Toast;

public final class MyToast {
    private static Toast myToast;
    public static void makeToast(String toastText,Context context){
        if (myToast!=null) myToast.cancel();
        myToast=Toast.makeText(context,toastText,Toast.LENGTH_SHORT);
        myToast.show();
    }
}
