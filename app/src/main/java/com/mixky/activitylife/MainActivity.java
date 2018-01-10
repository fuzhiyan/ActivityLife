package com.mixky.activitylife;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.mixky.activitylife.view.AdImageView;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String TAG = "MainActivity";
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //C.沉浸式状态栏,不用我们写,直接拷贝代码即可,必须放在加载布局前调用
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            //设置头部状态栏为透明的,如此效果就好看了
            window.setStatusBarColor(Color.TRANSPARENT);
            //设置底部为透明的
//            window.setNavigationBarColor(Color.TRANSPARENT);
        }
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        List<String> mockDatas = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            mockDatas.add(i + "");
        }

        recyclerView.setLayoutManager(linearLayoutManager = new LinearLayoutManager(this));

        recyclerView.setAdapter(new CommonAdapter<String>(MainActivity.this,
                R.layout.item,
                mockDatas) {
            @Override
            protected void convert(ViewHolder holder, String o, int position) {
                if (position > 0 && position % 7 == 0) {
                    holder.setVisible(R.id.id_tv_title, false);
                    holder.setVisible(R.id.id_tv_desc, false);
                    holder.setVisible(R.id.imageView, true);
                } else {
                    holder.setVisible(R.id.id_tv_title, true);
                    holder.setVisible(R.id.id_tv_desc, true);
                    holder.setVisible(R.id.imageView, false);
                }
            }
        });

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                int fPos = linearLayoutManager.findFirstVisibleItemPosition();
                int lPos = linearLayoutManager.findLastCompletelyVisibleItemPosition();
                for (int i = fPos; i <= lPos; i++) {
                    View view = linearLayoutManager.findViewByPosition(i);
                    AdImageView adImageView = view.findViewById(R.id.imageView);
                    if (adImageView.getVisibility() == View.VISIBLE) {
                        adImageView.setDx(linearLayoutManager.getHeight() - view.getTop());
                    }
                }
            }
        });
        Log.d(TAG, "MainActivity创建");
        Log.d(TAG, "-----onCreate()");

    }

    @Override
    protected void onStart() {
        super.onStart();
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
        Log.d(TAG, "-----onDestroy()");
        Log.d(TAG, "愿你走出半生，归来仍是少年！！！");
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Log.d(TAG, "按下返回键退回到桌面时");
        return super.onKeyDown(keyCode, event);
    }
}
