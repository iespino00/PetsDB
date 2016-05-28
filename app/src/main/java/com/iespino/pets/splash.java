package com.iespino.pets;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

public class splash extends AppCompatActivity {

    protected boolean active = true;
    protected int splashTime = 1000;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);

        Thread splashThread = new Thread(){
            @Override
            public void run(){
                try{
                    int waited = 0;
                    while(active && (waited < splashTime)){
                        sleep(100);
                        if(active){
                            waited += 100;
                        }

                    }
                } catch(InterruptedException e){

                } finally{
                    finish();
                    openApp();

                }

            }
        };
        splashThread.start();
    }

    private void openApp(){

        startActivity(new Intent(this, MainActivity.class));
    }

}