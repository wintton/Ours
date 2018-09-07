package com.example.ling.ours;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

import java.util.ArrayList;

public class RainHeart extends BaseView{
        private ArrayList<RainLine> rainLines;
        private static final int RAIN_COUNT = 20; //雨点个数
        private Paint paint;
        private Bitmap      heartbitmap;
        private Context   mContext;

    public RainHeart(Context context) {
        super(context);
        this.mContext = context;
    }

    public RainHeart(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
    }

    @Override
        protected void init() {
            super.init();
            rainLines = new ArrayList<RainLine>();
            for (int i = 0; i < RAIN_COUNT; i++) {
                rainLines.add(new RainLine(windowWidth, windowHeight));
            }

            Drawable drawable =  getContext().getResources().getDrawable(R.mipmap.ic_yl_heart);
            BitmapDrawable drawable1 = (BitmapDrawable)drawable;
            heartbitmap = drawable1.getBitmap();

            paint = new Paint();
            if (paint !=null) {
                paint.setColor(Color.BLACK); //白色
            }
        }

        @Override
        protected void drawSub(Canvas canvas) {
            for(RainLine rainLine : rainLines) {
//                canvas.drawLine(rainLine.getStartX(), rainLine.getStartY(), rainLine.getStopX(), rainLine.getStopY(), paint);
                canvas.drawBitmap(heartbitmap,rainLine.getStartX(),rainLine.getStartY(),paint);

            }
        }

        /**
         * 动画逻辑处理
         */
        @Override
        protected void animLogic() {
            for(RainLine rainLine : rainLines) {
                rainLine.rain();
            }
        }

        @Override
            protected boolean needStopAnimThread() {
            for(RainLine rainLine : rainLines) {
                if (rainLine.getStartY() >= windowHeight || rainLine.getStartX() >= windowWidth) {
                    rainLine.resetRandom();
                }
            }
            return false;
        }

    @Override
    protected void onAnimEnd() {
//        rainLines = null;
    }
}