package com.example.customviewex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ActionMenuView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);

      //  View v = new MyView(this);
        //MyView를 참조변수로 받아도 되지만, 좀 더 일반화를 위해 상위클래스의 View로 받음

     //   setContentView(v);

   //     setContentView(new AndroidImgView(this));

       setContentView(new TouchView(this));

    }
}
