package com.example.anil.smarthelpline.login_tabs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.anil.smarthelpline.R;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private Button register;
    private TextView retLogin;
    private EditText etEemail, etPassword;
    private DbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_register);

        db=new DbHelper(this);
        register = (Button) findViewById(R.id.btnRegister);
        retLogin = (TextView) findViewById(R.id.retLogin);
        etEemail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        register.setOnClickListener(this);
        retLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnRegister:
                register();
                break;
            case R.id.retLogin:
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                break;
            default:
        }
    }
    private void register(){
        String email =etEemail.getText().toString();
        String password = etPassword.getText().toString();
        if(email.isEmpty() && password.isEmpty()){
            displayToast("Username/password field empty");
        }else{
            db.addUser(email,password);
            displayToast("User registered");
            finish();
        }
    }

    private void displayToast(String s) {
        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
    }
}
