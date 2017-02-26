package com.studyjame.aboutmeforstudyjam.abouteme;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    final int REQUEST_CODE_NAME = 1;
    final int REQUEST_CODE_BIRTDAY = 2;
    final int REQUEST_CODE_ABOUTME = 3;
    //final int REQUEST_CODE_REGISTER = 4;

    String my_first_name;
    String my_last_name;
    String my_birthday;
    String about_me;

    Button btnName;
    Button btnBirthday;
    Button btnAboutMe;
    Button btnRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnName = (Button) findViewById(R.id.btn_name);
        btnBirthday = (Button) findViewById(R.id.btn_birthday);
        btnAboutMe = (Button) findViewById(R.id.btn_about_me);
        btnRegister = (Button) findViewById(R.id.btn_register);

        btnName.setOnClickListener(this);
        btnBirthday.setOnClickListener(this);
        btnAboutMe.setOnClickListener(this);
        btnRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.btn_name:
                intent = new Intent(this, NameActivity.class);
                startActivityForResult(intent, REQUEST_CODE_NAME);
                break;
            case R.id.btn_birthday:
                intent = new Intent(this, BirthdayActivity.class);
                startActivityForResult(intent, REQUEST_CODE_BIRTDAY);
                break;
            case R.id.btn_about_me:
                intent = new Intent(this, AboutMeActivity.class);
                startActivityForResult(intent, REQUEST_CODE_ABOUTME);
                break;
            case R.id.btn_register:
                intent = new Intent(this, RegisterActivity.class);
                intent.putExtra("myFirstName", my_first_name);
                intent.putExtra("myLastName", my_last_name);
                intent.putExtra("myBirthday", my_birthday);
                intent.putExtra("aboutMe", about_me);
                startActivity(intent);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (data != null) {
            switch (requestCode) {
                case REQUEST_CODE_ABOUTME:
                    about_me = data.getStringExtra("aboutMe");
                    break;
                case REQUEST_CODE_BIRTDAY:
                    my_birthday = data.getStringExtra("myBirthday");
                    break;
                case REQUEST_CODE_NAME:
                    my_first_name = data.getStringExtra("myFirstName");
                    my_last_name = data.getStringExtra("myLastName");
                    break;
            }
        }

    }
}
