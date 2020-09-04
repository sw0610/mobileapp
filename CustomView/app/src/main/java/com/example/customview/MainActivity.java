package com.example.customview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends Activity {

    ListView mListview = null;
    BaseAdapterEx mAdapter=null;
    ArrayList<Student>mData=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_ex);

        mData=new ArrayList<Student>();

        for (int i=0; i<100; i++){
            Student student=new Student();

            student.mName="슈퍼성근"+i;
            student.mNumber="95000"+i;
            student.mDepartment="컴퓨터공학"+i;

            mData.add(student);
        }

        mAdapter = new BaseAdapterEx(this,mData);

        mListview = (ListView)findViewById(R.id.lt_listveiw);
        mListview.setAdapter(mAdapter);
    }

    public void mOnclick(View v){
        switch (v.getId()){
            case R.id.b_add:
                EditText nameEt = (EditText) findViewById(R.id.et_name);
                EditText numberEt = (EditText) findViewById(R.id.et_number);
                EditText departmentEt = (EditText) findViewById(R.id.et_dept);

                Student addData =new Student();
                addData.mName = nameEt.getText().toString();
                addData.mNumber = numberEt.getText().toString();
                addData.mDepartment = departmentEt.getText().toString();
                mAdapter.add(0,addData);

                nameEt.setText("");
                numberEt.setText("");
                departmentEt.setText("");

                break;

            case R.id.b_del:
                nameEt = (EditText) findViewById(R.id.et_name);
                EditText itemEt = (EditText)findViewById(R.id.et_del);
                mAdapter.delete(Integer.parseInt(itemEt.getText().toString()));
                itemEt.setText("");
                break;


            case R.id.b_all_del:
                mAdapter.clear();
                break;



        }
    }
}
