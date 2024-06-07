package com.example.examcut1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RectanguloActivity extends AppCompatActivity {

    private TextView textViewNombre, textViewAltura, textViewBase, textViewResultado;
    private RadioGroup radioGroupOperaciones;
    private Button buttonCalcular, buttonRegresar,buttonLampiar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangulo);

        textViewNombre = findViewById(R.id.textViewNombre);
        textViewAltura = findViewById(R.id.textViewAltura);
        textViewBase = findViewById(R.id.textViewBase);
        textViewResultado = findViewById(R.id.textViewResultado);
        radioGroupOperaciones = findViewById(R.id.radioGroupOperaciones);
        buttonCalcular = findViewById(R.id.buttonCalcular);
        buttonRegresar = findViewById(R.id.buttonRegresar);
        buttonLampiar = findViewById(R.id.buttonLampiar);

        buttonLampiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewResultado.setText("");
                radioGroupOperaciones.clearCheck();

            }
        });

        Intent intent = getIntent();
        String nombre = intent.getStringExtra("nombre");
        float base = intent.getFloatExtra("base", 0);
        float altura = intent.getFloatExtra("altura", 0);

        textViewNombre.setText(nombre);
        textViewBase.setText("Base: " + base);
        textViewAltura.setText("Altura: " + altura);

        buttonCalcular.setOnClickListener(v -> {
            Rectangulo rectangulo = new Rectangulo(base, altura);
            int selectedOperation = radioGroupOperaciones.getCheckedRadioButtonId();

            if (selectedOperation == R.id.radioButtonArea) {
                float area = rectangulo.calcularArea();
                textViewResultado.setText("Área: " + area);
            } else if (selectedOperation == R.id.radioButtonPerimetro) {
                float perimetro = rectangulo.calcularPerimetro();
                textViewResultado.setText("Perímetro: " + perimetro);
            } else {
                Toast.makeText(this, "Por favor, seleccione una operación", Toast.LENGTH_SHORT).show();
            }
        });

        buttonRegresar.setOnClickListener(v -> finish());
    }
}
