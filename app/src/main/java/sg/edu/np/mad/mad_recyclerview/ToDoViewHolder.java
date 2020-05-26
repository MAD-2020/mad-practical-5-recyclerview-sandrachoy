package sg.edu.np.mad.mad_recyclerview;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ToDoViewHolder extends RecyclerView.ViewHolder {
    TextView txtToDoList;
    CheckBox cbToDoList;

    public ToDoViewHolder (final View itemView){
        super(itemView);
        txtToDoList = itemView.findViewById(R.id.txtToDo);
        cbToDoList = itemView.findViewById(R.id.cbToDo);

    }

}

