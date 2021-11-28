package com.meu.trabalhocpm;

import androidx.appcompat.app.AppCompatActivity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class Bhaskara extends AppCompatActivity {

    // bhaskara
    private EditText valorA, valorB, valorC;
    private TextView delta, x1linha, x2linha, reset;
    private Button calculo;
    //Apagar valores por gravidade
    private SensorManager mSensorManager;
    private float acceleration;
    private float currentAcceleration;
    private float lastAcceleration;
    private static final int ACCELERATION_THRESHOLD = 10000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bhaskara);

        valorA = findViewById(R.id.editA);
        valorB = findViewById(R.id.editB);
        valorC = findViewById(R.id.editC);
        delta = findViewById(R.id.raizDelta);
        x1linha = findViewById(R.id.x1linha);
        x2linha = findViewById(R.id.x2linha);
        calculo = findViewById(R.id.buttonCalc);
        reset = findViewById(R.id.textViewReset);

        Button buttonCalc = findViewById(R.id.buttonCalc);
        buttonCalc.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                String A = valorA.getText().toString();
                String B = valorB.getText().toString();
                String C = valorC.getText().toString();
                if(A.isEmpty() || B.isEmpty() || C.isEmpty()){
                    Snackbar.make(view,"A, B e C devem estar preenchidos",Snackbar.LENGTH_SHORT).show();
                }else{
                    double vlA = Double.parseDouble(String.valueOf(valorA.getText()));
                    double vlB = Double.parseDouble(String.valueOf(valorB.getText()));
                    double vlC = Double.parseDouble(String.valueOf(valorC.getText()));

                    double dlta = Math.pow(vlB,2)-(4*vlA*vlC);
                    double resultado = Math.sqrt(dlta) ;
                    double linha1 = (-vlB + resultado) / 2*vlA;
                    double linha2 = (-vlB - resultado) / 2*vlA;
                    delta.setText("Delta: "+ dlta+ " - Raiz de Delta: "+resultado);
                    x1linha.setText("X'  "+linha1);
                    x2linha.setText("X'' "+linha2);
                   reset.setText("Sacudir o aparelho para resetar");
                }
            }
        });

        //##################shake######################

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
                    valorA.setText("");
                     valorB.setText("");
                    valorC.setText("");
                    delta.setText("");
                    x1linha.setText("");
                    x2linha.setText("");
                    reset.setText("");
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        }, mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_FASTEST);


    }
}