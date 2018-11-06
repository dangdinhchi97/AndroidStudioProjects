package com.deptrai.minhnhat.onthigiuaky;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class CreateActivity extends AppCompatActivity {
    private String array_spinner[];
    private EditText name, age;
    private Button save;

    public static final int REQUEST_CODE =1997;
    public static String NAME ="name_footballplayer";
    public static String AGE ="age_footballplayer";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        name = (EditText) findViewById(R.id.tbxName);
        age = (EditText) findViewById(R.id.tbxAge);
        save = (Button) findViewById(R.id.btnSave);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CreateActivity.this, MainActivity.class);
                intent.putExtra(NAME, name.getText().toString());
                intent.putExtra(AGE, Integer.parseInt(age.getText().toString()));
                startActivityForResult(intent,REQUEST_CODE);
                finish();
            }
        });

        array_spinner=new String[5];
        array_spinner[0]="option 1";
        array_spinner[1]="option 2";
        array_spinner[2]="option 3";
        array_spinner[3]="option 4";
        array_spinner[4]="option 5";
        Spinner s = (Spinner) findViewById(R.id.spinner01);
        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item, array_spinner);
        s.setAdapter(adapter);
    }
}
