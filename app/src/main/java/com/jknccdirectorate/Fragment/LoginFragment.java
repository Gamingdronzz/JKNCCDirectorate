package com.jknccdirectorate.Fragment;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;

import com.jknccdirectorate.R;


/**
 * Created by hp on 11-09-2017.
 */

public class LoginFragment extends DialogFragment {

    TextInputLayout user, password, machine;
    Button submit;


    @Override
    public void onStart()
    {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null)
        {
            int width = ViewGroup.LayoutParams.MATCH_PARENT;
            int height = ViewGroup.LayoutParams.WRAP_CONTENT;
            dialog.getWindow().setLayout(width, height);

        }
    }
            //, cancel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_login, container, false);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        //setStyle(DialogFragment.STYLE_NORMAL, android.R.style.Theme_Holo_Dialog_NoActionBar);
        user = (TextInputLayout) view.findViewById(R.id.usernameWrapper);
        password = (TextInputLayout) view.findViewById(R.id.passwordWrapper);
        //machine = (TextInputLayout) view.findViewById(machineWrapper);
        //submit = (Button) view.findViewById(R.id.btn_submit);
        //cancel = (Button) view.findViewById(R.id.btn_cancel);

        /*String username = user.getEditText().getText().toString();
        String pass = password.getEditText().getText().toString();
*/

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        /*cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        */
        return view;
    }


}
