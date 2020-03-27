package com.trianacodes.dosiscode.fragments;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class TimePickerFragment extends DialogFragment {

    private TimePickerDialog.OnTimeSetListener listener;
    public static TimePickerFragment newInstance(TimePickerDialog.OnTimeSetListener listener){

        TimePickerFragment fragment = new TimePickerFragment();
        fragment.setListener(listener);
        return fragment;

    }

    public void setListener(TimePickerDialog.OnTimeSetListener listener){
        this.listener = listener;
    }

    @Override
    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState){

        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int min = c.get(Calendar.MINUTE);

        return new TimePickerDialog(getActivity(), listener, hour, min, true);

    }

    public void onTimeSet(TimePicker view, int hour, int min) {

        //Aquí se trabaja con la fecha que el usuario haya seleccionado

    }

}
