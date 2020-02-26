# Color-Picker
A lightweight,simple,dynamic color picker library for Android

1.0.1

Implementation

[![](https://jitpack.io/v/metahex/Color-Picker.svg)](https://jitpack.io/#metahex/Color-Picker)

`implementation 'com.github.metahex:Color-Picker:1.0.1'`

Screenshot:
<a>
<img src="https://github.com/metahex/Color-Picker/blob/master/ss1.png" width="140" height="250"/>

<img src="https://github.com/metahex/Color-Picker/blob/master/ss2.png" width="140" height="250"/>

<img src="https://github.com/metahex/Color-Picker/blob/master/ss3.png" width="140" height="250"/>
</a>
Usage

`
        final ColorPickerDialog colorPickerDialog = new ColorPickerDialog(this);

        colorPickerDialog.addColors(colors16);

        colorPickerDialog.setBackgroundColor(Color.parseColor("#ffffff"));
        
        colorPickerDialog.setHeaderColor(Color.parseColor("#000000"));
        
        ...
        //Look for other customization functions in the class
        
        colorPickerDialog.setColorChooserListener(new ColorChooserListener() {
            @Override
            public void onColorChose(int color) {
                //Do something with the chosen color
            }
        });
        `
