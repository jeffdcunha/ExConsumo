package com.fatec.zl.exconsumo;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
/*
 *@author:Jefferson Dantas da Cunha
 *@RA: 1110482323044
 */



public class MainActivity extends AppCompatActivity {
    private EditText etConsumo;
    private EditText etTanque;
    private TextView tvRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        etConsumo = findViewById(R.id.etConsumoMedio);
        etConsumo.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        etTanque = findViewById(R.id.etQuantidadeTanque);
        etTanque.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        tvRes = findViewById(R.id.tvRes);
        tvRes.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);

        Button btnCalcular = findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(op -> Calcular());
    }

    private void Calcular(){
        float consumo = Float.parseFloat(etConsumo.getText().toString());
        float tanque = Float.parseFloat(etTanque.getText().toString());
        float consumoTotal = consumo * tanque * 1000;
        String res = getString(R.string.s_mensagem) + " " + consumoTotal + " metros.";
        tvRes.setText(res);
    }
}