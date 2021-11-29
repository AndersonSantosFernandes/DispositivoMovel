package com.meu.trabalhocpm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Menu menu1, menu2, menu3, menu4, menu5, menu6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    // usamos aqui o inflae para inflar o menu > transformar o menú em uma view
        // Ir em res e criar u novo dire´torio cchamado menu

        getMenuInflater().inflate(R.menu.menu_principal,menu);

        return super.onCreateOptionsMenu(menu);
    }
    //onOptionsItemSelected(item) cria um evento de clique para o item selecionado do menú
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.menu01:
                    Intent intent = new Intent(MainActivity.this, SensorLuz.class);
                    startActivity(intent);

                break;

            case R.id.menu02:
                Intent intent2 = new Intent(MainActivity.this, Compartilhar.class);
                startActivity(intent2);

                break;

            case R.id.menu03:
               Intent intent3 = new Intent(MainActivity.this, BancoDados.class);
                startActivity(intent3);

                break;

            case R.id.menu04:
               Intent intent4 = new Intent(MainActivity.this, Mapa.class);
               startActivity(intent4);

                break;

            case R.id.menu05:
                Intent intent5 = new Intent(MainActivity.this, Bhaskara.class);
                startActivity(intent5);

                break;


            case R.id.menu06:
                Intent intent6 = new Intent(MainActivity.this, Jokenpo.class);
                startActivity(intent6);

                break;

            case R.id.menu07:
                Intent intent7 = new Intent(MainActivity.this, Informacoes.class);
                startActivity(intent7);

                break;

        }

        return super.onOptionsItemSelected(item);
    }

}