package com.meu.trabalhocpm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class BancoDados extends AppCompatActivity {

    private EditText matricula, nome, idade, cpf;
    private Button salvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banco_dados);

        matricula = findViewById(R.id.matricula);
        nome = findViewById(R.id.nome);
        idade = findViewById(R.id.idade);
        cpf = findViewById(R.id.cpf);

        Button btSave = findViewById(R.id.buttonBd);
        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String vlrMatricula = matricula.getText().toString();
                String vlrNome = nome.getText().toString();
                String vlrIdade = idade.getText().toString();
                String vlrCpf = cpf.getText().toString();
            if(vlrMatricula.isEmpty() || vlrNome.isEmpty() || vlrIdade.isEmpty() || vlrCpf.isEmpty()){
                Snackbar.make(view,"Preencha todos os campos para prosseguir",Snackbar.LENGTH_SHORT).show();
            } else{

                int matric = Integer.parseInt(String.valueOf(matricula.getText()));
               String name = vlrNome;
                int idd = Integer.parseInt(String.valueOf(idade.getText()));
               String cp = vlrCpf;

        AppDatabase db = AppDatabase.getInstance(getApplicationContext());
        PessoasDao dao = db.pessoasDao();
        PessoasEntity pesoas = new PessoasEntity(matric,name,idd,cp);

//        PessoasEntity pesoas = new PessoasEntity(1379,"Delzilane",44,"20515694878");


                List<PessoasEntity> list = new ArrayList<>();
        list.add(pesoas);
        dao.inserAll(list);

             matricula.setText("");
             nome.setText("");
             idade.setText("");
             cpf.setText("");
            }
            }
        });












    }
}