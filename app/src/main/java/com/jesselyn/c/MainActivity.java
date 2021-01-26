package com.jesselyn.c;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    TextView tv, tvResult;
    EditText fNumber, sNumber;
    Button add, sub, mul, div;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        tv = findViewById(R.id.sample_text);
        tvResult = findViewById(R.id.viewResult);
        fNumber = findViewById(R.id.firstNumber);
        sNumber = findViewById(R.id.secondNumber);
        add = findViewById(R.id.add);
        sub = findViewById(R.id.sub);
        mul = findViewById(R.id.mul);
        div = findViewById(R.id.div);

        tv.setText(stringFromJNI());

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int f = Integer.parseInt(fNumber.getText().toString());
                int s = Integer.parseInt(sNumber.getText().toString());

                int result = addition(f, s);

                tvResult.setText(new Integer(result).toString());
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int f = Integer.parseInt(fNumber.getText().toString());
                int s = Integer.parseInt(sNumber.getText().toString());

                tvResult.setText(new Integer(subtract(f, s)).toString());
            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int f = Integer.parseInt(fNumber.getText().toString());
                int s = Integer.parseInt(sNumber.getText().toString());

                tvResult.setText(new Integer(multiplication(f, s)).toString());
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int f = Integer.parseInt(fNumber.getText().toString());
                int s = Integer.parseInt(sNumber.getText().toString());

                tvResult.setText(new Integer(div(f,s)).toString());
            }
        });
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
    public native int addition(int x, int y);
    public native int subtract(int x, int y);
    public native int div(int x, int y);
    public native int multiplication(int x, int y);
}