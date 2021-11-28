package com.meu.trabalhocpm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;

public class Compartilhar extends AppCompatActivity {
    EditText enviaTexto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compartilhar);

        enviaTexto = (EditText) findViewById(R.id.editTextTextMultiLine);

    }
    public void enviar(View view){

        String input = enviaTexto.getText().toString();

        if(input.isEmpty()){
            Snackbar.make(view,"Não se manda mensagem em branco",Snackbar.LENGTH_SHORT).show();

        }else{
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_SEND);
            String texto = enviaTexto.getText().toString();
            intent.putExtra(Intent.EXTRA_TEXT, texto);
            intent.setType("text/plain");
            Intent shareIntent = Intent.createChooser(intent,"Escolha por onde compartilhar");
            startActivity(shareIntent);
        }


    }
}