package com.example.layouttest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity {

    private View page1, page2;//다른 메서드에서도 참조할 수 있도록 멤버변수 영역에 선언
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inflation_combine);

        ViewGroup root=findViewById(id)
    }


}
