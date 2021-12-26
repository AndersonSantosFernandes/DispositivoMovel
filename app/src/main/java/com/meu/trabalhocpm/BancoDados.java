package com.meu.trabalhocpm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class BancoDados extends AppCompatActivity {
    private MediaPlayer gravadoSucesso;
    private EditText matricula, nome, idade, cpf;
    private Button salvar;
    private Button buscar;
    private ListView informacoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banco_dados);
        gravadoSucesso = MediaPlayer.create(this,R.raw.win);
        matricula = findViewById(R.id.matricula);
        nome = findViewById(R.id.nome);
        idade = findViewById(R.id.idade);
        cpf = findViewById(R.id.cpf);

        AppDatabase db = AppDatabase.getInstance(getApplicationContext());
        PessoasDao dao = db.pessoasDao();

        List<PessoasEntity> pessoas = dao.listarTodasPessoas();
        //List<String> alunos = alunoListView(pessoas);

      //  ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
          //      this,
           //     android.R.layout.simple_list_item_1,
           //     alunos );
      //  informacoes.setAdapter(arrayAdapter);

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

               PessoasEntity pesoas = new PessoasEntity(matric,name,idd,cp);

                List<PessoasEntity> list = new ArrayList<>();
                list.add(pesoas);
                dao.inserAll(list);

                extracted();

                Snackbar.make(view,"Cadástro efetuado com sucesso !",Snackbar.LENGTH_SHORT).show();
                gravadoSucesso.start();
              }
            }
        });

        Button goconsulta = findViewById(R.id.buttonIrconsulta);
        goconsulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BancoDados.this,Listagem.class);
                startActivity(intent);
            }
        });

    }

    private void extracted() {
        matricula.setText("");
        matricula.requestFocus();
        nome.setText("");
        idade.setText("");
        cpf.setText("");
    }

}