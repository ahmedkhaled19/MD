package com.miniapps.ahnn.mydictionary.mydictionary.Login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.miniapps.ahnn.mydictionary.mydictionary.HomeActivity.MainActivity;
import com.miniapps.ahnn.mydictionary.mydictionary.R;
import com.miniapps.ahnn.mydictionary.mydictionary.SignUp.SignUpActivity;

public class Login extends AppCompatActivity implements LoginView, View.OnClickListener {

    private EditText email, password;
    private Button login;
    private TextView register;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = (EditText) findViewById(R.id.login_email);
        password = (EditText) findViewById(R.id.login_password);
        login = (Button) findViewById(R.id.login_btn);
        login.setOnClickListener(this);
        register = (TextView) findViewById(R.id.reg_txt);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.Register();
            }
        });
        presenter = new LoginPresenter(new LoginModel(), this, this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.OnStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.OnStop();
    }

    @Override
    public void onClick(View view) {
ToMain();
    }

    @Override
    public String GetEmail() {
        return email.getText().toString().trim();
    }

    @Override
    public String GetPassword() {
        return password.getText().toString().trim();
    }

    @Override
    public void ErrorMassage(String massage) {
        Toast.makeText(getApplicationContext(), massage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void StartRegister() {
        startActivity(new Intent(getApplicationContext(), SignUpActivity.class));

    }

    @Override
    public void ToMain() {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }


}
