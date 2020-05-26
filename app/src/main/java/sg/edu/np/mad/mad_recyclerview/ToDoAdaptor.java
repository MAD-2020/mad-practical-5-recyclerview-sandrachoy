package sg.edu.np.mad.mad_recyclerview;

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

    public void onBindViewHolder(ToDoViewHolder holder, int position){
        ToDoList list_items = tdList.get(position);
        holder.txtToDoList.setText(list_items.getText());
        holder.cbToDoList.setChecked(list_items.isSelected());



    }

    @Override
    public int getItemCount(){
        return tdList.size();
    }
}


