package com.trianacodes.dosiscode.Funciones;

public class funciones {

    public static String dosCifras(int n){

        return (n<=9) ? ("0" + n) : String.valueOf(n);

    }

}
