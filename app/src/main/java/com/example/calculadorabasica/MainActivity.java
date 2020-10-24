package com.example.calculadorabasica;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    String NumeroAntes="";
    String Operacion="+";
    boolean RealOperacion=true;
    EditText EditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText=findViewById(R.id.pantalla);
    }

    public void click(View view) {
        if(RealOperacion)
            EditText.setText("");
        RealOperacion=false;
        String num = EditText.getText().toString();

        switch (view.getId()){

            case R.id.nueve:
                num +="9";
                break;
            case R.id.ocho:
                num +="8";
                break;
            case R.id.siete:
                num +="7";
                break;
            case R.id.seis:
                num +="6";
                break;
            case R.id.cinco:
                num +="5";
                break;
            case R.id.cuatro:
                num +="4";
                break;
            case R.id.tres:
                num +="3";
                break;
            case R.id.dos:
                num +="2";
                break;
            case R.id.uno:
                num +="1";
                break;
            case R.id.cero:
                num +="0";
                break;
            case R.id.punto:
                num +=".";
                break;
            case R.id.menosmas:
                num +="-"+num;
                break;
        }
        EditText.setText(num);
    }

    public void Operador(View view){
        RealOperacion=true;
        NumeroAntes=EditText.getText().toString();
        switch (view.getId()){
            case R.id.entre: Operacion="/"; break;
            case R.id.por: Operacion="*"; break;
            case R.id.menos:Operacion="-"; break;
            case R.id.mas:Operacion="+"; break;
        }
    }

    public void Resultados(View view){
        String ResultadoFinal = EditText.getText().toString();
        double Result = 0.0;
        switch (Operacion){
            case "/":
                Result=Double.parseDouble(NumeroAntes)/Double.parseDouble(ResultadoFinal);
                break;
            case "*":
                Result=Double.parseDouble(NumeroAntes)*Double.parseDouble(ResultadoFinal);
                break;
            case "-":
                Result=Double.parseDouble(NumeroAntes)-Double.parseDouble(ResultadoFinal);
                break;
            case "+":
                Result=Double.parseDouble(NumeroAntes)+Double.parseDouble(ResultadoFinal);
                break;
        }
        EditText.setText(Result+"");
    }

    /*public void Porcentaje(View view){
        double no = Double.parseDouble(EditText.getText().toString());
        RealOperacion=true;
    }*/

    public void BorrarDatos(View view) {
        EditText.setText("");
        RealOperacion=true;
    }
}