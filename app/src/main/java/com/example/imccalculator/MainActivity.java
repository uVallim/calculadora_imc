package com.example.imccalculator;

import android.os.Bundle;
import android.content.Intent;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCalculadoraIMC = findViewById(R.id.btnCalculadoraIMC);
        btnCalculadoraIMC.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CalculoIMCActivity.class);
            startActivity(intent);
        });
    }
}