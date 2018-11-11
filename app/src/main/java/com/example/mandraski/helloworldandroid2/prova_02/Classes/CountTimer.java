package com.example.mandraski.helloworldandroid2.prova_02.Classes;

import android.content.Context;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.os.Handler;
import android.widget.Toast;

import java.util.List;

public class CountTimer  extends CountDownTimer {

    private List<com.example.mandraski.helloworldandroid2.prova_02.Classes.ButtonColor> listButtonColor;
    private List<Integer> listFase;
    private Integer positionFase;
    private Context contexto;

    public CountTimer(
        long millisInFuture,
        long countDownInterval,
        List<com.example.mandraski.helloworldandroid2.prova_02.Classes.ButtonColor> listButtonColor,
        List<Integer> listFase,
        Context contexto
    ) {
        super(millisInFuture, countDownInterval);
        this.listButtonColor = listButtonColor;
        this.listFase = listFase;
        this.positionFase = 0;
        this.contexto = contexto;
    }

//    public CountTimer(int millisInFuture, int countDownInterval, List<com.example.mandraski.helloworldandroid2.prova_02.Classes.ButtonColor> listButtonColor, List<Integer> listFase, Context applicationContext) {
//        super();
//    }

    @Override
    public void onTick(long millisUntilFinished) {
        if(positionFase == 4) { positionFase = 0; }

        com.example.mandraski.helloworldandroid2.prova_02.Classes.ButtonColor buttonColor = listButtonColor.get(listFase.get(positionFase) - 1);
        buttonColor.getButton().setBackgroundColor(buttonColor.getColor());

        positionFase++;
        setDefaultColor();
    }

    @Override
    public void onFinish() {
        Toast.makeText(contexto, "SUA VEZ DE JOGAR", Toast.LENGTH_LONG).show();
    }

    private void setDefaultColor() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Integer positionFaseMaisDois = positionFase;
                positionFaseMaisDois = positionFaseMaisDois - 1;

                ButtonColor buttonColor =  listButtonColor.get(listFase.get(positionFaseMaisDois) - 1);
                buttonColor.getButton().setBackgroundColor(Color.parseColor("#BBBBBB"));
            }
        }, 300);
    }
}
