package edu.orangecoastcollege.cs273.tmorrissey1.northernlightsanimation;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class AnimationActivity extends AppCompatActivity {

    private AnimationDrawable frameAnim;
    private Animation rotateAnim;
    private Animation shakeAnim;
    private Animation customAnim;
    private ImageView lightsImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        lightsImageView = (ImageView) findViewById(R.id.lightsImageView);

    }

    public void toggleFrameAnim(View v) {
        // Programmatically set the background of image view to @drawable/lights1
        lightsImageView.setBackgroundResource(R.drawable.frame_anim);
        // Associate the frameAnim with the animation in xml
        frameAnim = (AnimationDrawable) lightsImageView.getBackground();
        // Start the animation
        if (frameAnim.isRunning())
            frameAnim.stop();

        else
            frameAnim.start();
    }

    public void toggleRotateAnim(View v) {

        rotateAnim = AnimationUtils.loadAnimation(this, R.anim.rotate_anim);
        if (rotateAnim.hasStarted() && rotateAnim != null) {
            lightsImageView.clearAnimation();
            rotateAnim = null;
        }
        else
            lightsImageView.startAnimation(rotateAnim);
    }

    public void toggleShakeAnim(View v) {
        shakeAnim = AnimationUtils.loadAnimation(this, R.anim.shake_anim);
        if (shakeAnim.hasStarted())
            lightsImageView.clearAnimation();
        else
            lightsImageView.startAnimation(shakeAnim);
    }
}
