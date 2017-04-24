package com.miniapps.ahnn.mydictionary.mydictionary.SignUp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.miniapps.ahnn.mydictionary.mydictionary.HomeActivity.MainActivity;
import com.miniapps.ahnn.mydictionary.mydictionary.R;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener, SignUpView {

    private EditText fullname, email, password, confirmpassword;
    private Button signup;
    private SignUpPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        fullname = (EditText) findViewById(R.id.reg_Fname);
        email = (EditText) findViewById(R.id.reg_email);
        password = (EditText) findViewById(R.id.reg_pw);
        confirmpassword = (EditText) findViewById(R.id.reg_cpw);
        signup = (Button) findViewById(R.id.reg_btn);
        signup.setOnClickListener(this);
        presenter = new SignUpPresenter(this, new SignUpModel());
    }

    @Override
    public void onClick(View view) {
        presenter.CreateUser(this);
    }

    @Override
    public String getName() {
        return fullname.getText().toString().trim();
    }

    @Override
    public String getEmail() {
        return email.getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return password.getText().toString().trim();
    }

    @Override
    public String getCpassword() {
        return confirmpassword.getText().toString().trim();
    }

    @Override
    public void ErrorMessage(String massage) {
        Toast.makeText(this, massage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void StartMain() {
        startActivity(new Intent(this, MainActivity.class));
    }
}
