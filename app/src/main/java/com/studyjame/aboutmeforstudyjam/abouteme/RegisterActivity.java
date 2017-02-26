package com.studyjame.aboutmeforstudyjam.abouteme;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//import android.view.View;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textView;
    //Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);

        String myFirstName = getIntent().getExtras().getString("myFirstName");
        String myLastName = getIntent().getExtras().getString("myLastName");
        String myBirthday = getIntent().getExtras().getString("myBirthday");
        String aboutMe = getIntent().getExtras().getString("aboutMe");

        TextView txtAboutMe = (TextView) findViewById(R.id.txt_about_me);
        TextView txtMyFirstName = (TextView) findViewById(R.id.txt_first_name);
        TextView txtMyLastName = (TextView) findViewById(R.id.txt_last_name);
        TextView txtMyBirthday = (TextView) findViewById(R.id.txt_birthday);

        txtMyFirstName.setText(myFirstName);
        txtMyLastName.setText(myLastName);
        txtMyBirthday.setText(myBirthday);
        txtAboutMe.setText(aboutMe);

        Button closeApp = (Button) findViewById(R.id.btn_close_app);
        closeApp.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        Intent startMain = new Intent(Intent.ACTION_MAIN);
        startMain.addCategory(Intent.CATEGORY_HOME);
        startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(startMain);
        finish();
    }
}
