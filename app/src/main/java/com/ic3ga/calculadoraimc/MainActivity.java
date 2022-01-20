package com.ic3ga.calculadoraimc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edValor1;
    EditText edValor2;
    TextView tResultado;
    Button calcular, limpar;

    double valor1;
    double valor2;
    double resultado;
    double pesoMinimo;
    double pesoMaximo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edValor1 = (EditText) findViewById(R.id.edAltura);
        edValor2 = (EditText) findViewById(R.id.edPeso);

        calcular = (Button) findViewById(R.id.btnCalcular);
        limpar = (Button) findViewById(R.id.btnLimpar);

        tResultado = (TextView) findViewById(R.id.tCalculo);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valor1 = Double.parseDouble(edValor1.getText().toString());
                valor2 = Double.parseDouble(edValor2.getText().toString());
                resultado = (valor2/(valor1*valor1));
                pesoMinimo =  18.5*(Math.pow(valor1, 2));
                pesoMaximo =  24.9 *(Math.pow(valor1, 2));
                if(resultado <18.5){
                    tResultado.setText(String.format("IMC: " + "%.2f" + " Abaixo do Peso" + "%nPeso Ideal Entre: %.2fKg" + " - " + "%.2f", resultado, pesoMinimo, pesoMaximo));
                }else if(resultado < 24.9){
                    tResultado.setText(String.format("IMC: " + "%.2f", valor2/(valor1*valor1))+" "+" Peso normal" );
                }else if (resultado < 29.9){
                    tResultado.setText(String.format("IMC: " + "%.2f" +" Excesso de Peso" + "%nPeso Ideal Entre: %.2f Kg" + " - " + "%.2f Kg", resultado, pesoMinimo, pesoMaximo));
                }else if(resultado<34.9){
                    tResultado.setText(String.format("IMC: " + "%.2f" +" - Obesidade Grau I" + "%nPeso Ideal Entre: %.2f Kg" + " - " + "%.2f Kg", resultado, pesoMinimo, pesoMaximo));
                } else if(resultado < 39.9){
                    tResultado.setText(String.format("IMC: " + "%.2f" +" - Obesidade Grau II" + "%nPeso Ideal Entre: %.2f Kg" + " - " + "%.2f Kg", resultado, pesoMinimo, pesoMaximo));
                }else{
                    tResultado.setText(String.format("IMC: " + "%.2f" +" - Obesidade Grau III" + "%nPeso Ideal Entre: %.2f Kg" + " - " + "%.2f Kg", resultado, pesoMinimo, pesoMaximo));              }
            }
        });

        limpar.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tResultado.setText("");
                edValor1.setText("");
                edValor2.setText("");
            }
        });
    }
}