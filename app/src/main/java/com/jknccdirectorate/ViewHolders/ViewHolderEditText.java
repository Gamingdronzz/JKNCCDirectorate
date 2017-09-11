package com.jknccdirectorate.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.jknccdirectorate.R;

/**
 * Created by hp on 11-09-2017.
 */

public class ViewHolderEditText extends RecyclerView.ViewHolder {

    private EditText editText;
    private TextView textview;

    public ViewHolderEditText(View itemView) {
        super(itemView);
        editText = (EditText) itemView.findViewById(R.id.edit_text);
        textview = (TextView) itemView.findViewById(R.id.text_view_edit_text);
    }

    public void setTitle(String value) {
        textview.setText(value);
    }

   /* public String getTitle() {
        return this.textview.getText().toString();
    }
    public String getValue() {
        return this.editText.getText().toString();
    }
*/
    public void setHint(String value) {
        textview.setHint(value);
    }

    public void setTag(String value) {
        editText.setTag(value);
    }

}
