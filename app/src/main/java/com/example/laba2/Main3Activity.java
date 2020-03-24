package com.example.laba2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        EditText et = findViewById(R.id.editText);

        Button button = findViewById(R.id.button4);
        button.setOnClickListener(v -> {
            // Считываем значение поля
            String text = et.getText().toString();

            // Формируем "пустое" намерение
            Intent intent = new Intent();
            // Добавляем в намерение данные
            intent.putExtra("result",text);

            // Устанавливаем результат
            setResult(RESULT_OK,intent);

            // Закрываем Activity
            finish();
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        setResult(RESULT_CANCELED);
    }

}