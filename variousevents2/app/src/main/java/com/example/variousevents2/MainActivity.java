package com.example.variousevents2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.echo);

        EditText et = findViewById(R.id.et_input);
        final TextView tv = findViewById(R.id.tv_disp);

        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                tv.setText("echo: "+ s);//기존의 문자열에 추가되는 문자를 추가한다.
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
