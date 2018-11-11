package com.example.mandraski.helloworldandroid2.lista4;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mandraski.helloworldandroid2.R;

import static android.hardware.Sensor.TYPE_ACCELEROMETER;

public class LightsaberActivity extends AppCompatActivity implements SensorEventListener {
    private TextView rawX, rawY, rawZ;
    private static final int TEMPO_UPDATE = 500;
    private SensorManager sensorManager;
    private Sensor acelerometro;
    private long ultimoupdate;
    private float variacao;
    private SoundPool soundPool;
    private int audioId;
    private float aceleracaoAnterior;
    private float aceleracaoReal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lightsaber);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        soundPool = new SoundPool(4, AudioManager.STREAM_MUSIC, 0);
        audioId = soundPool.load(LightsaberActivity.this, R.raw.laser, 1);

        rawX = findViewById(R.id.tvRawx);
        rawY = findViewById(R.id.tvRawy);
        rawZ = findViewById(R.id.tvRawz);

        aceleracaoReal = SensorManager.GRAVITY_EARTH;
        aceleracaoAnterior = SensorManager.GRAVITY_EARTH;
        variacao = 0.00f;

        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);

        if (null == (acelerometro = sensorManager
                .getDefaultSensor(Sensor.TYPE_ACCELEROMETER)))
            finish();


    }

    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, acelerometro, SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    protected void
    onPause() {
        sensorManager.unregisterListener(this);
        super.onPause();
    }


    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {

            long tempoAtual = System.currentTimeMillis();

            if (tempoAtual - ultimoupdate > TEMPO_UPDATE) {

                ultimoupdate = tempoAtual;


                float x = event.values[0];
                float y = event.values[1];
                float z = event.values[2];


                aceleracaoAnterior = aceleracaoReal;
                aceleracaoReal = (float) Math.sqrt((double) (x*x + y*y + z*z));
                float delta = aceleracaoReal - aceleracaoAnterior;
                variacao = variacao * 0.09f + delta;

                if (variacao > 5) {
                    soundPool.play(audioId, 1, 1, 1, 0, 1);
                    Toast.makeText(this, "Som do Sabre de luz", Toast.LENGTH_SHORT).show();
                }

                rawX.setText(Float.toString(x));
                rawY.setText(Float.toString(y));
                rawZ.setText(Float.toString(z));
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
