package com.example.anil.smarthelpline.login_tabs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.anil.smarthelpline.MainActivity;
import com.example.anil.smarthelpline.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button login,register;
    private EditText etEmail,etPassword;
    private DbHelper db;
    private Session session;

    private TextView withoutLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_login);

        db = new DbHelper(this);
        session = new Session(this);
        login=(Button)findViewById(R.id.btnLogin);
        register=(Button) findViewById(R.id.btnRegister);
        etEmail=(EditText)findViewById(R.id.etEmail);
        etPassword=(EditText)findViewById(R.id.etPassword);

        withoutLogin=(TextView)findViewById(R.id.withoutLogin);

        login.setOnClickListener(this);
        register.setOnClickListener(this);
        withoutLogin.setOnClickListener(this);


        if(session.loggedin()){
            startActivity(new Intent(LoginActivity.this,MainActivity.class));
            finish();
        }
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLogin:
                login();
                break;
            case R.id.btnRegister:
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                break;
            case R.id.withoutLogin:
                startActivity(new Intent(LoginActivity.this,MainActivity.class));
                break;
            default:

        }
    }
    private void login() {
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();


        if (db.getUser(email, password)) {
            session.setLoggedin(true);
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        } else {
            Toast.makeText(getApplicationContext(), "Wrong email/password", Toast.LENGTH_SHORT).show();
        }
    }
}
