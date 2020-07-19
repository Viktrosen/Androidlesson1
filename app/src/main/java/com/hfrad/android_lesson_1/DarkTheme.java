package com.hfrad.android_lesson_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class DarkTheme extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        /*Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle!= null && bundle.getInt("DarkTheme")!=0){
            setTheme(bundle.getInt("DarkTheme"));
            setContentView(R.layout.setting_layout);
        }else {
        setContentView(R.layout.setting_layout);}*/
        setTheme(R.style.AppDarkTheme);
        setContentView(R.layout.setting_layout);
        Button back = findViewById(R.id.button4);
        final Switch switchDark = (Switch) findViewById(R.id.switch1);
        switchDark.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    Intent intent = new Intent();
                    intent.putExtra("DarkTheme", R.style.AppDarkTheme);
                    Toast.makeText(getApplicationContext(), "Переключатель нажат", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent();
                    intent.putExtra("DarkTheme", R.style.AppTheme);
                    Toast.makeText(getApplicationContext(), "Переключатель выключен", Toast.LENGTH_SHORT).show();
                }

            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


}
