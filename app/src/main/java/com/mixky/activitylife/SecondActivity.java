package com.mixky.activitylife;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

/**
 * Created by Administrator on 2018/1/5.
 */

public class SecondActivity extends AppCompatActivity {
    private String TAG = "SecondActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.d(TAG, "----onCreate");
        Button button = findViewById(R.id.second_activity_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SecondActivity.this, MainActivity.class));
                Log.d(TAG, "从第二个Activity跳转回MainActivity");
//                finish();
            }
        });
    }

    public void onTest(){
        String Tent;
        int score;
    }

    @Override
    protected void onStart() {
        super.onStart   ();
        Log.d(TAG, "-----onStart()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "-----onPause()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "-----onRestart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "-----onResume()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "-----onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"愿你走出半生，归来仍是少年！！！");
        Log.d(TAG, "-----onDestroy()");
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Log.d(TAG, "第二个Activity按下返回键退回到MainActivity时");
        return super.onKeyDown(keyCode, event);
    }

}
