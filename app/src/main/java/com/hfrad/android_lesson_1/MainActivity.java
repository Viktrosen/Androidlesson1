package com.hfrad.android_lesson_1;


import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle!= null && bundle.getInt("DarkTheme")!=0){
            setTheme(R.style.AppDarkTheme);
        }
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppDarkTheme);
        setContentView(R.layout.activity_main);

        String[] data = getResources().getStringArray(R.array.weekdays);
        TextView day = findViewById(R.id.textView2);
        day.setText(data[0]);

        for (int i = 0; i < data.length-1; i++) {
            data[i]=data[i+1];
        }

        for (int i = 0; i < data.length; i++) {
            data[i] = data[i]+"  +"+Integer.toString((int)(Math.random()*20));
        }


        initRecyclerView(data);

        String instanceState;
        if (savedInstanceState == null){
            instanceState = "Первый запуск!";
        }
        else{
            instanceState = "Повторный запуск!";
        }
        Toast.makeText(getApplicationContext(), instanceState + " - onCreate()", Toast.LENGTH_SHORT).show();
        Log.d("INFO","onCreate()");
        Button changeActivity = findViewById(R.id.button);
        Button goToBrowser = findViewById(R.id.button3);
        changeActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ChoseActivity.class);
                startActivity(intent);
            }
        });


        final TextView textView = findViewById(R.id.textView3);
        TextView textView1 = findViewById(R.id.textTemperature);

        String city  = bundle.getString("City"); // получить данные из Intent
        String temperature = bundle.getString("Temperature");
        textView.setText(city);
        textView1.setText(temperature);

        goToBrowser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://ru.wikipedia.org/wiki/"+textView.getText();
                        Uri uri = Uri.parse(url);
                Intent browser = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(browser);
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(), "onStart()", Toast.LENGTH_SHORT).show();
        Log.d("INFO","onStart()");
    }

    @Override
    protected void onRestoreInstanceState(Bundle saveInstanceState){
        super.onRestoreInstanceState(saveInstanceState);
        Toast.makeText(getApplicationContext(), "Повторный запуск!! - onRestoreInstanceState()", Toast.LENGTH_SHORT).show();
        Log.d("INFO","onRestoreInstanceState()");
        String temperature = saveInstanceState.getString("temperature");
        TextView txView = findViewById(R.id.textTemperature);
        txView.setText(temperature);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(), "onResume()", Toast.LENGTH_SHORT).show();
        Log.d("INFO","onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(), "onPause()", Toast.LENGTH_SHORT).show();
        Log.d("INFO","onPause()");




    }

    @Override
    protected void onSaveInstanceState(Bundle saveInstanceState){
        super.onSaveInstanceState(saveInstanceState);
        Toast.makeText(getApplicationContext(), "onSaveInstanceState()", Toast.LENGTH_SHORT).show();
        Log.d("INFO","onSaveInstanceState()");
        if (saveInstanceState!=null){
        saveInstanceState.putString("temperature", "+21");}
        else {
        TextView txView = findViewById(R.id.textTemperature);
        saveInstanceState.putString("temperature", txView.getText().toString());}
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(), "onStop()", Toast.LENGTH_SHORT).show();
        Log.d("INFO","onStop()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(), "onRestart()", Toast.LENGTH_SHORT).show();
        Log.d("INFO","onRestart()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "onDestroy()", Toast.LENGTH_SHORT).show();
        Log.d("INFO","onDestroy()");
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void initRecyclerView(String[] data){
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        DividerItemDecoration itemDecoration = new DividerItemDecoration(this,  LinearLayoutManager.VERTICAL);
        itemDecoration.setDrawable(getDrawable(R.drawable.separator));
        recyclerView.addItemDecoration(itemDecoration);


        // Эта установка служит для повышения производительности системы
        recyclerView.setHasFixedSize(true);

        // Будем работать со встроенным менеджером
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // Установим адаптер
        SocnetAdapter adapter = new SocnetAdapter(data);
        recyclerView.setAdapter(adapter);
    }


}

