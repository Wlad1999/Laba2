package com.example.laba2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void handleClick(View view) {
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }

    public void handleClick1(View view) {
        Intent i = new Intent(Intent.ACTION_SEND);

        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_SUBJECT, "Важное сообщение");
        i.putExtra(Intent.EXTRA_TEXT, "Привет, как дела?");

        // Получаем Package Manager
        PackageManager manager = this.getPackageManager();
        // Получаем список обработчиков намерения
        List<ResolveInfo> list = manager.queryIntentActivities(i, 0);

        if (list.size() > 0) {
            startActivity(i);
        } else {
            Toast.makeText(this,"Невозможно обработать намерение!",Toast.LENGTH_LONG).show();
        }
    }
}
