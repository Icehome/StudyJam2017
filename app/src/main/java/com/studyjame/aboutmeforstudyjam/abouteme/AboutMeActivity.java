package com.studyjame.aboutmeforstudyjam.abouteme;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.studyjame.aboutmeforstudyjam.abouteme.R.id.edit_about_me;

public class AboutMeActivity extends AppCompatActivity implements View.OnClickListener {


    Button btnDone;
    Button btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_me_activity);


        btnDone = (Button) findViewById(R.id.btn_done_about_me_activity);
        btnCancel = (Button) findViewById(R.id.btn_cancel_about_me_activity);

        btnDone.setOnClickListener(this);
        btnCancel.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        EditText aboutMeEditText = (EditText) findViewById(edit_about_me);

        Intent intent;
        switch (v.getId()) {
            case R.id.btn_done_about_me_activity:
                intent = new Intent();
                intent.putExtra("aboutMe", aboutMeEditText.getText().toString());
                String aboutMe = aboutMeEditText.getText().toString();
                if (aboutMe.matches("")) {
                    Toast.makeText(this, "Please write something about you", Toast.LENGTH_SHORT).show();
                    return;
                }
                setResult(RESULT_OK, intent);
                finish();
                break;
            case R.id.btn_cancel_about_me_activity:
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
        }

    }
}