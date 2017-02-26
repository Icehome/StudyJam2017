package com.studyjame.aboutmeforstudyjam.abouteme;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NameActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnDone;
    Button btnCancel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.name_activity);

        Button btnDone = (Button) findViewById(R.id.btn_done_name_activity);
        Button btnCancel = (Button) findViewById(R.id.btn_cancel_name_activity);

        btnDone.setOnClickListener(this);
        btnCancel.setOnClickListener(this);

        findViewById(R.id.edit_first_name);
        findViewById(R.id.edit_last_name);

    }
    @Override
    public void onClick (View v) {

        EditText editFirstName = (EditText) findViewById(R.id.edit_first_name);
        EditText editLastName = (EditText) findViewById(R.id.edit_last_name);

        Intent intent;
        switch (v.getId()) {
            case R.id.btn_done_name_activity:
                intent = new Intent();
                intent.putExtra("myFirstName", editFirstName.getText().toString());
                String myFirstName = editFirstName.getText().toString();
                if (myFirstName.matches("")) {
                    Toast.makeText(this, "Please write your First name", Toast.LENGTH_SHORT).show();
                    return;
                }
                intent.putExtra("myLastName", editLastName.getText().toString());
                String myLastName = editLastName.getText().toString();
                if (myLastName.matches("")) {
                    Toast.makeText(this, "Please write your Last name", Toast.LENGTH_SHORT).show();
                    return;
                }
                setResult(RESULT_OK, intent);
                finish();
                break;
            case R.id.btn_cancel_name_activity:

                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
        }
    }
}
