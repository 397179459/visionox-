package com.wang.banche;


import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class zjmActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener,
        ViewPager.OnPageChangeListener {

    private RadioButton rb_rc;
    private RadioButton rb_xc;
    private RadioButton rb_bj;
    private ViewPager vpager;
    private RadioGroup rg_tab_bar;

    private MyFragmentPagerAdapter mAdapter;

    public  static final int PAGE_ONE = 0;
    public  static final int PAGE_TWO = 1;
    public  static final int PAGE_THREE = 2;
    public  static final int PAGE_FOUR = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zjm);
        mAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        bindViews();
        rb_rc.setChecked(true);
    }

    private void bindViews(){
        rb_rc = findViewById(R.id.rc);
        rb_xc = findViewById(R.id.xc);
        rb_bj = findViewById(R.id.bj);
        rg_tab_bar = findViewById(R.id.rg_tab_bar);
        rg_tab_bar.setOnCheckedChangeListener(this);

        vpager = findViewById(R.id.vpager);
        vpager.setAdapter(mAdapter);
        vpager.setCurrentItem(0);
        vpager.addOnPageChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group,int checkedID){
        switch(checkedID){
            case R.id.rc:
                vpager.setCurrentItem(PAGE_ONE);
                break;
            case R.id.xc:
                vpager.setCurrentItem(PAGE_THREE);
                break;
            case R.id.bj:
                vpager.setCurrentItem(PAGE_FOUR);
                break;
        }
    }

    @Override
    public void onPageScrolled(int position,float positionOffset,int positionOffsetPixels){
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state){
        if (state == 2){
            switch (vpager.getCurrentItem()){
                case PAGE_ONE:
                    rb_rc.setChecked(true);
                    break;
                case PAGE_THREE:
                    rb_xc.setChecked(true);
                    break;
                case PAGE_FOUR:
                    rb_bj.setChecked(true);
                    break;
            }
        }
    }
    //显示菜单栏
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }
    //重写菜单点击事件
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.didi:
                PackageManager packageManager = this.getPackageManager();
                if (checkPackInfo("com.sdu.didi.psnger")) {
                    Intent intent = packageManager.getLaunchIntentForPackage("com.sdu.didi.psnger");
                    startActivity(intent);
                } else {
                    Toast.makeText(zjmActivity.this, "您尚未安装滴滴出行", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.fq:
                Toast toast = Toast.makeText(getApplicationContext(), "这个选项是纪念已经凉透了的番茄，就不浪费你的内存了", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                break;
            case R.id.dt:
                PackageManager packageManager1 = this.getPackageManager();
                if (checkPackInfo("com.baidu.BaiduMap")) {
                    Intent intent1 = packageManager1.getLaunchIntentForPackage("com.baidu.BaiduMap");
                    startActivity(intent1);
                } else {
                    Toast.makeText(zjmActivity.this, "您尚未安装百度地图", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.mt:
                PackageManager packageManager2 = this.getPackageManager();
                if (checkPackInfo("com.sankuai.meituan")) {
                    Intent intent2 = packageManager2.getLaunchIntentForPackage("com.sankuai.meituan");
                    startActivity(intent2);
                } else {
                    Toast.makeText(zjmActivity.this, "您尚未安装美团", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.lx:
                AlertDialog.Builder builder = new AlertDialog.Builder(zjmActivity.this);
                builder.setView(R.layout.tucao);
                builder.show();
                break;
        }
        return true;}
        private boolean checkPackInfo(String packname) {
            PackageInfo packageInfo = null;
            try {
                packageInfo = getPackageManager().getPackageInfo(packname, 0);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
            return packageInfo != null;
        }

    }

