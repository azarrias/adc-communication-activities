package com.example.communicationactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondaryActivity extends AppCompatActivity {

    TextView tv_greeting;
    String tvGreetingStr1;
    String tvGreetingStr2;
    Button btnAgree;
    Button btnRefuse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        Bundle extras = getIntent().getExtras();

        tv_greeting = findViewById(R.id.tv_greeting);
        btnAgree = findViewById(R.id.btn_agree);
        btnRefuse = findViewById(R.id.btn_refuse);
        tvGreetingStr1 = getString(R.string.tv_greeting_str1);
        tvGreetingStr2 = getString(R.string.tv_greeting_str2);

        String greeting = tvGreetingStr1 + " " + extras.getString("data_name") + tvGreetingStr2;

        tv_greeting.setText(greeting);

        btnAgree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendResult("Agree");
            }
        });

        btnRefuse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendResult("Refuse");
            }
        });
    }

    private void sendResult(String value) {
        Intent i = new Intent();
        i.putExtra("data_result", value);
        setResult(RESULT_OK, i);
        finish();
    }
}
