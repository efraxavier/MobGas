package com.example.mobgas;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mobgas.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editTextGasolina = findViewById(R.id.editTextGasolina);
        EditText editTextEtanol = findViewById(R.id.editTextEtanol);
        Button buttonCalcular = findViewById(R.id.buttonCalcular);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView textViewResultado = findViewById(R.id.textViewResultado);

        buttonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gasolinaStr = editTextGasolina.getText().toString();
                String etanolStr = editTextEtanol.getText().toString();

                if (!gasolinaStr.isEmpty() && !etanolStr.isEmpty()) {
                    double gasolina = Double.parseDouble(gasolinaStr);
                    double etanol = Double.parseDouble(etanolStr);

                    double percentual = etanol / gasolina * 100;

                    if (percentual <= 70) {
                        textViewResultado.setText("Compensa abastecer com etanol!");
                    } else {
                        textViewResultado.setText("Compensa abastecer com gasolina!");
                    }
                } else {
                    textViewResultado.setText("Por favor, insira os valores.");
                }
            }
        });
    }
}
