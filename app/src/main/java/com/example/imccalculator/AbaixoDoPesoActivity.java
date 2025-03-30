package com.example.imccalculator;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class AbaixoDoPesoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abaixo_peso);

        // Recuperar dados passados
        Bundle bundle = getIntent().getExtras();
        double peso = bundle.getDouble("peso");
        double altura = bundle.getDouble("altura");
        double imc = bundle.getDouble("imc");

        // Formatar números
        DecimalFormat df = new DecimalFormat("#.##");

        // Atualizar TextView com detalhes
        TextView textDetalhesPeso = findViewById(R.id.textDetalhesPeso);
        textDetalhesPeso.setText(String.format("Peso: %.1f kg\nAltura: %.2f m\nIMC: %s",
                peso, altura, df.format(imc)));

        // Botão fechar
        Button btnFechar = findViewById(R.id.btnFechar);
        btnFechar.setOnClickListener(v -> finish());
    }
}