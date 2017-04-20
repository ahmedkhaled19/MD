package com.miniapps.ahnn.mydictionary.mydictionary.Login;

/**
 * Created by AhmedKhaled on 4/17/2017.
 */

public interface LoginView {

    String GetEmail();

    String GetPassword();

    void ErrorMassage(String Massage);

    void StartRegister();

    void ToMain();
}
