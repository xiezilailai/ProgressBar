package com.example.xiezi.prgressbar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by 蝎子莱莱123 on 2015/11/21.
 */
public class CircleProgress extends View {

    private CircleThread circleThread;
    private float radius=50;//设置圆的大小
    private float pointx=radius;
    private float pointy=radius;

    private float i=0;
    private float angel=90;
    private float speed=1;



    public void setAngel(float angel) {
        this.angel = angel;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public CircleProgress(Context context,float radius,AttributeSet attrs,float angel,float speed) {
        super(context);
      this.radius=radius;

        this.angel=angel;
        this.speed=speed;
    }
    public CircleProgress(Context context) {
        super(context);
    }

    public CircleProgress(Context context, AttributeSet attrs) {
        super(context, attrs);
        //获取屏幕的宽高
//        WindowManager windowManager=(WindowManager)getContext().getSystemService(Context.WINDOW_SERVICE);
//         width=windowManager.getDefault    Display().getWidth();
//         height=windowManager.getDefaultDisplay().getHeight();
}

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension((int)(radius*2),(int)(radius*2));
    }

    @Override
    public void draw(Canvas canvas) {


        Paint paint=new Paint(Paint.ANTI_ALIAS_FLAG);//锯齿属性
        paint.setColor(Color.GRAY);
        canvas.drawCircle(pointx, pointy, radius, paint);
        paint.setColor(Color.RED);
        RectF f=new RectF(pointx-radius,pointy-radius,pointx+radius,pointy+radius);
        canvas.drawArc(f, -90f, i, true, paint);
        paint.setColor(Color.WHITE);
        canvas.drawCircle(pointx, pointy, 0.8f*radius, paint);
        if(circleThread==null){
            circleThread=new CircleThread();
            circleThread.start();
        }
    }

    private  class CircleThread extends Thread{

        @Override
        public void run() {
            while(!Thread.currentThread().isInterrupted()){
                try {
                    Thread.sleep(5);

                    if(i<angel){
                        i+=speed;
                    }else{
                        i=angel;
                        return;
                    }
                    postInvalidate();


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }
    }

}
