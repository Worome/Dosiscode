package com.trianacodes.dosiscode.Actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import com.trianacodes.dosiscode.Entidades.Medicamentos;
import com.trianacodes.dosiscode.R;
import com.trianacodes.dosiscode.fragments.DatePickerFragment;
import com.trianacodes.dosiscode.fragments.TimePickerFragment;

import static com.trianacodes.dosiscode.Funciones.funciones.dosCifras;


public class MainActivity extends AppCompatActivity {

    private EditText Medicamento, Enfermo, Uso, FechaInicio, HoraInicio, DiasDuracion, HorasPosología,
            Posoloqía, Lugares;
    private Button Siguiente;
    public Medicamentos objetoMedicina = new Medicamentos();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Medicamento = findViewById(R.id.etMedicamento);
        Enfermo = findViewById(R.id.etEnfermo);
        Uso = findViewById(R.id.etUso);
        FechaInicio = findViewById(R.id.etFechaInicio);
        HoraInicio = findViewById(R.id.etHoraInicio);
        DiasDuracion = findViewById(R.id.etDiasDuracionTratamiento);
        HorasPosología = findViewById(R.id.etHoraposologia);
        Posoloqía = findViewById(R.id.etPosologia);
        Lugares = findViewById(R.id.etLugaresAplicar);
        Siguiente = findViewById(R.id.btnSiguiente);

        //Llama al DatePicker
        FechaInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

        //Llama al TimePicker
        HoraInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePickerDialog();
            }
        });

        Siguiente.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                lanzaControlMedicamento();

            }

        });

    }

    protected void lanzaControlMedicamento(){

        objetoMedicina.setNombre(Medicamento.getText().toString());
        objetoMedicina.setEnfermo(Enfermo.getText().toString());
        objetoMedicina.setUso(Uso.getText().toString());
        objetoMedicina.setFechaIncioTratamiento(FechaInicio.getText().toString());
        objetoMedicina.setHoraInicioTratamiento(HoraInicio.getText().toString());

        if (!DiasDuracion.getText().toString().isEmpty()){

            objetoMedicina.setDiasDuracion(Integer.parseInt(DiasDuracion.getText().toString()));

        } else  {

            //Este else lo debo controlar cuando desde una funcíon verifique que nungún dato esté vacío
            objetoMedicina.setDiasDuracion(1);

        }

        if (!HorasPosología.getText().toString().isEmpty()){

            objetoMedicina.setNumeroHorasPosologia(Integer.parseInt(HorasPosología.getText().toString()));

        } else  {

            //Este else lo debo controlar cuando desde una funcíon verifique que nungún dato esté vacío
            objetoMedicina.setNumeroHorasPosologia(1);

        }


        objetoMedicina.setPosologia(Posoloqía.getText().toString());

        if (!Lugares.getText().toString().isEmpty()){

            objetoMedicina.setNumeroLugares(Integer.parseInt(Lugares.getText().toString()));

        } else  {

            //Este else lo debo controlar cuando desde una funcíon verifique que nungún dato esté vacío
            objetoMedicina.setNumeroLugares(1);

        }

        Intent controlMedicamento = new Intent(this, ControlMedicacion.class);
        controlMedicamento.putExtra("MedicamentoEnviado", objetoMedicina);
        startActivity(controlMedicamento);

    }

    private void showDatePickerDialog() {
        DatePickerFragment newFragment = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                // Sumo 1 al mes porque a Enero le corresponde el 0 si no se lo sumo
                final String selectDate = dosCifras(day) + "/" + dosCifras((month + 1)) + "/" + year;
                FechaInicio.setText(selectDate);

            }

        });

        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    private void showTimePickerDialog() {
        TimePickerFragment newFragment = TimePickerFragment.newInstance(new TimePickerDialog.OnTimeSetListener() {


            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                // Sumo 1 al mes porque a Enero le corresponde el 0 si no se lo sumo
                final String selectTime = dosCifras(hourOfDay) + ":" + dosCifras((minute));
                HoraInicio.setText(selectTime);

            }

        });

        newFragment.show(getSupportFragmentManager(), "timePicker");
    }

}
