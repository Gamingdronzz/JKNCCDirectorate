package com.jknccdirectorate.Activity;

import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.jknccdirectorate.R;

public class SplashScreen extends AppCompatActivity {

    Intent intent;

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window window = getWindow();
        window.setFormat(PixelFormat.RGBA_8888);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        StartAnimations();
        //nextActivity();
    }

    private void StartAnimations() {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
        anim.reset();
        RelativeLayout l = (RelativeLayout) findViewById(R.id.splash);
        l.clearAnimation();
        l.startAnimation(anim);

        Animation animationTranslate = AnimationUtils.loadAnimation(this, R.anim.translate);
        animationTranslate.reset();
        ImageView iv = (ImageView) findViewById(R.id.logo);
        iv.clearAnimation();
        iv.startAnimation(animationTranslate);

        animationTranslate.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                nextActivity();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
    private void nextActivity() {
        intent = new Intent(SplashScreen.this, MainActivity.class);
        startActivity(intent);
        finish();
        /*Thread thread = new Thread() {
            public void run() {
                super.run();
                try {
                    Thread.sleep(5000);
                } catch (Exception e1) {
                    e1.printStackTrace();
                } finally {

                }
            }
        };
        thread.start();
        */
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}

