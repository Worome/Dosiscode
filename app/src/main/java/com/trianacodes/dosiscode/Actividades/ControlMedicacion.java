package com.trianacodes.dosiscode.Actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.trianacodes.dosiscode.Entidades.Medicamentos;
import com.trianacodes.dosiscode.R;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class ControlMedicacion extends AppCompatActivity {

    private TextView MedicamentoControl,FechaControl, HoraControl, NumeroDiasControl,
            NumeroHoraControl, TextoResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_medicacion);
        MedicamentoControl = findViewById(R.id.tvMedicamentoControl);
        FechaControl = findViewById(R.id.tvFechaInicio);
        HoraControl = findViewById(R.id.tvHoraInicio);
        NumeroDiasControl = findViewById(R.id.tvNumeroDias);
        NumeroHoraControl = findViewById(R.id.tvNumeroHoras);
        TextoResultado = findViewById(R.id.etResultado);

        RecogeDatos();
        try {
            CalculaFechaFinal();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    private void RecogeDatos(){

        Medicamentos MedicamentoRecibido =
                (Medicamentos) getIntent().getExtras().getSerializable("MedicamentoEnviado");
        MedicamentoControl.setText(MedicamentoRecibido.getNombre());
        FechaControl.setText(MedicamentoRecibido.getFechaIncioTratamiento());
        HoraControl.setText(MedicamentoRecibido.getHoraInicioTratamiento());
        NumeroDiasControl.setText(MedicamentoRecibido.getDiasDuracion().toString());
        NumeroHoraControl.setText(MedicamentoRecibido.getNumeroHorasPosologia().toString());

    }

    // Manejo de fechas
    public void CalculaFechaFinal() throws ParseException {

        String fechaString = FechaControl.getText().toString();
        // Defino el formato de la fecha en forma de String
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        // Le doy el formato al String de la fecha
        Date fecha = formato.parse(fechaString);

        //Creo una instancia de tipo Calendar para manejar la cadena de fecha
        Calendar FechaFin = Calendar.getInstance();
        // Doy el valor de la cadena de fecha al objeto de tipo Calendar
        FechaFin.setTime(fecha);
        //Sumo un número de días a la fecha
        FechaFin.add(Calendar.DAY_OF_YEAR, Integer.parseInt(NumeroDiasControl.getText().toString()) - 1);
        // Defino el formato de fecha según la región del móvil
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.getDefault());
        // Asigno al objeto Date que he creado el valor la fecha resultante
        fecha = FechaFin.getTime();
        // Muestro el resultado asignándole el formato definido correspondiente a la región del móvil
        TextoResultado.setText(df.format(FechaFin.getTime()));
    }

}
