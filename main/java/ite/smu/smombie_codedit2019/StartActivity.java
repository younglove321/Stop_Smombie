package ite.smu.smombie_codedit2019;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class StartActivity extends AppCompatActivity {
    private CustomAnimationDialog customAnimationDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        setTitle("스몸비");
        initView();

        Handler timer = new Handler();
        timer.postDelayed(new Runnable(){
            public void run(){
                Intent intent = new Intent(StartActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 1500);
    }

    private void initView(){
        customAnimationDialog = new CustomAnimationDialog(StartActivity.this);
        Handler timer = new Handler(); //Handler 생성
        timer.postDelayed(new Runnable(){public void run(){ }}, 2000);
        customAnimationDialog.show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        customAnimationDialog.dismiss();
    }
}
