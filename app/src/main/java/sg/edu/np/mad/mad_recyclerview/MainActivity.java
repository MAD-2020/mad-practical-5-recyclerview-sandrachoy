package sg.edu.np.mad.mad_recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText typeNewText;
    private Button addNewButton;
    RecyclerView recyclerView;
    ToDoViewHolder todoViewHolder;
    ToDoAdaptor todoAdaptor;
    ArrayList<ToDoList> toDoListArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        typeNewText = (EditText) findViewById(R.id.textAdd);
        addNewButton = (Button) findViewById(R.id.buttonAdd);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        toDoListArrayList = new ArrayList<>();
        todoAdaptor = new ToDoAdaptor(toDoListArrayList);
        recyclerView.setAdapter(todoAdaptor);

        createListData();
    }

    @Override
    protected void onStart(){
        super.onStart();

        addNewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newTDL = typeNewText.getText().toString();
                ToDoList td = new ToDoList(newTDL,false);
                toDoListArrayList.add(td);
                todoAdaptor.notifyDataSetChanged();
                typeNewText.setText("");
            }
        });

    }

    private void createListData(){

        ToDoList td1 = new ToDoList("Buy milk", false);
        toDoListArrayList.add(td1);
        ToDoList td2 = new ToDoList("Send postage", false);
        toDoListArrayList.add(td2);
        ToDoList td3 = new ToDoList("Buy Android development book", false);
        toDoListArrayList.add(td3);
    }



    /**
     * Upon calling this method, the keyboard will retract
     * and the recyclerview will scroll to the last item
     *
     * @param rv RecyclerView for scrolling to
     * @param data ArrayList that was passed into RecyclerView
     */
    private void showNewEntry(RecyclerView rv, ArrayList data){
        //scroll to the last item of the recyclerview
        rv.scrollToPosition(data.size() - 1);

        //auto hide keyboard after entry
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(rv.getWindowToken(), 0);
    }
}
