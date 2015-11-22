package com.example.xiezi.prgressbar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by 蝎子莱莱123 on 2015/11/21.
 */
public class RingView extends View {
    private Paint paint;
    private Context context;

    public RingView(Context context) {
        super(context, null);
    }

    public RingView(Context context, AttributeSet attrs) {
        super(context, attrs);

        this.context = context;
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.paint.setStyle(Paint.Style.STROKE);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        // TODO Auto-generated method stub
        int center = getWidth() / 2;
        int innerCircle = dip2px(context, 83); //设置内圆半径
        int ringWidth = dip2px(context, 5); //设置圆环宽度

        //绘制内圆
        this.paint.setARGB(155, 167, 190, 206);
        this.paint.setStrokeWidth(2);
        canvas.drawCircle(center, center, innerCircle, this.paint);

        //绘制圆环
        this.paint.setARGB(255, 212, 225, 233);
        this.paint.setStrokeWidth(ringWidth);
        canvas.drawCircle(center, center, innerCircle + 1 + ringWidth / 2, this.paint);

        //绘制外圆
        this.paint.setARGB(155, 167, 190, 206);
        this.paint.setStrokeWidth(2);
        canvas.drawCircle(center, center, innerCircle + ringWidth, this.paint);


        super.onDraw(canvas);
    }
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
