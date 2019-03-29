package com.wang.banche;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {
    private Button mbtn;
    private Button mbtn1;
    private TextClock mtc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    //button跳转
    mbtn1=findViewById(R.id.btn1);
    mbtn1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(MainActivity.this,zjmActivity.class);
            startActivity(intent);
        }
    });
    //找到时间控件显示
    mtc=findViewById(R.id.tc);
    mtc.setFormat12Hour("hh:mm");
    //btn提示toast
        mbtn=findViewById(R.id.btn);
        mbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = new Toast(MainActivity.this);
                toast.setGravity(Gravity.CENTER, 0, 0);
                RelativeLayout ll = new RelativeLayout(MainActivity.this);
                ImageView imageView = new ImageView(MainActivity.this);
                imageView.setImageResource(R.drawable.a1);
                ll.addView(imageView);
                TextView textView = new TextView(MainActivity.this);
                textView.setText("     求   求   你   别    混    了    ");
                textView.setTextSize(25);
                ll.addView(textView);
                toast.setView(ll);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.show();

            }
        });
    }

}
