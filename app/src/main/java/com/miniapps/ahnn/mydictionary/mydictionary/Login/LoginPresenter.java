package com.miniapps.ahnn.mydictionary.mydictionary.Login;


import android.app.Activity;

/**
 * Created by AhmedKhaled on 4/17/2017.
 */

public class LoginPresenter {

    private LoginModel model;
    private LoginView view;

    protected LoginPresenter(LoginModel model, LoginView view, Activity activity) {
        this.model = model;
        this.view = view;
        model.OnCreate(activity);
    }

    protected void OnStart() {
        model.OnStart();
    }

    protected void OnStop() {
        model.OnStop();
    }

    protected void CheckUser() {
        String email = view.GetEmail();
        if (email.isEmpty()) {
            view.ErrorMassage("please enter your email");
            return;
        }
        String password = view.GetPassword();
        if (password.isEmpty()) {
            view.ErrorMassage("please enter your password");
            return;
        }
        String id = model.SignIn(email, password);

    }

    public void Register() {
        view.StartRegister();
    }
}
