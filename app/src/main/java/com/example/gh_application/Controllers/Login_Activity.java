package com.example.gh_application.Controllers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gh_application.Models.Local_DBManager;
import com.example.gh_application.R;

public class Login_Activity extends AppCompatActivity {

    EditText txt_id,txt_pass;
    Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txt_id=findViewById(R.id.login_txt_id);
        txt_pass=findViewById(R.id.login_txt_pass);
        btn_login=findViewById(R.id.login_btn_log);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Local_DBManager local_dbManager=new Local_DBManager(Login_Activity.this);
                Boolean test=local_dbManager.getUser(txt_id.getText().toString(),txt_pass.getText().toString());
                if (test) {
                    openActivity();
                }
                else {
                    Toast.makeText(Login_Activity.this, "Information Incorrect", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
    private void openActivity() {
        Intent intent = new Intent(this, com.example.gh_application.Controllers.Home_Activity.class);
        startActivity(intent);
    }

}
