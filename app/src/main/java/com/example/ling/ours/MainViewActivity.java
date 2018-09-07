package com.example.ling.ours;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.example.ling.adapter.TimeFragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/24 0024.
 */

public class MainViewActivity extends AppCompatActivity {

    private static  final  int SHOW_YOU = 0;
    private static  final  int SHOW_ME = 1;
    private static  final  int SHOW_OUR = 2;

    private static  final  int SHOW_PAST = 3;
    private static  final  int SHOW_NOW = 4;
    private static  final  int SHOW_FUTURE = 5;

    private final static int MIN_MOVE = 200;   //最小距离

    private MyGestureListener mgListener;
    private GestureDetector mDetector;

    private ViewFlipper viewFlipper;
    private ViewPager   viewpager1;
    private TimeFragmentPagerAdapter ViewPagerAdapter;
    private Button      you_button,me_button,our_button;
    private TextView    past_text,now_text,future_text;
    private int         show_who,show_time;             //现在显示的是谁  ， 现在显示的事件段 默认显示 你 ，过去
    private List<ImageView> imageViews = new ArrayList<ImageView>();
    private Resources       appResources;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainview);
        bindview();
        bindlisenter();
        init();
    }

    /**
     * 初始化数据
     */
    private void init() {
        show_who = SHOW_OUR;
        show_time = SHOW_PAST;

        mgListener = new MyGestureListener();
        mDetector = new GestureDetector(this, mgListener);

        initFragment();
        initFlipper();
    }

    private void initFlipper() {
        appResources = MainViewActivity.this.getResources();

        for (int i = 0; i < 3; i++){
            ImageView imageView = new ImageView(MainViewActivity.this);
            int resourcesid = appResources.getIdentifier("ic_your"+i,"mipmap",MainViewActivity.this.getPackageName());
            imageView.setBackgroundResource(resourcesid);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            viewFlipper.addView(imageView);
        }
        viewFlipper.startFlipping();
    }

    private void initFragment() {
        ViewPagerAdapter = new TimeFragmentPagerAdapter(getSupportFragmentManager());
        ViewPagerAdapter.addFragment(new PastFragment());
        ViewPagerAdapter.addFragment(new NowFragment());
        ViewPagerAdapter.addFragment(new FutureFragment());
        viewpager1.setAdapter(ViewPagerAdapter);
    }

    /**
     * 根据当前显示信息 刷新显示
     */
    private void reflashshow(){

    }
    /**
     * 绑定监听事件
     */
    private void bindlisenter() {
        you_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        me_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        our_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        past_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        now_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        future_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        viewFlipper.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                mDetector.onTouchEvent(motionEvent);
                return true;
            }
        });
        viewFlipper.setAutoStart(true);
        viewFlipper.showContextMenu();
    }

    /**
     * 绑定视图
     */
    private void bindview() {
        you_button = (Button)this.findViewById(R.id.you_button);
        me_button = (Button)this.findViewById(R.id.me_button);
        our_button = (Button)this.findViewById(R.id.our_button);

        past_text = (TextView) this.findViewById(R.id.past_text);
        now_text = (TextView)this.findViewById(R.id.now_text);
        future_text = (TextView)this.findViewById(R.id.future_text);

        viewFlipper = (ViewFlipper) this.findViewById(R.id.ViewFlipper1);
        viewpager1 = (ViewPager) this.findViewById(R.id.viewpager1);

    }

    /**
     * 菜单创建
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * 菜单监听
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    private class MyGestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float v, float v1) {
            if(e1.getX() - e2.getX() > MIN_MOVE){

                viewFlipper.setInAnimation(MainViewActivity.this,R.anim.right_in);
                viewFlipper.setOutAnimation(MainViewActivity.this, R.anim.right_out);
                viewFlipper.showNext();
            }else if(e2.getX() - e1.getX() > MIN_MOVE){

                viewFlipper.setInAnimation(MainViewActivity.this,R.anim.left_in);
                viewFlipper.setOutAnimation(MainViewActivity.this, R.anim.left_out);
                viewFlipper.showPrevious();
            }
            return true;
        }
    }
}
