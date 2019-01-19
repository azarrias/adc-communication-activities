package com.example.communicationactivities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondaryActivity extends AppCompatActivity {

    TextView tv_greeting;
    String tvGreetingStr1;
    String tvGreetingStr2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        Bundle extras = getIntent().getExtras();

        tv_greeting = findViewById(R.id.tv_greeting);
        tvGreetingStr1 = getString(R.string.tv_greeting_str1);
        tvGreetingStr2 = getString(R.string.tv_greeting_str2);

        String greeting = tvGreetingStr1 + " " + extras.getString("data_name") + tvGreetingStr2;

        tv_greeting.setText(greeting);
    }
}
