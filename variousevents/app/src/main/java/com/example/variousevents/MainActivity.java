package com.example.variousevents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

  /*  private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.counter2);

        //view에 대한 참조를 가져옴
        //final TextView tv = (TextView)findViewById(R.id.tv_num);
        tv = (TextView)findViewById(R.id.tv_num);

        Button bDec = (Button) findViewById(R.id.bDec);
        Button bInc = (Button) findViewById(R.id.bInc);

        Button.OnLongClickListener listener = new Button.OnLongClickListener(){
            @Override
            public boolean onLongClick(View v) {

                int num = Integer.parseInt(tv.getText().toString());

                switch (v.getId()) {

                    case R.id.bDec :
                        num-=10;
                        break;

                    case R.id.bInc :
                        num+=10;
                        break;
                }

                tv.setText(String.valueOf(num));

                return true;
                //return false 해주면 길게 클릭 후 떼면 1씩 증가 혹은 감소
                //이벤트 처리가 안끝난 것으로 간주되어 떼면 click이벤트 처리
            }
        };
        bDec.setOnLongClickListener(listener); //리스너 객체 연결
        bInc.setOnLongClickListener(listener);
    }

    public void btnClicked(View v){
        int num = Integer.parseInt(tv.getText().toString());
        switch (v.getId()) {

            case R.id.bDec :
                num--;
                break;

            case R.id.bInc :
                num++;
                break;
        }

        tv.setText(String.valueOf(num));
    }*/
}
