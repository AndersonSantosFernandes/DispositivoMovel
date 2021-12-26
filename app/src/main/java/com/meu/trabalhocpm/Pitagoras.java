package com.meu.trabalhocpm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

public class Pitagoras extends AppCompatActivity {
    EditText catetoMaior, catetoMenor, hipotenusa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pitagoras);

        getSupportActionBar().hide();
        catetoMaior = findViewById(R.id.maiorCattoId);
        catetoMenor = findViewById(R.id.menorCatetoId);
        hipotenusa = findViewById(R.id.hipotenusaId);
        Button calculo = findViewById(R.id.buttonCalcula);
        calculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String catMais = catetoMaior.getText().toString();
                String catMenos = catetoMenor.getText().toString();
                String hipoten = hipotenusa.getText().toString();
                if(! catMais.isEmpty() && ! catMenos.isEmpty() && hipoten.isEmpty()){
                    double vlCateMaio = Double.parseDouble(String.valueOf(catetoMaior.getText()));
                    double vlCateMenor = Double.parseDouble(String.valueOf(catetoMenor.getText()));
                    double hip = Math.sqrt(Math.pow(vlCateMaio,2) + Math.pow(vlCateMenor,2));
                    hipotenusa.setText( ""+hip);
                }else if(! catMais.isEmpty() &&  catMenos.isEmpty() && ! hipoten.isEmpty()){
                    double vlCateMaio = Double.parseDouble(String.valueOf(catetoMaior.getText()));
                    double vlHiponenu = Double.parseDouble(String.valueOf(hipotenusa.getText()));
                    if(vlCateMaio > vlHiponenu){
                        Snackbar.make(view,"Cateto não pode ser maior que hipotenusa",Snackbar.LENGTH_SHORT).show();
                    }else{
                        double ctMen = Math.sqrt( Math.pow(vlHiponenu,2) - Math.pow(vlCateMaio,2) );
                        catetoMenor.setText(""+ ctMen);
                    }
                }else if(catMais.isEmpty() && ! catMenos.isEmpty() && ! hipoten.isEmpty()){
                    double vlCateMenor = Double.parseDouble(String.valueOf(catetoMenor.getText()));
                    double vlHiponenu = Double.parseDouble(String.valueOf(hipotenusa.getText()));

                    if(vlCateMenor > vlHiponenu){
                        Snackbar.make(view,"Cateto não pode ser maior que hipotenusa",Snackbar.LENGTH_SHORT).show();
                    }else{
                        double catMai = Math.sqrt( Math.pow(vlHiponenu,2) -  Math.pow(vlCateMenor,2)  );
                        catetoMaior.setText(""+catMai);
                    }
                }else{
                    Snackbar.make(view,"Deixe vazio apenas a incógnita",Snackbar.LENGTH_SHORT).show();
                }
            }
        });
        calculo.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                catetoMaior.setText("");
                catetoMenor.setText("");
                hipotenusa.setText("");
                return true;
            }
        });


    }
}