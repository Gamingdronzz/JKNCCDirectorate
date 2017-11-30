package com.jknccdirectorate.ViewHolders;

import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.jknccdirectorate.R;

/**
 * Created by hp on 11-09-2017.
 */

public class ViewHolderEditText extends RecyclerView.ViewHolder {

    //private EditText editText;
    private TextInputLayout textview;
    private TextInputEditText editText;

    public ViewHolderEditText(View itemView) {
        super(itemView);
        editText = (TextInputEditText) itemView.findViewById(R.id.editText);
        textview = (TextInputLayout) itemView.findViewById(R.id.text_view_edit_text);
    }

    public void setTitle(String value) {
        textview.setHint(value);
    }

    public String getTitle() {
        return this.editText.getHint().toString();
    }
    /*public void setHint(String value) {
        editText.setHint(value);
    }*/

    public void setTag(String value) {
        textview.setTag(value);
    }

}
