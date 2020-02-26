package com.emre.colorpicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class PickerLayout extends LinearLayout {

    private int backgroundColor;
    private final Paint paint = new Paint();

    public PickerLayout(Context context) {
        super(context);
    }

    public PickerLayout(Context context,AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(backgroundColor);

        //canvas.drawPath();
    }
}