package com.example.domingo8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //traigo los componentes.
    private EditText tbDolares;
    private EditText tbEuros;
    private EditText tbResultado;
    private RadioButton rbDolares;
    private RadioButton rbEuros;
    private RadioGroup groupRadios;
    private Button btnConvertir;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //editext
        tbDolares = findViewById(R.id.tbDolares);
        tbEuros = findViewById(R.id.tbEuros);
        tbResultado = findViewById(R.id.tbResultado);



        //radiobuttons
        rbDolares = findViewById(R.id.rbDolares);
        rbEuros = findViewById(R.id.rbEuros);
        groupRadios = findViewById(R.id.groupRadios);

        //button
        btnConvertir = findViewById(R.id.btnConvertir);

        //evento on click
        btnConvertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (groupRadios.getCheckedRadioButtonId()!=-1) {

                    if (rbDolares.isChecked()) {

                        Double dolaresDato = Double.parseDouble(tbDolares.getText().toString());

                        Double miResultadoEnDolares = calcularDolaresAEuros(dolaresDato);

                        tbResultado.setText(miResultadoEnDolares.toString());

                    } else if (rbEuros.isChecked()){

                        Double eurosDato = Double.parseDouble(tbEuros.getText().toString());

                        Double miResultadoEnEuros = calcularEurosADolares(eurosDato);

                        tbResultado.setText(miResultadoEnEuros.toString());

                    }

                }
            }
        });
    }

    //Metodo para calcular dolares a euros
    public double calcularDolaresAEuros(double dolares) {

        double result = dolares*0.91;

        return result;
    }

    //Metodo para calcular euros a dolares.
    public double calcularEurosADolares(double euros) {

        double result = euros*1.10;

        return result;
    }
}
