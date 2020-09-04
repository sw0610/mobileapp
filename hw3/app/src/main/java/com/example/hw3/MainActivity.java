package com.example.hw3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TableLayout;

public class MainActivity extends AppCompatActivity {

    TableLayout page1;
    GridLayout page2;
    LinearLayout page3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab);

        ViewGroup root=findViewById(R.id.root);

        page1= (TableLayout)View.inflate(this,R.layout.page1, null);
        page2=(GridLayout)View.inflate(this,R.layout.page2,null);
        page3=(LinearLayout)View.inflate(this,R.layout.page3,null);

        root.addView(page1);
        root.addView(page2);
        root.addView(page3);

        page2.setVisibility(View.INVISIBLE);
        page3.setVisibility(View.INVISIBLE);

    }

    public void onClicked(View v){
        switch (v.getId()){
            case R.id.b_page1:
                page1.setVisibility(View.VISIBLE);
                page2.setVisibility(View.INVISIBLE);
                page3.setVisibility(View.INVISIBLE);
                break;

            case R.id.b_page2:
                page1.setVisibility(View.INVISIBLE);
                page2.setVisibility(View.VISIBLE);
                page3.setVisibility(View.INVISIBLE);
                break;

            case R.id.b_page3:
                page1.setVisibility(View.INVISIBLE);
                page2.setVisibility(View.INVISIBLE);
                page3.setVisibility(View.VISIBLE);
                break;

        }
    }

}