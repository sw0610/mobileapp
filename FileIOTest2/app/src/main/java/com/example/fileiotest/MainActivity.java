package com.example.fileiotest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private EditText et_name;
    private EditText et_phone;
    private TextView tv_display;

    SharedPreferences mPref;

    static final String mFILENAME = "myContacts.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_name = (EditText) findViewById(R.id.et_name);
        et_phone = (EditText) findViewById(R.id.et_phone);
        tv_display = (TextView) findViewById(R.id.tv_display);

        mPref = getSharedPreferences(mFILENAME, Context.MODE_PRIVATE);

        displayContacts();
    }

    public void mOnInsertClick(View v){
        if(!isExternalStorageWritable())
            return; //외부 메모리를 사용하지 못하면 끝냄

        requestPermission();

        //공용
        File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File f = new File(path, mFILENAME); //경로, 파일명

        //전용
       // File f = new File(getExternalFilesDir(null),mFILENAME);

        FileOutputStream fos = null;
        BufferedOutputStream bos =null;
        DataOutputStream dos = null;

        try{
           // fos = openFileOutput(mFILENAME, Context.MODE_APPEND);
            fos=new FileOutputStream(f, true);
            bos = new BufferedOutputStream(fos);
            dos = new DataOutputStream(bos);

            String name = et_name.getText().toString();
            String phone = et_phone.getText().toString();

            dos.writeUTF(name);
            dos.writeUTF(phone);

            dos.flush();

        }
        catch (FileNotFoundException e) {
            return;
        }
        catch (IOException e) {
        }

        finally {
            try{
                if(dos != null) dos.close();
                if(bos != null) bos.close();
                if(fos != null) fos.close();
            }
            catch (IOException ioe){
            }
        }

        displayContacts();

        et_name.setText("");
        et_phone.setText("");
    }

    public void mOnDeleteClick(View v){
        //공용
        File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File f= new File(path, mFILENAME);

        //전용
       // File f = new File(getExternalFilesDir(null),mFILENAME);

        //  if(deleteFile(mFILENAME))
        if(f.delete())
            tv_display.setText("delete success");
        else
            tv_display.setText("delete failed");
    }

    public void mOnUpdateClick(View v){

    }

    public void displayContacts(){
        if(!isExternalStorageWritable())
            return; //외부 메모리를 사용하지 못하면 끝냄

        requestPermission();

        //공용
        File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File f = new File(path, mFILENAME); //경로, 파일명

        //전용
      //  File f = new File(getExternalFilesDir(null),mFILENAME);

        FileInputStream fis =null;
        BufferedInputStream bis = null;
        DataInputStream dis = null;

        try {
            //fis = openFileInput(mFILENAME);
            fis = new FileInputStream(f);
            bis = new BufferedInputStream(fis);
            dis = new DataInputStream(bis);

            String str = "";
            while (dis.available() > 0) {
                String name = dis.readUTF();
                String phone = dis.readUTF();

                str += name + " | " + phone + "\n";
            }
            tv_display.setText(str);
        }
        catch(FileNotFoundException fnfe){
            return;
        }
        catch (IOException ioe){
        }
        finally {
            try{
                if(dis != null) dis.close();
                if(bis != null) bis.close();
                if(fis != null) fis.close();
            }
            catch (IOException ioe){
            }
        }
    }


    //check if external storage is available for read and write
    public boolean isExternalStorageWritable(){
        String state = Environment.getExternalStorageState();
        if(state.equals(Environment.MEDIA_MOUNTED)){
            Log.i("MainActivity","외부메모리 읽기 쓰기 모두 가능");
            return true;
        }
        return false;
    }

    public void requestPermission(){
        final int REQUEST_EXTERNAL_STOREAGE=1;
        String[] PERMISSIONS_STORAGE = {
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        };

        int permission = ActivityCompat.checkSelfPermission(
                this, Manifest.permission.WRITE_EXTERNAL_STORAGE
        ) ;

        if(permission != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(
                    this, PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STOREAGE
            );
        }
    }
}
