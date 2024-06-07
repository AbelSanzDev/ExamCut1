package com.example.examcut1;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNombre, editTextBase, editTextAltura;
    private Button buttonSiguiente, buttonSalir,buttonLimpiar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNombre = findViewById(R.id.editTextNombre);
        editTextBase = findViewById(R.id.editTextBase);
        editTextAltura = findViewById(R.id.editTextAltura);
        buttonSiguiente = findViewById(R.id.buttonSiguiente);
        buttonSalir = findViewById(R.id.buttonSalir);
        buttonLimpiar = findViewById(R.id.buttonLimpiar);

        buttonLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextNombre.setText("");
                editTextBase.setText("");
                editTextAltura.setText("");

            }
        });

        buttonSiguiente.setOnClickListener(v -> {
            String nombre = editTextNombre.getText().toString();
            String baseStr = editTextBase.getText().toString();
            String alturaStr = editTextAltura.getText().toString();

            if(nombre.isEmpty() || baseStr.isEmpty() || alturaStr.isEmpty()){
                Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show();
                return;
            }

            float base = Float.parseFloat(baseStr);
            float altura = Float.parseFloat(alturaStr);

            Intent intent = new Intent(MainActivity.this, RectanguloActivity.class);
            intent.putExtra("nombre", nombre);
            intent.putExtra("base", base);
            intent.putExtra("altura", altura);
            startActivity(intent);
        });

        buttonSalir.setOnClickListener(v -> finish());
    }
}
