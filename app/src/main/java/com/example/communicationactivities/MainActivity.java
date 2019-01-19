package com.example.communicationactivities;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnVerify;
    private EditText etName;
    private static final int reqCode = 1;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.et_name);
        btnVerify = findViewById(R.id.btn_verify);
        tvResult = findViewById(R.id.tv_result);

        btnVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), SecondaryActivity.class);
                i.putExtra("data_name", etName.getText().toString());
                startActivityForResult(i, reqCode);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == reqCode && resultCode == RESULT_OK) {
            String result = getString(R.string.tv_result_str) + " "
                    + data.getExtras().getString("data_result");

            tvResult.setText(result);
        }
    }
}
