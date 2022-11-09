package com.example.darktheme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    RadioGroup themeRadioGroup;
    RadioButton btn_radio_light,btn_radio_dark,btn_radio_device;
    int selectedId;
    Button btnDetail,btn_submit,btn_cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        themeRadioGroup=(RadioGroup) findViewById(R.id.theme_radio_group);
        btn_radio_light=(RadioButton) findViewById(R.id.btn_radio_light);
        btn_radio_dark=(RadioButton) findViewById(R.id.btn_radio_dark);
        btn_radio_device=(RadioButton) findViewById(R.id.btn_radio_device);

        btnDetail=(Button) findViewById(R.id.btnDetail);
        btn_submit=(Button) findViewById(R.id.btn_submit);
        btn_cancel=(Button) findViewById(R.id.btn_cancel);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = themeRadioGroup.getCheckedRadioButtonId(); // Get selected radio button ID
//        final RadioButton selectedRadioButton = (RadioButton).findViewById(selectedId);

                if(selectedId == R.id.btn_radio_light){
                    // Switch to light theme
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                } else if (selectedId == R.id.btn_radio_dark){
                    // Switch to dark theme
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                } else if (selectedId == R.id.btn_radio_device){
                    // Switch to device theme
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
                } else {
                    Toast.makeText(MainActivity.this, "Only three themes allowed: Dark theme, Light theme, Device theme", Toast.LENGTH_SHORT).show();
                }
            }
        });




        btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),TestDetailActivity.class);
                startActivity(i);
            }
        });



    }
}