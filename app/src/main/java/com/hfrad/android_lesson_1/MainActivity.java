package com.hfrad.android_lesson_1;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String instanceState;
        if (savedInstanceState == null){
            instanceState = "Первый запуск!";
        }
        else{
            instanceState = "Повторный запуск!";
        }
        Toast.makeText(getApplicationContext(), instanceState + " - onCreate()", Toast.LENGTH_SHORT).show();
        Log.d("INFO","onCreate()");
        final TextView textTemperature = findViewById(R.id.textTemperature); // Текст
        final MainPresenter presenter = MainPresenter.getInstance();
        // Получить презентер
        textTemperature.setText((presenter.getTemperature()));
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
        String textViewText= saveInstanceState.getString("temperature");
        TextView txView = findViewById(R.id.textTemperature);
        txView.setText(textViewText);
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
        saveInstanceState.putString("temperature", "+21");
        TextView txView = findViewById(R.id.textTemperature);
        saveInstanceState.putString("temperature", txView.getText().toString());
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

}

