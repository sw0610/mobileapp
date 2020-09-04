package com.example.final_1_20181006;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<SiteInfo> mData=new ArrayList<SiteInfo>();
    BaseAdapter_final mAdapter=null;
    ListView mListView=null;
    TextView mSitename;
    TextView mURL;
    TextView mUser;

    int pos;
    SharedPreferences mPref;
    static final String mFILENAME = "MyContacts";



    final static int ACTIVITY_ADD = 10;
    final static int ACTIVITY_EDIT = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.button_layout);

        mPref = getSharedPreferences(mFILENAME,Context.MODE_PRIVATE);

        int maxId = mPref.getInt("maxId",0);
        String str = "";


       for(int i=0;i<mData.size();i++){
           String site=mPref.getString("site name"+ i,"");
           if(site.length()==0)continue;

           String url=mPref.getString("URL"+ i,"");
           if(url.length()==0)continue;

           String user=mPref.getString("user"+ i,"");
           if(user.length()==0)continue;

           String pass=mPref.getString("password"+ i,"");
           if(pass.length()==0)continue;
           SiteInfo si = new SiteInfo();

           si.site_name=mSitename.getText().toString();
           si.URL=mURL.getText().toString();
           si.user_account=mUser.getText().toString();

           mData.add(si);

       }
        mListView=(ListView)findViewById(R.id.lt_listview);
        mAdapter = new BaseAdapter_final(this,mData);
        mListView.setAdapter(mAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String pa= mData.get(position).password;

                Toast.makeText(MainActivity.this, pa, Toast.LENGTH_SHORT).show();
            }
        });

          mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, final View view, final int position, long id) {


                DialogInterface.OnClickListener mDlgListener =new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        switch (which){
                            case 0:
                                Intent intent = new Intent(getApplicationContext(),EditActivity.class);

                                String s=mData.get(position).site_name.toString();
                                String url=mData.get(position).URL.toString();
                                String useraccount=mData.get(position).user_account.toString();

                                intent.putExtra("t_site",s);
                                intent.putExtra("t_URL",url);
                                intent.putExtra("t_username",useraccount);

                                startActivityForResult(intent, ACTIVITY_EDIT);

                                pos=position;
                                break;

                            case 1:
                                mAdapter.delete(position);


                                break;

                            case AlertDialog.BUTTON_NEGATIVE:
                                break;
                        }
                    }
                };

                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("이 사이트에 대해")
                        .setIcon(R.drawable.ic_launcher)
                        .setItems(new String[]{"수정하기", "삭제하기"},mDlgListener)
                        .setNegativeButton("취소",mDlgListener)
                        .show();
                return true;
            }

        });



    }



    public void mOnClick(View v){

        switch (v.getId()){
            case R.id.b_new:
                Intent intent = new Intent(this,EditActivity.class);
                startActivityForResult(intent, ACTIVITY_ADD);
                break;

            case R.id.b_end:
                finish();
                break;

        }
    }

    protected void onActivityResult (int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case ACTIVITY_ADD:
                if (resultCode == RESULT_OK) {

                    String s = data.getStringExtra("sitename");
                    String url = data.getStringExtra("URL");
                    String us = data.getStringExtra("useraccount");
                    String pw = data.getStringExtra("password");

                    SiteInfo addData = new SiteInfo();

                    addData.site_name = s;
                    addData.URL = url;
                    addData.user_account = us;
                    addData.password = pw;

                    mAdapter.add(mData.size(), addData);

                    SharedPreferences.Editor editor = mPref.edit();

                    int maxId = mPref.getInt("maxId", 0) + 1;

                    editor.putString("site name" + maxId, s);
                    editor.putString("URL" + maxId, url);
                    editor.putString("user accout" + maxId, us);
                    editor.putString("password" + maxId, pw);
                    editor.putInt("maxId", maxId);
                    editor.commit();
                }

            case ACTIVITY_EDIT:
                if (resultCode == RESULT_OK) {


                    String s = data.getStringExtra("sitename");
                    String url = data.getStringExtra("URL");
                    String us = data.getStringExtra("useraccount");
                    String pw = data.getStringExtra("password");



                    SiteInfo addData = new SiteInfo();

                    addData.site_name = s;
                    addData.URL = url;
                    addData.user_account = us;
                    addData.password = pw;

                    mAdapter.edit(pos,addData);





                }
                break;


        }

        }




}
