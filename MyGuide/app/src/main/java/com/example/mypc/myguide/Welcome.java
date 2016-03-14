package com.example.mypc.myguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 * Created by my pc on 3/11/2016.
 */
public class Welcome extends AppCompatActivity {
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.);
        //imageView=findViewById(R.id.);
        Animation animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.welcome_animation);
        imageView.setAnimation(animation);

        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                finish();
                startActivity(new Intent(getApplicationContext(),MainActivity.class));

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
