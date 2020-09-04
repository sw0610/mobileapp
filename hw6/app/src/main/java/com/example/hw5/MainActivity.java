package com.example.hw5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hw5);

        TextView tv3 = (TextView) findViewById(R.id.textView3);

        String name = getResources().getString(R.string.my_name);
        tv3.setText(name);



    }

    public void onBtnClicked(View v){
        EditText e1 = findViewById(R.id.editText1);
        EditText e2 = findViewById(R.id.editText2);

        String s1=e1.getText().toString();
        String s2=e2.getText().toString();

        Toast.makeText(this, s1+" "+s2, Toast.LENGTH_LONG).show();

        e1.setText("");
        e2.setText("");

    }

}
