package bootcamp.core;

import androidx.appcompat.app.AppCompatActivity;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import bootcamp.core.publico.PrefUtil;

public class SplashActivity extends AppCompatActivity {
    ImageView ivSplash;
    PrefUtil prefUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        prefUtil = new PrefUtil(SplashActivity.this);
        ivSplash = (ImageView) findViewById(R.id.ivSplash);
        CountDownTimer countDownTimer = new CountDownTimer(3000, 1000) {
            @Override
            public void onTick(long l) {
                if (l > 2500) {
                    ObjectAnimator animatorAlpha = ObjectAnimator.ofFloat(ivSplash, View.ALPHA, 0.0f, 1.0f);
                    long animationDuration = 2000;
                    animatorAlpha.setDuration(animationDuration);
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.play(animatorAlpha);
                    animatorSet.start();
                }
            }
            @Override
            public void onFinish() {
                if (prefUtil.getStringValue(PrefUtil.LOGIN_STATUS).equals("1")) {
                    Intent intent = new Intent(SplashActivity.this, CategoriaActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Intent intent = new Intent(SplashActivity.this, AccesoActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        };
        countDownTimer.start();
    }
}