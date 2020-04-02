package com.trianacodes.dosiscode.Actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.trianacodes.dosiscode.Entidades.Medicamentos;
import com.trianacodes.dosiscode.Funciones.funciones;
import com.trianacodes.dosiscode.R;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import static com.trianacodes.dosiscode.Funciones.funciones.dosCifras;

public class ControlMedicacion extends AppCompatActivity {

    private TextView MedicamentoControl;
    private String FechaControl, HoraControl, NumeroDiasControl, NumeroHoraControl;

    // Creo un objeto de tipo LinearLayout para ir agregándole las vistas en tiempo de ejecución
    private LinearLayout llControl;

    // Defino los parámetros del LineraLayout
    LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_medicacion);
        MedicamentoControl = findViewById(R.id.tvMedicamentoControl);
        llControl = findViewById(R.id.llControl);

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
        FechaControl = MedicamentoRecibido.getFechaIncioTratamiento();
        HoraControl = MedicamentoRecibido.getHoraInicioTratamiento();
        NumeroDiasControl = MedicamentoRecibido.getDiasDuracion().toString();
        NumeroHoraControl = MedicamentoRecibido.getNumeroHorasPosologia().toString();

    }

    // Manejo de fechas
    public void CalculaFechaFinal() throws ParseException {

        String fechaString = FechaControl;

        // Defino el formato de la fecha en forma de String
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        // Le doy el formato al String de la fecha
        Date fecha = formato.parse(fechaString);

        //Creo una instancia de tipo Calendar para manejar la cadena de fecha
        Calendar FechaFin = Calendar.getInstance();

        // Doy el valor de la cadena de fecha al objeto de tipo Calendar
        FechaFin.setTime(fecha);
        //Sumo un número de días a la fecha
        //FechaFin.add(Calendar.DAY_OF_YEAR, Integer.parseInt(NumeroDiasControl.getText().toString()) - 1);

        // Defino el formato de fecha según la región del móvil
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.getDefault());

        // Asigno al objeto Date que he creado el valor la fecha resultante
        fecha = FechaFin.getTime();

        // Muestro el resultado asignándole el formato definido correspondiente a la región del móvil
        //TextoResultado.setText(df.format(FechaFin.getTime()));

        int HorasDia = 24 / Integer.parseInt(NumeroHoraControl);
        int HoraFin, MinutoFin, Indice;
        int SumatorioDia = 0;
        // Veo en la posición en la que se encuentran los : dentro de la cadena de la hora
        Indice = HoraControl.indexOf(":");
        HoraFin = Integer.parseInt(HoraControl.substring(0,Indice));
        MinutoFin = Integer.parseInt(HoraControl.substring(Indice + 1, 5));

        // Creo una vista pasándole como parámetro, el contexto
        //TextView tvControlInicial = new TextView(this);
        Switch swControlInicial = new Switch(this);

        // Establezco los parámetros definidos para el LinearLayout como parámetros de la vista creada
        //tvControlInicial.setLayoutParams(lp);
        swControlInicial.setLayoutParams(lp);

        // Establezco el texto a la cista creada
        //tvControlInicial.setText(df.format(FechaFin.getTime()) + "\n" + dosCifras(HoraFin) + ":" + dosCifras(MinutoFin));
        swControlInicial.setText(df.format(FechaFin.getTime()) + "\n" + dosCifras(HoraFin) + ":" + dosCifras(MinutoFin));

        // Establezco el tamaño del texto de la vista creada
        //tvControlInicial.setTextSize(18);
        swControlInicial.setTextSize(18);

        // Establezco los márgenes de la vista creada
        //tvControlInicial.setPadding(64,200,16,0);
        swControlInicial.setPadding(64, 200, 16, 0);

        // Establezo en negrita el estilo del texto de la vista
        //tvControlInicial.setTypeface(null, Typeface.BOLD);
        swControlInicial.setTypeface(null, Typeface.BOLD);

        swControlInicial.setId(0);

        // Añado la vista al layout del XML
        //llControl.addView(tvControlInicial);
        llControl.addView(swControlInicial);

        for (int j = 0; j < (Integer.parseInt(NumeroDiasControl) * HorasDia) - 1; j++){

               HoraFin = HoraFin + Integer.parseInt(NumeroHoraControl);
               if (HoraFin > 24){

                   HoraFin = HoraFin - 24;
                   SumatorioDia = 1;
                   FechaFin.add(Calendar.DAY_OF_YEAR,SumatorioDia);

               }

               Switch swControl  = new Switch(this);
               swControl.setLayoutParams(lp);
               swControl.setText(df.format(FechaFin.getTime()) + "\n" + dosCifras(HoraFin) + ":" + dosCifras(MinutoFin));
               swControl.setTextSize(18);
               swControl.setPadding(64,200,16,0);
               swControl.setTypeface(null, Typeface.BOLD);
               swControl.setId(j+1);
               llControl.addView(swControl);

        }

    }

}
