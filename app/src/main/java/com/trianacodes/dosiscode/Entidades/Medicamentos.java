package com.trianacodes.dosiscode.Entidades;

import java.io.Serializable;

public class Medicamentos implements Serializable {

    private String Nombre, Uso, FechaIncioTratamiento, HoraInicioTratamiento, Posologia;
    private Integer DiasDuracion, NumeroHorasPosologia, NumeroLugares;

    public Medicamentos() {
    }

    public Medicamentos(String nombre, String uso, String fechaIncioTratamiento,
                        String horaInicioTratamiento, String posologia, Integer diasDuracion,
                        Integer numeroHorasPosologia, Integer numeroLugares) {
        Nombre = nombre;
        Uso = uso;
        FechaIncioTratamiento = fechaIncioTratamiento;
        HoraInicioTratamiento = horaInicioTratamiento;
        Posologia = posologia;
        DiasDuracion = diasDuracion;
        NumeroHorasPosologia = numeroHorasPosologia;
        NumeroLugares = numeroLugares;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getUso() {
        return Uso;
    }

    public void setUso(String uso) {
        Uso = uso;
    }

    public String getFechaIncioTratamiento() {
        return FechaIncioTratamiento;
    }

    public void setFechaIncioTratamiento(String fechaIncioTratamiento) {
        FechaIncioTratamiento = fechaIncioTratamiento;
    }

    public String getHoraInicioTratamiento() {
        return HoraInicioTratamiento;
    }

    public void setHoraInicioTratamiento(String horaInicioTratamiento) {
        HoraInicioTratamiento = horaInicioTratamiento;
    }

    public String getPosologia() {
        return Posologia;
    }

    public void setPosologia(String posologia) {
        Posologia = posologia;
    }

    public Integer getDiasDuracion() {
        return DiasDuracion;
    }

    public void setDiasDuracion(Integer diasDuracion) {
        DiasDuracion = diasDuracion;
    }

    public Integer getNumeroHorasPosologia() {
        return NumeroHorasPosologia;
    }

    public void setNumeroHorasPosologia(Integer numeroHorasPosologia) {
        NumeroHorasPosologia = numeroHorasPosologia;
    }

    public Integer getNumeroLugares() {
        return NumeroLugares;
    }

    public void setNumeroLugares(Integer numeroLugares) {
        NumeroLugares = numeroLugares;
    }

}
