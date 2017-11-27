package com.jknccdirectorate.Activity;

import android.content.Intent;
import android.graphics.PixelFormat;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jknccdirectorate.R;

public class SplashScreen extends AppCompatActivity {

    Intent intent;
    TextView textViewConceptBy;
    TextView textViewDesignedBy;

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window window = getWindow();
        window.setFormat(PixelFormat.RGBA_8888);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        textViewConceptBy = (TextView) findViewById(R.id.conceptBy);
        textViewDesignedBy = (TextView) findViewById(R.id.designedBy);
        textViewDesignedBy.setVisibility(View.INVISIBLE);
        textViewConceptBy.setVisibility(View.INVISIBLE);

        StartAnimations();
        //nextActivity();
    }



    private void StartAnimations() {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
        final Animation animationTranslate = AnimationUtils.loadAnimation(this, R.anim.translate);
        final Animation animScale = AnimationUtils.loadAnimation(this, R.anim.scale);

        animScale.reset();
        anim.reset();
        animationTranslate.reset();

        textViewDesignedBy.clearAnimation();
        textViewConceptBy.clearAnimation();

        LinearLayout layout = (LinearLayout) findViewById(R.id.layout);
        layout.clearAnimation();
        layout.startAnimation(anim);


        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                textViewConceptBy.setVisibility(View.VISIBLE);
                textViewConceptBy.startAnimation(animScale);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        animScale.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                textViewDesignedBy.setVisibility(View.VISIBLE);
                textViewDesignedBy.startAnimation(animationTranslate);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
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

