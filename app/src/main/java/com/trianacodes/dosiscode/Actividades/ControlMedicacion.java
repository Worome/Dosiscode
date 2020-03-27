package com.trianacodes.dosiscode.Actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.TextView;

import com.trianacodes.dosiscode.Entidades.Medicamentos;
import com.trianacodes.dosiscode.R;

import java.sql.Date;
import java.text.DateFormat;
import java.util.Calendar;

public class ControlMedicacion extends AppCompatActivity {

    private TextView MedicamentoControl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_medicacion);
        MedicamentoControl = findViewById(R.id.tvMedicamentoControl);

        RecogeDatos();

    }

    private void RecogeDatos(){

        Medicamentos MedicamentoRecibido =
                (Medicamentos) getIntent().getExtras().getSerializable("MedicamentoEnviado");
        MedicamentoControl.setText(MedicamentoRecibido.getNombre());

    }

}
