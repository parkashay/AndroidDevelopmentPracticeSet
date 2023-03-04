package com.example.sharedpreferencespractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText et_main;
    private TextView tv_main,tv_result;
    private Button btn_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_main = findViewById(R.id.et_main);
        tv_main = findViewById(R.id.tv_main);
        tv_result = findViewById(R.id.tv_result);
        btn_main = findViewById(R.id.btn_main);

        btn_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String enteredData = et_main.getText().toString();
                SharedPreferences sP = getSharedPreferences("myPreference",MODE_PRIVATE);
                SharedPreferences.Editor ed = sP.edit();
                ed.putString("name",enteredData);
                ed.apply();
                tv_result.setText(enteredData);
            }
        });

    SharedPreferences sP = getSharedPreferences("myPreference", MODE_PRIVATE);
    String result = sP.getString("name","no data entered");
    tv_result.setText(result);

    }
}