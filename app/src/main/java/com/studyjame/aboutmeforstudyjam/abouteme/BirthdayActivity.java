package com.studyjame.aboutmeforstudyjam.abouteme;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.studyjame.aboutmeforstudyjam.abouteme.R.id.edit_birthday;


public class BirthdayActivity extends MainActivity implements View.OnClickListener {

    Button btnDone;
    Button btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.birthday_activity);

        btnDone = (Button) findViewById(R.id.btn_done);
        btnCancel = (Button) findViewById(R.id.btn_cancel);

        btnDone.setOnClickListener(this);
        btnCancel.setOnClickListener(this);

        findViewById(edit_birthday);

    }

    @Override
    public void onClick(View v) {


        EditText birthdayEditText = (EditText) findViewById(edit_birthday);

        Intent intent;
        switch (v.getId()) {
            case R.id.btn_done:
                intent = new Intent();
                intent.putExtra("myBirthday", birthdayEditText.getText().toString());
                String myBirthday = birthdayEditText.getText().toString();
                if (myBirthday.matches("")) {
                    Toast.makeText(this, "Please write your Birthday date!", Toast.LENGTH_SHORT).show();
                    return;
                }
                setResult(RESULT_OK, intent);
                finish();
                break;
            case R.id.btn_cancel:
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
        }
    }
}
