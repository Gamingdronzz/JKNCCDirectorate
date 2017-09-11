package com.jknccdirectorate.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.jknccdirectorate.R;

import static com.jknccdirectorate.R.id.machineWrapper;

/**
 * Created by hp on 11-09-2017.
 */

public class FragmentLogin extends DialogFragment {

    TextInputLayout user, password, machine;
    Button submit, cancel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_dialog, container, false);

       getDialog().setTitle("SIGN IN");
        user = (TextInputLayout) view.findViewById(R.id.usernameWrapper);
        password = (TextInputLayout) view.findViewById(R.id.passwordWrapper);
        machine = (TextInputLayout) view.findViewById(machineWrapper);
        submit = (Button) view.findViewById(R.id.btn_submit);
        cancel = (Button) view.findViewById(R.id.btn_cancel);

        /*String username = user.getEditText().getText().toString();
        String pass = password.getEditText().getText().toString();
*/

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        return view;
    }


}
