package com.jknccdirectorate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        nextActivity();
    }

    private void nextActivity() {
        intent = new Intent(SplashScreen.this, MainActivity.class);
        Thread thread = new Thread() {
            public void run() {
                super.run();
                try {
                    Thread.sleep(1000);
                } catch (Exception e1) {
                    e1.printStackTrace();
                } finally {
                    startActivity(intent);
                }
            }
        };
        thread.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}

