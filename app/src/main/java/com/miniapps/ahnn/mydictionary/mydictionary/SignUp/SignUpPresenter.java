package com.miniapps.ahnn.mydictionary.mydictionary.SignUp;

import android.app.Activity;

import static android.R.attr.password;

/**
 * Created by AhmedKhaled on 4/17/2017.
 */

public class SignUpPresenter {
    private SignUpView view;
    private SignUpModel model;
    private String id, password, cp, fullname, mail;

    protected SignUpPresenter(SignUpView view, SignUpModel model) {
        this.view = view;
        this.model = model;
    }

    protected void CreateUser(Activity activity) {
        fullname = view.getName();
        mail = view.getEmail();
        password = view.getPassword();
        cp = view.getCpassword();
        if (fullname.isEmpty() || mail.isEmpty()) {
            view.ErrorMessage("Please enter all data");
            return;
        }
        if (password.equals(cp) && !password.isEmpty()) {
            id = model.CreateUser(activity, mail, password, fullname);
        } else {
            view.ErrorMessage("Password not the same");
            return;
        }

    }

}
