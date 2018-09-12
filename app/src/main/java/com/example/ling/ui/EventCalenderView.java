package com.example.ling.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.CalendarView;

/**
 * Created by Administrator on 2018/9/7 0007.
 */

public class EventCalenderView extends CalendarView {

    public EventCalenderView(@NonNull Context context) {
        super(context);
    }
    public EventCalenderView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    public EventCalenderView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint p = new Paint();

        p.setColor(Color.RED);
        p.setStrokeWidth(10);

        super.onDraw(canvas);
        canvas.drawRect(0, 0, 100, 100, p);
    }
}
