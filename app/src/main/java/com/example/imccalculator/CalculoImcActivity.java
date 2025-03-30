package com.example.imccalculator;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CalculoImcActivity extends AppCompatActivity {

    private EditText editPeso, editAltura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_imc);

        editPeso = findViewById(R.id.editPeso);
        editAltura = findViewById(R.id.editAltura);
        Button btnCalcular = findViewById(R.id.btnCalcular);
        Button btnLimpar = findViewById(R.id.btnLimpar);
        Button btnFechar = findViewById(R.id.btnFechar);

        btnCalcular.setOnClickListener(v -> calcularIMC());
        btnLimpar.setOnClickListener(v -> limparCampos());
        btnFechar.setOnClickListener(v -> finish());
    }

    private void calcularIMC() {
        String pesoStr = editPeso.getText().toString().trim();
        String alturaStr = editAltura.getText().toString().trim();

        // Verificar campos vazios
        if (TextUtils.isEmpty(pesoStr) || TextUtils.isEmpty(alturaStr)) {
            Toast.makeText(this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double peso = Double.parseDouble(pesoStr);
            double altura = Double.parseDouble(alturaStr);

            // Validar valores
            if (peso <= 0 || altura <= 0) {
                Toast.makeText(this, "Os valores de peso e altura devem ser maiores que zero.", Toast.LENGTH_SHORT).show();
                return;
            }

            // Verificar faixa de valores razoável
            if (peso < 20 || peso > 300) {
                Toast.makeText(this, "Por favor, insira um peso válido entre 20kg e 300kg.", Toast.LENGTH_SHORT).show();
                return;
            }

            if (altura < 0.5 || altura > 2.5) {
                Toast.makeText(this, "Por favor, insira uma altura válida entre 0.5m e 2.5m.", Toast.LENGTH_SHORT).show();
                return;
            }

            double imc = peso / (altura * altura);

            Intent intent;
            String categoria;

            if (imc < 18.5) {
                intent = new Intent(this, AbaixoDoPesoActivity.class);
                categoria = getString(R.string.abaixo_peso_titulo);
            } else if (imc < 25) {
                intent = new Intent(this, PesoNormalActivity.class);
                categoria = getString(R.string.peso_normal_titulo);
            } else if (imc < 30) {
                intent = new Intent(this, SobrepesoActivity.class);
                categoria = getString(R.string.sobrepeso_titulo);
            } else if (imc < 35) {
                intent = new Intent(this, Obesidade1Activity.class);
                categoria = getString(R.string.obesidade_1_titulo);
            } else if (imc < 40) {
                intent = new Intent(this, Obesidade2Activity.class);
                categoria = getString(R.string.obesidade_2_titulo);
            } else {
                intent = new Intent(this, Obesidade3Activity.class);
                categoria = getString(R.string.obesidade_3_titulo);
            }

            // Passar dados para a próxima activity
            Bundle bundle = new Bundle();
            bundle.putDouble("peso", peso);
            bundle.putDouble("altura", altura);
            bundle.putDouble("imc", imc);
            bundle.putString("categoria", categoria);
            intent.putExtras(bundle);

            startActivity(intent);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Por favor, digite valores numéricos válidos.", Toast.LENGTH_SHORT).show();
        }
    }

    private void limparCampos() {
        editPeso.setText("");
        editAltura.setText("");
        editPeso.requestFocus();
    }
}