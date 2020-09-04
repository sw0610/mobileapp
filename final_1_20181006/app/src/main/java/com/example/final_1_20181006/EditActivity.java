package com.example.final_1_20181006;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class EditActivity extends AppCompatActivity {

    EditText mEt_site_name;
    EditText mEt_URL;
    EditText mEt_UA;
    EditText mEt_pw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        mEt_site_name=(EditText)findViewById(R.id.et_site_name);
        mEt_URL=(EditText)findViewById(R.id.et_URL);
        mEt_UA=(EditText)findViewById(R.id.et_UA);
        mEt_pw=(EditText)findViewById(R.id.et_pw);

        Intent intent = getIntent();
        String text_site=intent.getStringExtra("t_site");
        String text_URL=intent.getStringExtra("t_URL");
        String text_username=intent.getStringExtra("t_username");
        if(text_site != null){
            mEt_site_name.setText(text_site);
        }
        if(text_URL != null){
            mEt_URL.setText(text_URL);
        }
        if(text_username != null){
            mEt_UA.setText(text_username);
        }
    }

    public void mEditClick(View v){
        switch(v.getId()){
            case R.id.b_add:

                Intent intent=new Intent();
                intent.putExtra("sitename", mEt_site_name.getText().toString());
                intent.putExtra("URL", mEt_URL.getText().toString());
                intent.putExtra("useraccount", mEt_UA.getText().toString());
                intent.putExtra("password", mEt_pw.getText().toString());

                setResult(RESULT_OK,intent);

                finish();

                break;

            case R.id.b_cancle:
                setResult(RESULT_CANCELED);
                finish();
                break;
        }
    }


}
