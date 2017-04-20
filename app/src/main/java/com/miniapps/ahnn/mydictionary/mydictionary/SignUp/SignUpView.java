package com.miniapps.ahnn.mydictionary.mydictionary.SignUp;

/**
 * Created by AhmedKhaled on 4/17/2017.
 */

public interface SignUpView {
    String getName();

    String getEmail();

    String getPassword();

    String getCpassword();

    void ErrorMessage(String massage);

    void StartMain();

}
