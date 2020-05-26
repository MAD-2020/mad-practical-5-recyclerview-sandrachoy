package sg.edu.np.mad.mad_recyclerview;

import android.widget.CheckBox;

public class ToDoList {
    private String text;
    private boolean check;
    private boolean isSelected = false;

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public ToDoList(String text, boolean check){
        this.text = text;
        this.check = check;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean getCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public ToDoList(){

    }

}
