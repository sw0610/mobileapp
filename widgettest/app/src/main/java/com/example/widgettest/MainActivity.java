package com.example.widgettest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imageview_test);
    }
/*
    public void onButtonClicked(View v){
        EditText et = findViewById(R.id.editText1);
        TextView tv = findViewById(R.id.textView1);

        String str = et.getText().toString(); //editable type 반환=>문자열로 변환해서 표현
        tv.setText(str);

    }
 */
}
