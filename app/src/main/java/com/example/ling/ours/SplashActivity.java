package com.example.ling.ours;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;

/**
 * Created by Administrator on 2018/6/24 0024.
 */
public class SplashActivity extends Activity {

    private RelativeLayout MainRelat;
    private List<ImageView>  hearts = new ArrayList<ImageView>();
    private TextView        textView;
    private final Timer  rainhearstimer = new Timer();
    private int         Width;          //屏幕宽度
    private int         Height;         //屏幕高度
    private int         rom;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rainheart);
        init();
        bindViews();
        creattextshowanmi();
        Intent intent = new Intent(this,MusicService.class);
        startService(intent);
    }
    /**
     * 初始化设置
     */
    private void init() {
        WindowManager wm = (WindowManager) this
                .getSystemService(Context.WINDOW_SERVICE);
        Width = wm.getDefaultDisplay().getWidth();
        Height = wm.getDefaultDisplay().getHeight();
    }

    private void creattextshowanmi(){
        AlphaAnimation alphaAnimationdis = new AlphaAnimation(1,0);
       final AlphaAnimation alphaAnimationshow = new AlphaAnimation(0,1);
        alphaAnimationdis.setDuration(2000);
        alphaAnimationshow.setDuration(1000);
        alphaAnimationdis.setRepeatCount(0);
        alphaAnimationshow.setRepeatCount(0);
        alphaAnimationdis.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                textView.setText("还好我没放弃");
                textView.startAnimation(alphaAnimationshow);
                textView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(SplashActivity.this,MainActivity.class);
                        startActivity(intent);
                        overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
                        SplashActivity.this.finish();
                    }
                },1500);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        textView.startAnimation(alphaAnimationdis);
    }

    private void creatrainheart() {
                    ImageView imageView = new ImageView(SplashActivity.this);
                    imageView.setImageResource(R.mipmap.ic_yl_heart);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
                            Dp2Px(SplashActivity.this,40) , Dp2Px(SplashActivity.this,40));
                    layoutParams.topMargin = Dp2Px(SplashActivity.this,20);
                    Random random = new Random();
                    float number = random.nextInt(100);
                    layoutParams.leftMargin = Dp2Px(SplashActivity.this,Width*number/100);
                    MainRelat.addView(imageView);
                    hearts.add(imageView);
                    imageView.layout((int) (Width*number/100f),100,(int) (Width*number/100f),100);
                    StartAnmi(imageView);
    }

    private void StartAnmi(final View imageView){
        TranslateAnimation translateAnimation = new TranslateAnimation(0,0,0,Height);
        translateAnimation.setDuration(3000);
        translateAnimation.setRepeatCount(0);
        translateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }
            @Override
            public void onAnimationEnd(Animation animation) {
                MainRelat.removeView(imageView);
            }
            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        imageView.startAnimation(translateAnimation);
    }
    /**
     * 绑定控件
     */
    private void bindViews() {
        MainRelat = (RelativeLayout)this.findViewById(R.id.relat_main);
        textView = (TextView)this.findViewById(R.id.text_show);

    }

    /**
     * dp 转换为px
     * @param context
     * @param dp
     * @return
     */
    public static int Dp2Px(Context context, float dp) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }
}
