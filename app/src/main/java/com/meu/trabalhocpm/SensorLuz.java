package com.meu.trabalhocpm;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class SensorLuz extends AppCompatActivity {

    private static TextView saida;
    private static ImageView fotos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_luz);
        getSupportActionBar().hide();

        fotos = findViewById(R.id.tela1);
        saida = findViewById(R.id.mostrar);
        SensorManager mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        List<Sensor> lista = mSensorManager.getSensorList(Sensor.TYPE_ALL);

        for(Sensor sensor: lista){
            System.out.println(sensor.getName());
        }

        Sensor sensor = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        mSensorManager.registerListener(new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                float luz = sensorEvent.values[0];
                saida.setText(""+ luz);

                if (luz == 0){
                    saida.setBackgroundResource(R.color.DeepPink);
                    fotos.setBackgroundResource(R.drawable.temperatura);
                }else if(luz > 0 && luz <= 100){
                    saida.setBackgroundResource(R.color.BurlyWood);
                    fotos.setBackgroundResource(R.drawable.bharkara);
                }else if(luz > 100 && luz <= 200){
                    saida.setBackgroundResource(R.color.green);
                    fotos.setBackgroundResource(R.drawable.sensor_luz);
                }else if(luz > 200 && luz <= 300){
                    saida.setBackgroundResource(R.color.PowderBlue);
                    fotos.setBackgroundResource(R.drawable.android);
                }else if(luz > 300 && luz <= 500){
                    saida.setBackgroundResource(R.color.teal_700);
                    fotos.setBackgroundResource(R.drawable.android2);
                }else if(luz > 500 && luz <= 700){
                    saida.setBackgroundResource(R.color.purple_700);
                    fotos.setBackgroundResource(R.drawable.fmu);
                }else if(luz > 700 && luz <= 1000){
                    saida.setBackgroundResource(R.color.Red);
                    fotos.setBackgroundResource(R.drawable.map);
                }else if(luz > 1000 && luz <= 1500){
                    saida.setBackgroundResource(R.color.purple_500);
                    fotos.setBackgroundResource(R.drawable.gravidade);
                }else if(luz > 1500 ){
                    saida.setBackgroundResource(R.color.Salmon);
                    fotos.setBackgroundResource(R.drawable.giroscopio);
                }else{
                    saida.setBackgroundResource(R.color.white);
                }

            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        }, sensor, SensorManager.SENSOR_DELAY_FASTEST);






    }
}