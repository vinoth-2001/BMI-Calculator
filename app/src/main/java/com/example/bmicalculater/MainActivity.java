package com.example.bmicalculater;


import android.icu.text.DecimalFormat;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.math.BigDecimal;


public class MainActivity extends AppCompatActivity {

    TextView nresult;
    TextView txtresult;
    TextView height;
    TextView weight;
    SeekBar hseekbar, wseekbar;
    Button btn;
    float bmi;
    float h, w;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nresult = findViewById(R.id.result);
        txtresult = findViewById(R.id.rtxt);
        height = findViewById(R.id.htxt);
        weight = findViewById(R.id.wtxt);
        hseekbar = findViewById(R.id.hseekbar);
        wseekbar = findViewById(R.id.wseekbar);
        btn = findViewById(R.id.btn);

        hseekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {

                h = progress;
                height.setText(String.valueOf(h));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        wseekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progres, boolean b) {

                w = progres;
                weight.setText(String.valueOf(w));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bmi = (w/(h*h))*10000;
                nresult.setText(String.format("%.2f",bmi));
                String lbl;

                if (bmi <= 18.5){
                    lbl = getString(R.string.under);
                }
                else if (bmi > 18.6 && bmi <= 24.99){
                    lbl = getString(R.string.normal);
                }
                else if (bmi >=25 && bmi <= 29.99){
                    lbl = getString(R.string.over);
                }
                else {
                    lbl = getString(R.string.obesity);
                }

                txtresult.setText(lbl);



            }
        });
    }

}