package com.meu.trabalhocpm;

import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;
import com.google.android.material.snackbar.Snackbar;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class Jokenpo extends AppCompatActivity {

    private TextView saida, saida2, homem, computador, test;
    private RadioButton pedra, papel, tesoura;
    private ImageView jogador1, oponente1;
    private ScrollView fundo;
    private MediaPlayer ganhar, perder, empatar, aplaudir, vaiar, win;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokenpo);
        Objects.requireNonNull(getSupportActionBar()).hide();
        ganhar = MediaPlayer.create(this,R.raw.games01);
        perder = MediaPlayer.create(this,R.raw.games02);
        empatar = MediaPlayer.create(this,R.raw.empate);
        aplaudir = MediaPlayer.create(this,R.raw.applausos);
        vaiar = MediaPlayer.create(this,R.raw.vaia);
        win = MediaPlayer.create(this,R.raw.win);
        IniciarComponentes();
        test = findViewById(R.id.teste);
        saida = findViewById(R.id.resposta);
        saida2 = findViewById(R.id.saida2);
        pedra = findViewById(R.id.radioPedra);
        papel = findViewById(R.id.radioPapel);
        tesoura = findViewById(R.id.radioTesoura);
        jogador1 = findViewById(R.id.imageJogador);
        oponente1 = findViewById(R.id.imageOponente);
        homem = findViewById(R.id.pontoJog);
        computador = findViewById(R.id.pontoMaq);
        fundo = findViewById(R.id.scroll);

        String fala = "Vamos tentar denovo" , perde = "Perdeu", ganha = "Ganhou", empate = "Jogamos iguais camarada";
        String stoneWin = "Quebrou minha tesoura", stoneLoss = "Embrulhei sua pedra";
        String paperWin = "Embrulhou minha pedra", paperLoss = "Cortei seu papel";
        String cutWin = "Cortou meu papel", cutLoss = "Quebrei sua tesoura";
        String reset1 = "Quer tentar novamente?", reset2 = "Vamos ver quem ganha!";
        final int[] ptjog = {0};
        final int[] ptmaq = {0};
        AtomicBoolean menu = new AtomicBoolean(false);
        //Pegando o Id do botão
        Button btPlay = findViewById(R.id.btJoga);
        //Todo código é executado quando o botão é pressionado
        btPlay.setOnClickListener(view -> {
            //inicio do botão
            Random random = new Random();

            int player, maquina;
            if(menu.get() == false) {

                if (pedra.isChecked()) {
                    jogador1.setBackgroundResource(R.drawable.pedra);
                    maquina = random.nextInt(3);
                    player = 0;
                    if (player == maquina) {
                        oponente1.setBackgroundResource(R.drawable.pedra);
                        saida.setText(empate);
                        saida2.setText(fala);
                        fundo.setBackgroundResource(R.color.gray);
                        empatar.start();
                    } else if (maquina == 1) {
                        oponente1.setBackgroundResource(R.drawable.papel);
                        saida.setText(perde);
                        saida2.setText(stoneLoss);
                        fundo.setBackgroundResource(R.color.red);
                        ptmaq[0] = ptmaq[0] + 1;
                        computador.setText("" + ptmaq[0]);
                        perder.start();
                    } else if (maquina == 2) {
                        oponente1.setBackgroundResource(R.drawable.tesoura);
                        saida.setText(ganha);
                        saida2.setText(stoneWin);
                        fundo.setBackgroundResource(R.color.green);
                        ptjog[0] = ptjog[0] + 1;
                        homem.setText("" + ptjog[0]);
                        ganhar.start();
                    }

                } else if (papel.isChecked()) {
                    jogador1.setBackgroundResource(R.drawable.papel);
                    maquina = random.nextInt(3);
                    player = 1;
                    if (player == maquina) {
                        oponente1.setBackgroundResource(R.drawable.papel);
                        saida.setText(empate);
                        saida2.setText(fala);
                        fundo.setBackgroundResource(R.color.gray);
                        empatar.start();
                    } else if (maquina == 0) {
                        oponente1.setBackgroundResource(R.drawable.pedra);
                        saida.setText(ganha);
                        saida2.setText(paperWin);
                        fundo.setBackgroundResource(R.color.green);
                        ptjog[0] = ptjog[0] + 1;
                        homem.setText("" + ptjog[0]);
                        ganhar.start();
                    } else if (maquina == 2) {
                        oponente1.setBackgroundResource(R.drawable.tesoura);
                        saida.setText(perde);
                        saida2.setText(paperLoss);
                        fundo.setBackgroundResource(R.color.red);
                        ptmaq[0] = ptmaq[0] + 1;
                        computador.setText("" + ptmaq[0]);
                        perder.start();
                    }
                    //0=pedra
                    //1=papel
                    //2=tesoura
                } else if (tesoura.isChecked()) {
                    jogador1.setBackgroundResource(R.drawable.tesoura);
                    maquina = random.nextInt(3);
                    player = 2;
                    if (player == maquina) {
                        oponente1.setBackgroundResource(R.drawable.tesoura);
                        saida.setText(empate);
                        saida2.setText(fala);
                        fundo.setBackgroundResource(R.color.gray);
                        empatar.start();
                    } else if (maquina == 1) {
                        oponente1.setBackgroundResource(R.drawable.papel);
                        saida.setText(ganha);
                        saida2.setText(cutWin);
                        fundo.setBackgroundResource(R.color.green);
                        ptjog[0] = ptjog[0] + 1;
                        homem.setText("" + ptjog[0]);
                        ganhar.start();
                    } else if (maquina == 0) {
                        oponente1.setBackgroundResource(R.drawable.pedra);
                        saida.setText(perde);
                        saida2.setText(cutLoss);
                        fundo.setBackgroundResource(R.color.red);
                        ptmaq[0] = ptmaq[0] + 1;
                        computador.setText("" + ptmaq[0]);
                        perder.start();
                    }

                } else {
                    Snackbar.make(view, "Escolha pedra papel ou tesoura", Snackbar.LENGTH_SHORT).show();

                }
                if (ptjog[0] == 10 ){
                    menu.set(true);
                    saida2.setText("Jogador ganhou de "+ ptjog[0]+" a "+ptmaq[0]);
                    computador.setText("X");
                    homem.setText("X");
                    test.setText("Reset");
                    aplaudir.start();
                    // test.setBackgroundResource(R.drawable.ic_launcher_background);
                }else if (ptmaq[0] ==10 ){
                    menu.set(true);
                    saida2.setText("Máquina ganhou de "+ptmaq[0]+" a "+ptjog[0]);
                    computador.setText("X");
                    homem.setText("X");
                    test.setText("Reset");
                    vaiar.start();
                    // test.setBackgroundResource(R.drawable.ic_launcher_background);
                }
            }

            //fim do botão
        });
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                menu.set(false);
                computador.setText("0");
                homem.setText("0");
                ptmaq[0]=0;
                ptjog[0]=0;
                test.setText("");
                saida.setText(reset1);
                saida2.setText(reset2);
                fundo.setBackgroundResource(R.color.gray);
                win.start();
            }
        });
    }
    private void IniciarComponentes(){
        test = findViewById(R.id.teste);
    }
}