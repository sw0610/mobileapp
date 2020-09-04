package com.example.hw5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = this.getMenuInflater();
        inflater.inflate(R.menu.hw6_menu,menu);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int color = Color.WHITE;

        switch (item.getItemId()){
            case R.id.item_red:
                color = Color.RED; break;

            case R.id.item_yellow:
                color = Color.YELLOW; break;

            case R.id.item_gray:
                color=Color.GRAY; break;
        }
        View v= findViewById(R.id.main);
        v.setBackgroundColor(color);
        return super.onOptionsItemSelected(item);
    }
}


