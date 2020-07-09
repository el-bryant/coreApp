package bootcamp.core;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import bootcamp.core.adapter.WheelImageAdapter;
import bootcamp.core.data.ImageData;
import github.hellocsl.cursorwheel.CursorWheelLayout;

public class CategoriaActivity extends AppCompatActivity implements CursorWheelLayout.OnMenuSelectedListener {
    String nombres[] = {"categoría 1", "categoría 2", "categoría 3", "categoria 4", "catogoría 5"};
    CircleMenu cmCategoria;
    CursorWheelLayout wheel_image;
    List<ImageData> lstImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria);
        initViews();
        loadData();
        wheel_image.setOnMenuSelectedListener(this);
//        cmCategoria = (CircleMenu) findViewById(R.id.cmCategoria);
//        cmCategoria.setMainMenu(Color.parseColor("#ffff00"), R.drawable.ic_mas, R.drawable.ic_cerrar)
//                .addSubMenu(Color.parseColor("#ffff00"), R.drawable.ic_camera)
//                .addSubMenu(Color.parseColor("#fbb03b"), R.drawable.ic_candado)
//                .addSubMenu(Color.parseColor("#333333"), R.drawable.ic_delete)
//                .addSubMenu(Color.parseColor("#13101a"), R.drawable.ic_done)
//                .addSubMenu(Color.parseColor("#e6e6e6"), R.drawable.ic_edit)
//                .setOnMenuSelectedListener(new OnMenuSelectedListener() {
//                    @Override
//                    public void onMenuSelected(int index) {
//                        Toast.makeText(CategoriaActivity.this, "Has seleccionado " + nombres[index],
//                                Toast.LENGTH_SHORT).show();
//                        CountDownTimer countDownTimer = new CountDownTimer(1500, 1000) {
//                            @Override
//                            public void onTick(long l) {
//                            }
//                            @Override
//                            public void onFinish() {
//                                Intent intent = new Intent(CategoriaActivity.this, RegistroActivity.class);
//                                startActivity(intent);
//                                finish();
//                            }
//                        }.start();
//                    }
//                });
    }

    public void initViews() {
        wheel_image = (CursorWheelLayout) findViewById(R.id.wheel_image);
    }

    public void loadData() {
        lstImage = new ArrayList<>();
        lstImage.add(new ImageData(R.drawable.ic_camera, "cámara"));
        lstImage.add(new ImageData(R.drawable.ic_candado, "candado"));
        lstImage.add(new ImageData(R.drawable.ic_cerrar, "cerrar"));
        lstImage.add(new ImageData(R.drawable.ic_delete, "delete"));
        lstImage.add(new ImageData(R.drawable.ic_done, "done"));
        lstImage.add(new ImageData(R.drawable.ic_edit, "edit"));
        WheelImageAdapter adapter = new WheelImageAdapter(this, lstImage);
        wheel_image.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(CursorWheelLayout parent, View view, int pos) {
        if (parent.getId() == R.id.wheel_image) {
            Toast.makeText(this, "Selected: " + lstImage.get(pos).imageDescription, Toast.LENGTH_SHORT).show();
        }
    }
}