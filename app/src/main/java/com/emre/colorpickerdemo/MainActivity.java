package com.emre.colorpickerdemo;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.emre.colorpicker.ColorChooserListener;
import com.emre.colorpicker.ColorPickerDialog;

import java.util.Random;

public class MainActivity extends Activity {

    final Random r = new Random();

    final int[] colors16 = {
            Color.rgb(255, 0, 0),
            Color.rgb(0, 255, 0),
            Color.rgb(0, 0, 255),
            Color.rgb(r.nextInt(255), r.nextInt(255), r.nextInt(255)),
            Color.rgb(r.nextInt(255), r.nextInt(255), r.nextInt(255)),
            Color.rgb(r.nextInt(255), r.nextInt(255), r.nextInt(255)),
            Color.rgb(r.nextInt(255), r.nextInt(255), r.nextInt(255)),
            Color.rgb(r.nextInt(255), r.nextInt(255), r.nextInt(255)),
            Color.rgb(r.nextInt(255), r.nextInt(255), r.nextInt(255)),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView clrTv = findViewById(R.id.clrtv);

        final ColorPickerDialog colorPickerDialog = new ColorPickerDialog(this);

        colorPickerDialog.addColors(colors16);

        colorPickerDialog.setBackgroundColor(Color.parseColor("#448aff"));

        colorPickerDialog.setColorChooserListener(new ColorChooserListener() {
            @Override
            public void onColorChose(int color) {
                clrTv.setTextColor(color);
            }
        });

        clrTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                colorPickerDialog.show();
            }
        });
    }
}