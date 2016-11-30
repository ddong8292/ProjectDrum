package com.example.pch.projectdrum;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.BitmapDrawable;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;


public class MyView extends View {
    String TAG;
    Paint paint;

    Bitmap drum1, drum2, drum3, drum4, drum5, drum6, drum7, drum8;


    int width;
    int height;

    HitTest hitTest;
    Region region1, region2, region3, region4, region5, region6, region7, region8;
    int count;

    float drum1_x, drum1_y;
    float drum2_x, drum2_y;
    float drum3_x, drum3_y;
    float drum4_x, drum4_y;
    float drum5_x, drum5_y;
    float drum6_x, drum6_y;
    float drum7_x, drum7_y;
    float drum8_x, drum8_y;

    boolean flag = false;

    MainActivity mainActivity;

    public MyView(Context context, MainActivity mainActivity) {
        super(context);
        this.mainActivity = mainActivity;
        TAG = this.getClass().getName();
        DisplayMetrics display = mainActivity.getResources().getDisplayMetrics();

        hitTest = new HitTest();

        width = display.widthPixels;
        height = display.heightPixels;


        Log.d(TAG, "width 는" + width + " , height 는" + height);

        init();

    }

    public void init() {

        paint = new Paint();

        this.setBackgroundColor(Color.WHITE);

        drum1 = BitmapFactory.decodeResource(getResources(), R.drawable.circle);
        drum1_x = width * (0.5f) - drum1.getWidth() / 2;
        drum1_y = height * (0.5f) + drum1.getHeight() / 2;
        region1 = new Region();
        region1 = hitTest.getBitmapRegion(drum1, (int) drum1_x, (int) drum1_y);

        drum2 = BitmapFactory.decodeResource(getResources(), R.drawable.circle);
        drum2_x = width * (0.4f) - drum2.getWidth() / 2;
        drum2_y = height * (0.42f);
        region2 = new Region();
        region2 = hitTest.getBitmapRegion(drum2, (int) drum2_x, (int) drum2_y);

        drum3 = BitmapFactory.decodeResource(getResources(), R.drawable.circle);
        drum3_x = width * (0.6f) - drum3.getWidth() / 2;
        drum3_y = height * (0.42f);
        region3 = new Region();
        region3 = hitTest.getBitmapRegion(drum3, (int) drum3_x, (int) drum3_y);

        drum4 = BitmapFactory.decodeResource(getResources(), R.drawable.circle);
        drum4_x = width * (0.58f) - drum4.getWidth() / 2;
        drum4_y = height * (0.1f);
        region4 = new Region();
        region4 = hitTest.getBitmapRegion(drum4, (int) drum4_x, (int) drum4_y);

        drum5 = BitmapFactory.decodeResource(getResources(), R.drawable.circle);
        drum5_x = width * (0.42f) - drum5.getWidth() / 2;
        drum5_y = height * (0.1f);
        region5 = new Region();
        region5 = hitTest.getBitmapRegion(drum5, (int) drum5_x, (int) drum5_y);

        drum6 = BitmapFactory.decodeResource(getResources(), R.drawable.circle);
        drum6_x = width * (0.2f) - drum6.getWidth() / 2;
        drum6_y = height * (0.03f);
        region6 = new Region();
        region6 = hitTest.getBitmapRegion(drum6, (int) drum6_x, (int) drum6_y);

        drum7 = BitmapFactory.decodeResource(getResources(), R.drawable.circle);
        drum7_x = width * (0.8f) - drum7.getWidth() / 2;
        drum7_y = height * (0.03f);
        region7 = new Region();
        region7 = hitTest.getBitmapRegion(drum7, (int) drum7_x, (int) drum7_y);

        drum8 = BitmapFactory.decodeResource(getResources(), R.drawable.circle);
        drum8_x = width * (0.15f) - drum8.getWidth() / 2;
        drum8_y = height * (0.3f);
        region8 = new Region();
        region8 = hitTest.getBitmapRegion(drum8, (int) drum8_x, (int) drum8_y);


    }

    @Override
    protected void onDraw(Canvas canvas) {
        /*Log.d( TAG, "높이 : "+height+", 넓이 : "+width);*/

        paint = new Paint();
        canvas.drawBitmap(drum1, width * (0.5f) - drum1.getWidth() / 2, height * (0.5f) + drum1.getHeight() / 2, null);
        canvas.drawBitmap(drum2, width * (0.4f) - drum2.getWidth() / 2, height * (0.42f), null);
        canvas.drawBitmap(drum3, width * (0.6f) - drum3.getWidth() / 2, height * (0.42f), null);
        canvas.drawBitmap(drum4, width * (0.58f) - drum4.getWidth() / 2, height * (0.1f), null);
        canvas.drawBitmap(drum5, width * (0.42f) - drum5.getWidth() / 2, height * (0.1f), null);
        canvas.drawBitmap(drum6, width * (0.2f) - drum6.getWidth() / 2, height * (0.03f), null);
        canvas.drawBitmap(drum7, width * (0.8f) - drum7.getWidth() / 2, height * (0.03f), null);
        canvas.drawBitmap(drum8, width * (0.15f) - drum8.getWidth() / 2, height * (0.3f), null);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int x = (int) event.getX();
        int y = (int) event.getY();


        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:

                /*Log.d( TAG, "x : "+x+", y : "+y);*/
            {


                if (hitTest.isHit(x, y, region1)) {
                    count++;

                    Log.d(TAG, "1번 닿았다");

                } else if (hitTest.isHit(x, y, region2)) {
                    count++;

                    Log.d(TAG, "2번 닿았다");
                } else if (hitTest.isHit(x, y, region3)) {
                    count++;

                    Log.d(TAG, "3번 닿았다");
                } else if (hitTest.isHit(x, y, region4)) {
                    count++;

                    Log.d(TAG, "4번 닿았다");
                } else if (hitTest.isHit(x, y, region5)) {
                    count++;

                    Log.d(TAG, "5번 닿았다");
                } else if (hitTest.isHit(x, y, region6)) {
                    count++;

                    Log.d(TAG, "6번 닿았다");
                } else if (hitTest.isHit(x, y, region7)) {
                    count++;

                    Log.d(TAG, "7번 닿았다");
                } else if (hitTest.isHit(x, y, region8)) {
                    count++;

                    Log.d(TAG, "8번 닿았다");
                }

            }


            case MotionEvent.ACTION_MOVE: {
                    /*Log.d(TAG, "x : " + x + ", y : " + y);*/


                if (hitTest.isHit(x, y, region1)) {

                    count++;

                    Log.d(TAG, "1번 닿았다");

                } else if (hitTest.isHit(x, y, region2)) {
                    count++;

                    Log.d(TAG, "2번 닿았다");
                } else if (hitTest.isHit(x, y, region3)) {
                    count++;

                    Log.d(TAG, "3번 닿았다");
                } else if (hitTest.isHit(x, y, region4)) {
                    count++;

                    Log.d(TAG, "4번 닿았다");
                } else if (hitTest.isHit(x, y, region5)) {
                    count++;

                    Log.d(TAG, "5번 닿았다");
                } else if (hitTest.isHit(x, y, region6)) {
                    count++;

                    Log.d(TAG, "6번 닿았다");
                } else if (hitTest.isHit(x, y, region7)) {
                    count++;

                    Log.d(TAG, "7번 닿았다");
                } else if (hitTest.isHit(x, y, region8)) {
                    count++;

                    Log.d(TAG, "8번 닿았다");
                }

            }
            break;

            case MotionEvent.ACTION_UP:

                break;

            case MotionEvent.ACTION_CANCEL:

                break;
            case MotionEvent.ACTION_OUTSIDE:
                break;
        }


        return true;

    }
}
