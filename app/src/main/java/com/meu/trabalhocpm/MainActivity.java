package com.meu.trabalhocpm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import com.google.android.material.snackbar.Snackbar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    //private Menu menu1, menu2, menu3, menu4, menu5, menu6;
    ImageView play;
    MediaPlayer tocar1;
    Timer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    tocar1 = MediaPlayer.create(this,R.raw.buttercup);
    tocar1.start();

    timer = new Timer();
    timer.schedule(new TimerTask() {
        @Override
        public void run() {
           tocar1.pause();
        }
    },20000);

    ImageView link = findViewById(R.id.imageView2);
    link.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Snackbar.make(view,"Funcionou",Snackbar.LENGTH_SHORT).show();
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse( "https://maisfmufiam.fmu.br/ui/?_ga=2.132418953.600463845.1584917867-1351460151.1584659294#/login")));
        }
    });
    play = findViewById(R.id.imagePlayPause);
    play.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (tocar1.isPlaying()){
                tocar1.pause();
                play.setImageResource(R.drawable.ic_smartf);
            }else{
                tocar1.start();
                play.setImageResource(R.drawable.ic_play);
            }
        }
    });

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
                Intent intent7 = new Intent(MainActivity.this, Temperatura.class);
                startActivity(intent7);
                break;
            case R.id.menu08:
                Intent intent8 = new Intent(MainActivity.this, Informacoes.class);
                startActivity(intent8);
                break;
            case R.id.menu10:
                Intent intent10 = new Intent(MainActivity.this, Pitagoras.class);
                startActivity(intent10);
                break;
            case R.id.menu09:
               finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {

        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
        dialog.setTitle("Selecione");
        dialog.setMessage("Deseja sair da aplicação?");
        dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                tocar1.stop();
                finish();
            }
        });
        dialog.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        dialog.create();
        dialog.show();
    }
}
/*

Eu escrevi um trecho de código que fornecerá ao usuário um prompt pedindo
que pressione a tecla Voltar novamente se quiser sair. Atualmente, tenho
meu código funcionando até certo ponto, mas sei que está mal escrito e presumo
que haja uma maneira melhor de fazê-lo. Quaisquer sugestões seriam úteis!

Código:

public void onBackPressed(){
    backpress = (backpress + 1);
    Toast.makeText(getApplicationContext(), " Press Back again to Exit ", Toast.LENGTH_SHORT).show();

    if (backpress>1) {
        this.finish();
    }
}

*/