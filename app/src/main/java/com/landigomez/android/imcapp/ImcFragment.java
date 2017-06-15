package com.landigomez.android.imcapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View.OnClickListener;

/**
 * Created by LE on 14/06/2017.
 */

public class ImcFragment extends Fragment {
// variables de instancia.
    EditText mCampoPeso;
    EditText mCampoEstatura;
    Button mBotonCalcular;
    Button mBotonLimpiar;
    TextView mEtiquetaImc;

public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle saveInstanceState){
    View v = inflater.inflate(R.layout.fragmento_imc,container,false);
// inicializando las variables.
     mCampoPeso = (EditText) v.findViewById(R.id.campo_peso);
     mCampoEstatura= (EditText) v.findViewById(R.id.campo_estatura);
    mBotonCalcular = (Button)v.findViewById(R.id.boton_calcular);
    mBotonLimpiar = (Button) v.findViewById(R.id.boton_limpiar);
    mEtiquetaImc = (TextView) v.findViewById(R.id.etiqueta_imc);

    mBotonCalcular.setOnClickListener(new View.OnClickListener(){
        @Override

        public void onClick(View v){
            String s = mCampoPeso.getText().toString();
            double peso = Double.parseDouble(s);
            s = mCampoEstatura.getText().toString();
            double estatura = Double.parseDouble(s);
            double imc = peso / (estatura * estatura);
            s =  String.format("%2.2f", imc);
            mEtiquetaImc.setText(s);
        }
    });

    mBotonLimpiar.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v){
            mCampoPeso.setText("");
            mCampoEstatura.setText("");
            mEtiquetaImc.setText("0.0");
        }
    });
    return v;



}
}

