package com.example.listviewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String>mList;
    private EditText mInput;
    private  ArrayAdapter<String> mAdapter;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_test1);

        mInit();//초기화 작업 수행

        mInput= findViewById(R.id.et_newitem);
    }

    private void mInit(){

        mInitData();
        mInitAdapterView();
    }

    private void mInitData(){
        mList = new ArrayList<String>();

        mList.add("Apple pie");
        mList.add("Banana Bread");
        mList.add("Cupcake");
        mList.add("Donut");
        mList.add("Eclair");
        mList.add("Froyo");
        mList.add("Gingerbread");
        mList.add("Honeycomb");
        mList.add("Icecream sandwich");
        mList.add("Jelly Bean");
        mList.add("KitKat");
        mList.add("Lollipop");
        mList.add("Nougat");
        mList.add("Oreo");
        mList.add("Pie");
    }

    void mInitAdapterView(){
        //어댑터 준비
        mAdapter= new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_checked,
                mList
        );

        mListView =findViewById(R.id.listview);
        mListView.setAdapter(mAdapter);
/*
        //이벤트 연결
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String msg = "Select Item = " + mList.get(position);
                Toast.makeText(MainActivity.this,msg,Toast.LENGTH_SHORT).show();
            }
        });
*/
        //항목선택모드
        //lv.setChoiceMode(ListView.CHOICE_MODE_NONE);->선택 일어나지 않음
        mListView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);//->하나만 선택
        //lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);//다중선택

    //    lv.setDividerHeight(10);//구분선 두꺼워짐
    }

    public  void mOnclick(View v){
        switch (v.getId()){
            case R.id.b_add:
                String text = mInput.getText().toString();
                if(text.length() !=0){
                    mList.add(text);
                    mInput.setText("");
                    mAdapter.notifyDataSetChanged();
                }
                break;

            case R.id.b_delete:
                int pos = mListView.getCheckedItemPosition();
                if(pos!= ListView.INVALID_POSITION){
                    mList.remove(pos);
                    mListView.clearChoices();
                    mAdapter.notifyDataSetChanged();//없으면 화면 갱신이 되지 않아 잔상 남아 강제중단
                }
                break;
        }
    }
}
