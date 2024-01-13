package com.example.calcimc;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.example.calcimc.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        TextView resultadoCalculo = findViewById(R.id.txt_resultado_calculo);
        TextView resultadoClassificacao = findViewById(R.id.txt_classificacao);
        Button botaoCalcular= findViewById(R.id.btn_calcular);
        EditText altura = findViewById(R.id.input_altura);
        EditText peso = findViewById(R.id.input_peso);


        botaoCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcular();
            }

            private void calcular()
            {
                double imc =0.0;
                imc = Double.parseDouble(peso.getText().toString()) / (Double.parseDouble(altura.getText().toString()) * 2);


                if(imc <= 18.5){
                    resultadoClassificacao.setText(String.valueOf("Filezinho"));
                }else if(imc > 18.5 && imc <= 25){
                    resultadoClassificacao.setText(String.valueOf("Diliça"));
                } else if(imc > 25 && imc <= 30){
                    resultadoClassificacao.setText(String.valueOf("Ta top"));
                }else{
                    resultadoClassificacao.setText(String.valueOf("Oh la em casa"));
                }
                resultadoCalculo.setText(String.valueOf(imc));

                resultadoCalculo.setVisibility(View.VISIBLE);
                resultadoClassificacao.setVisibility(View.VISIBLE);

            }
        });


    }
}