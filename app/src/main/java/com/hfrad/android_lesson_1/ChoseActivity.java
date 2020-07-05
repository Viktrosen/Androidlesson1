package com.hfrad.android_lesson_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

public class ChoseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chose_layout);
        Button backButton = findViewById(R.id.button2);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int temperature = (int)(Math.random()*20);
                Spinner spinner = findViewById(R.id.spinner2);
                String city = String.valueOf(spinner.getSelectedItem());
                Intent intent = new Intent(ChoseActivity.this,MainActivity.class);
                intent.putExtra("City",city);
                intent.putExtra("Temperature","+"+Integer.toString(temperature));
                startActivity(intent);
                finish();
            }
        });

    }
}
