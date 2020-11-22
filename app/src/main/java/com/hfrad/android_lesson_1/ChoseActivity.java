package com.hfrad.android_lesson_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

public class ChoseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle!= null && bundle.getInt("DarkTheme")!=0){
            setTheme(bundle.getInt("DarkTheme"));
            setContentView(R.layout.chose_layout);
        }else {
            setContentView(R.layout.chose_layout);}*/
        setTheme(R.style.AppDarkTheme);
        setContentView(R.layout.chose_layout);
        Button backButton = findViewById(R.id.button2);
        Button darkTheme = findViewById(R.id.button5);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view,"Хотите покинуть настройки?",Snackbar.LENGTH_LONG).setAction("Да", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int temperature = (int)(Math.random()*20);
                        Spinner spinner = findViewById(R.id.spinner2);
                        TextInputEditText cityInput = findViewById(R.id.enterCity);

                        String city = "";
                        if (String.valueOf(cityInput.getText()).equals("")){
                            city = String.valueOf(spinner.getSelectedItem());}
                        else {city = String.valueOf(cityInput.getText());}
                        Intent intent = new Intent(ChoseActivity.this,MainActivity.class);
                        intent.putExtra("City",city);
                        intent.putExtra("Temperature","+"+Integer.toString(temperature));
                        startActivity(intent);
                        finish();
                    }
                }).show();
            }
        });

        darkTheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChoseActivity.this,DarkTheme.class);
                startActivity(intent);
            }
        });

    }
}
