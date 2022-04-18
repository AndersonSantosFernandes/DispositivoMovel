package com.meu.trabalhocpm;


import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Informacoes extends AppCompatActivity {
    private MediaPlayer informacoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacoes);
    informacoes = MediaPlayer.create(this,R.raw.pumpupkicks);
    informacoes.start();

    ImageView tocaPausa = findViewById(R.id.imageTocaPausa);

    tocaPausa.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(informacoes.isPlaying()){
                informacoes.pause();
                tocaPausa.setImageResource(R.drawable.ic_smartf);
            }else{
                informacoes.start();
                tocaPausa.setImageResource(R.drawable.ic_play);

            }
        }
    });


    }
    @Override
    public void onBackPressed() {

       informacoes.stop();
       super.onBackPressed();
    }
}