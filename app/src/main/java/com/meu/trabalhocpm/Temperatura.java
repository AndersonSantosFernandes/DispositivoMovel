package com.meu.trabalhocpm;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class Temperatura extends AppCompatActivity {
    private EditText entraValor1;
    private TextView saida,msgOculta;
    private Button calcular;
    private RadioButton cpf, fpc;
    private SensorManager mSensorManager;
    private MediaPlayer convert, reset, cigarra;
    private float acceleration;
    private float currentAcceleration;
    private float lastAcceleration;
    private static final int ACCELERATION_THRESHOLD = 10000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperatura);
        convert = MediaPlayer.create(this,R.raw.win);
        reset = MediaPlayer.create(this,R.raw.empate);
        cigarra = MediaPlayer.create(this,R.raw.cigarra);
        entraValor1 = findViewById(R.id.valorTemperatura);
        saida = findViewById(R.id.saida);
        calcular = findViewById(R.id.buttonTemp);
        cpf = findViewById(R.id.radioCPF);
        fpc = findViewById(R.id.radioFPC);
        msgOculta = findViewById(R.id.sacudir);
        Button btCalc = findViewById(R.id.buttonTemp);
        btCalc.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                String valor = entraValor1.getText().toString();
                if(valor.isEmpty()){
                    Snackbar.make(view,"Insira um valor para conversão",Snackbar.LENGTH_SHORT).show();
                }else{
                    double input = Double.parseDouble(String.valueOf(entraValor1.getText()));
                    double farenheit;
                    double celcius;
                    //(32 °F − 32) × 5/9 = 0 °C
                    // (0 °C × 9/5) + 32 = 32 °F
                    if (cpf.isChecked()){
                        farenheit = (input * 9/5) +32;
                        saida.setText(input+" graus celcius equivalem a\n "+farenheit+" farenheit");
                        msgOculta.setText("Sacudir para limpar dados");
                        convert.start();
                    }else if (fpc.isChecked()){
                        celcius = (input - 32)* 5/9;
                        saida.setText(input+ " fahrenheit equivalem a "+celcius+" graus celcius");
                        msgOculta.setText("Sacudir para limpar dados");
                        convert.start();
                    }else{
                        Snackbar.make(view,"Escolha um modo de conversão",Snackbar.LENGTH_SHORT).show();
                        cigarra.start();
                    }

                }
            }
        });
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mSensorManager.registerListener(new SensorEventListener() {
                @Override
                public void onSensorChanged(SensorEvent sensorEvent) {
                    float x = sensorEvent.values[0];
                    float y = sensorEvent.values[1];
                    float z = sensorEvent.values[2];
                    lastAcceleration = currentAcceleration;
                    currentAcceleration =  x * x + y * y + z * z;
                    acceleration = currentAcceleration * (currentAcceleration - lastAcceleration);
                    if ( acceleration > ACCELERATION_THRESHOLD ) {
                        entraValor1.setText("");
                        saida.setText("");
                        msgOculta.setText("");
                        reset.start();
                    }
                }
                @Override
                public void onAccuracyChanged(Sensor sensor, int i) {
                }
            }, mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
        SensorManager.SENSOR_DELAY_FASTEST);
    }
    @Override
    public void onBackPressed(){
        reset.stop();
        convert.stop();
        cigarra.stop();
        super.onBackPressed();
    }
}