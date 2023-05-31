package com.SmyJnd.safetynet;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class HeartRateView extends View {

    private int heartRate = 0;
    private Paint paint;

    public HeartRateView(Context context) {
        super(context);
        init();
    }

    public HeartRateView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public HeartRateView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);
        paint.setColor(Color.BLUE);
    }

    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        int radius = getWidth() / 2 - 10;

        // Draw the circle
        canvas.drawCircle(centerX, centerY, radius, paint);

        // Draw the heart rate text
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(48);
        canvas.drawText(Integer.toString(heartRate), centerX, centerY, paint);
    }
}
