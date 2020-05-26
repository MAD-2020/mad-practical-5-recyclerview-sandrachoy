package sg.edu.np.mad.mad_recyclerview;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ToDoAdaptor extends RecyclerView.Adapter<ToDoViewHolder> {
    private ArrayList<ToDoList> tdList;
    public ToDoAdaptor(ArrayList<ToDoList> tdList){
        this.tdList = tdList;
    }

    @Override
    public ToDoViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout,parent,false);
        return new ToDoViewHolder(view);
    }

    public void onBindViewHolder(ToDoViewHolder holder, final int position){
        final ToDoList list_items = tdList.get(position);
        holder.txtToDoList.setText(list_items.getText());
        holder.cbToDoList.setChecked(list_items.isSelected());
        final String text = holder.txtToDoList.getText().toString();

        holder.txtToDoList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder= new AlertDialog.Builder(v.getContext());
                builder.setMessage("Are you sure you want to delete " + text + "?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tdList.remove(position);
                        notifyItemRemoved(position);
                        notifyItemRangeChanged(position,tdList.size());
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                AlertDialog alert = builder.create();
                alert.setTitle("Delete");
                alert.show();

            }
        });

    }

    @Override
    public int getItemCount(){
        return tdList.size();
    }
}


