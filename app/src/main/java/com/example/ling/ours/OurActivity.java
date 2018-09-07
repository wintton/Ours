package com.example.ling.ours;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2018/8/17 0017.
 */

public class OurActivity extends AppCompatActivity {

    private TextView txt_min,txt_hour,txt_month,txt_id,txt_day,txt_mill;
    private RelativeLayout page_rl;
    private Timer   mTimer = new Timer();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_our);
        bindViews();
        init();

    }

    private void init() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR,2018);
        calendar.set(Calendar.MONTH,6);
        calendar.set(Calendar.DAY_OF_MONTH,26);
        int days =  (int) ((System.currentTimeMillis() - calendar.getTimeInMillis()) / (60l * 60 * 24 * 1000));
        txt_id.setText(days + "");
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {

                mHandler.sendEmptyMessage(10);
            }
        },200,100);
    }
    Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message message) {
            Calendar calendar = Calendar.getInstance();
            txt_month.setText((calendar.get(Calendar.MONTH) + 1 )+"");
            txt_day.setText(calendar.get(Calendar.DAY_OF_MONTH) + "");
            txt_hour.setText(calendar.get(Calendar.HOUR_OF_DAY) + "");
            txt_min.setText(calendar.get(Calendar.MINUTE) + "");
            txt_mill.setText(calendar.get(Calendar.SECOND)  + "");
            return false;
        }
    });
    private void bindViews() {
        txt_min = (TextView)this.findViewById(R.id.txt_min);
        txt_hour = (TextView)this.findViewById(R.id.txt_hour);
        txt_month = (TextView)this.findViewById(R.id.txt_month);
        txt_day = (TextView)this.findViewById(R.id.txt_day);
        txt_id = (TextView)this.findViewById(R.id.txt_id);
        txt_mill = (TextView)this.findViewById(R.id.txt_mill);

        page_rl = (RelativeLayout)this.findViewById(R.id.page_rl);
    }
    public  void GoRember(View view){
        OpenActivity(RemberActivity.class);
    }
    public  void GoCare(View view){
        OpenActivity(CareActivity.class);
    }
    public  void GoWrite(View view){
        OpenActivity(WriteActivity.class);
    }
    public  void GoGo(View view){
        OpenActivity(GoActivity.class);
    }
    public  void GoPlay(View view){
        OpenActivity(PlayActivity.class);
    }
    public  void GoEat(View view){
        OpenActivity(EatActivity.class);
    }
    public  void ShowUs(View view){
        page_rl.setBackgroundResource(R.mipmap.ic_us_png);
    }
    public  void ShowNi(View view){
        page_rl.setBackgroundResource(R.mipmap.ic_you);
    }
    public  void ShowMe(View view){
        page_rl.setBackgroundResource(R.mipmap.ic_me1);
    }
    private void OpenActivity(Class open){
        Intent intent = new Intent(OurActivity.this,open);
        startActivity(intent);
    }
}
