package com.example.resourcetest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.string_test);

        View v= findViewById(R.id.main);
        registerForContextMenu(v);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = this.getMenuInflater();
        inflater.inflate(R.menu.option_menu,menu);
    }
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int color = Color.WHITE;

        switch (item.getItemId()){
            case R.id.menu_red:
                color = Color.RED; break;

            case R.id.menu_green:
                color = Color.GREEN; break;

            case R.id.menu_blue:
                color=Color.BLUE; break;
        }
        View v= findViewById(R.id.main);
        v.setBackgroundColor(color);
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
     //   return super.onCreateOptionsMenu(menu);//부모에서 적용된것 사용(여기선 없어도 됨)

        MenuInflater inflater = this.getMenuInflater();
        inflater.inflate(R.menu.option_menu,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {//현재 선택한 메뉴 아이템 정보 받음
       int color = Color.WHITE;

        switch (item.getItemId()){
            case R.id.menu_red:
               color = Color.RED; break;

            case R.id.menu_green:
                color = Color.GREEN; break;

            case R.id.menu_blue:
                color=Color.BLUE; break;
       }

       View v= findViewById(R.id.main);
       v.setBackgroundColor(color);

        return super.onOptionsItemSelected(item);
    }
}
