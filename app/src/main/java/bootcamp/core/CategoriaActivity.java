package bootcamp.core;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;

import java.util.Timer;
import java.util.TimerTask;

public class CategoriaActivity extends AppCompatActivity {
    String nombres[] = {"categoría 1", "categoría 2", "categoría 3", "categoria 4", "catogoría 5"};
    CircleMenu cmCategoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria);
        cmCategoria = (CircleMenu) findViewById(R.id.cmCategoria);
        cmCategoria.setMainMenu(Color.parseColor("#ffff00"), R.drawable.ic_mas, R.drawable.ic_cerrar)
                .addSubMenu(Color.parseColor("#ffff00"), R.drawable.ic_camera)
                .addSubMenu(Color.parseColor("#fbb03b"), R.drawable.ic_candado)
                .addSubMenu(Color.parseColor("#333333"), R.drawable.ic_delete)
                .addSubMenu(Color.parseColor("#13101a"), R.drawable.ic_done)
                .addSubMenu(Color.parseColor("#e6e6e6"), R.drawable.ic_edit)
                .setOnMenuSelectedListener(new OnMenuSelectedListener() {
                    @Override
                    public void onMenuSelected(int index) {
                        Toast.makeText(CategoriaActivity.this, "Has seleccionado " + nombres[index],
                                Toast.LENGTH_SHORT).show();
                        CountDownTimer countDownTimer = new CountDownTimer(1500, 1000) {
                            @Override
                            public void onTick(long l) {
                            }
                            @Override
                            public void onFinish() {
                                Intent intent = new Intent(CategoriaActivity.this, RegistroActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        }.start();
                    }
                });
    }
}