package com.example.hw2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hw2_1);
    }

    public void onBtn1Clicked(View v){
        EditText e1 = findViewById(R.id.editText);
        EditText e2 = findViewById(R.id.editText2);
        EditText e3 = findViewById(R.id.editText3);

        e1.setText("");
        e2.setText("");
        e3.setText("");

    }

    public void onBtn2Clicked(View v){
        EditText e1 = findViewById(R.id.editText);
        EditText e2 = findViewById(R.id.editText2);
        EditText e3 = findViewById(R.id.editText3);

        e1.setText("");
        e2.setText("");
        e3.setText("");

    }
}
