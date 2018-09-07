package com.example.ling.ours;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.CalendarView;

import java.util.Date;

/**
 * Created by Administrator on 2018/9/6 0006.
 */

public class RemberActivity extends Activity {

    private CalendarView calendarView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rem);
        bindViews();
        bindListener();
        init();
    }

    private void bindListener() {
        calendarView2.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {

            }
        });
    }

    private void init() {
        Date date = new Date();
        calendarView2.setDate(date.getTime());
    }

    private void bindViews() {
        calendarView2 = (CalendarView)this.findViewById(R.id.calendarView2);
    }
}
