package com.emre.colorpicker;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ColorPickerDialog extends Dialog implements View.OnClickListener {

    private int colorCellRadius = 75;
    private final ArrayList<Integer> colorList = new ArrayList<>();
    private ColorChooserListener colorChooserListener;
    private TextView headerTv;
    private GridLayout clrLayout;
    private LinearLayout layout;

    public ColorPickerDialog(Context context) {
        super(context);
        init();
    }

    public void clear(){
        colorList.clear();
        clrLayout.removeAllViewsInLayout();
    }

    public void setBackgroundColor(int color){
        this.clrLayout.setBackgroundColor(color);
        this.layout.setBackgroundColor(color);
    }

    private void init(){
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.picker_layout);

        layout = findViewById(R.id.mainLayout);
        headerTv = findViewById(R.id.headerTv);
        clrLayout = findViewById(R.id.colorLayout);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        layout.invalidate();
    }

    public void addColor(int color){
        if (!colorList.contains(color)) {
            colorList.add(color);
            final ColorView colorView = generateColorView(color);
            clrLayout.addView(colorView);
        }
    }

    public void addColors(int[] colors){
        for (int c: colors) {
            if (!colorList.contains(c)) {
                ColorView colorView = generateColorView(c);
                colorList.add(c);
                clrLayout.addView(colorView);
            }
        }
    }

    public void addColors(ArrayList<Integer> colors){
        for (int c: colors) {
            if (!colorList.contains(c)) {
                final ColorView colorView = generateColorView(c);
                colorList.add(c);
                clrLayout.addView(colorView);
            }
        }
    }

    public void addColorsArrayList(ArrayList<Color> colors){
        for (int c: ((Integer[]) colors.toArray())) {
            if (!colorList.contains(c)) {
                final ColorView colorView = generateColorView(c);
                colorList.add(c);
                clrLayout.addView(colorView);
            }
        }
    }

    public int getColorCellRadius() {
        return colorCellRadius;
    }

    public void setColorCellRadius(int colorCellRadius) {
        this.colorCellRadius = colorCellRadius;
    }

    public void setColorChooserListener(ColorChooserListener colorChooserListener) {
        this.colorChooserListener = colorChooserListener;
    }

    private ColorView generateColorView(int color){
        GridLayout.LayoutParams param =new GridLayout.LayoutParams();

        param.height = colorCellRadius*2;
        param.width = colorCellRadius*2;
        param.bottomMargin = 20;
        param.setMarginEnd(20);

        ColorView colorView = new ColorView(getContext());
        colorView.setMinimumHeight(50);
        colorView.setMinimumWidth(50);
        colorView.setLayoutParams(param);
        colorView.setId(color);
        colorView.setColor(color);
        colorView.setOnClickListener(this);

        return colorView;
    }

    public void setColumnCount(int size){
        clrLayout.setColumnCount(size);
    }

    public void setHeaderColor(int color){
        if (headerTv != null) {
            headerTv.setTextColor(color);
        }
    }

    public void setHeaderSize(int size){
        if (headerTv != null) {
            headerTv.setTextSize(size);
        }
    }

    public void setHeaderText(String text){
        if (headerTv != null) {
            headerTv.setText(text);
        }
    }

    @Override
    public void onClick(View v) {
        if (colorChooserListener != null){
            colorChooserListener.onColorChose(((ColorView) v).getColor());
        }
    }
}