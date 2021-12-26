package com.meu.trabalhocpm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Listagem extends AppCompatActivity {

    private ListView informacoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem);
        informacoes = findViewById(R.id.viewLista);
        AppDatabase db = AppDatabase.getInstance(getApplicationContext());
        PessoasDao dao = db.pessoasDao();
        List<PessoasEntity> pessoas = dao.listarTodasPessoas();
        List<String> alunos = alunoListView(pessoas);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                alunos );
        informacoes.setAdapter(arrayAdapter);
        informacoes.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
               
                
                excluir(i+1);
                return true;
            }
        });
    }
    private List<String> alunoListView(List<PessoasEntity> matriculados){
        List<String> alunos = new ArrayList<>();
        for (PessoasEntity aluno : matriculados){
            alunos.add(aluno.toString());
        }
        return alunos;
    }
    public void excluir(Integer i){
        Toast.makeText(this, "Escolheu a linha "+i.toString(), Toast.LENGTH_SHORT).show();

    }
}