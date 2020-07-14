package bootcamp.core;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import com.google.android.material.navigation.NavigationView;
import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import bootcamp.core.adapter.WheelImageAdapter;
import bootcamp.core.data.ImageData;
import github.hellocsl.cursorwheel.CursorWheelLayout;

public class CategoriaActivity extends AppCompatActivity implements CursorWheelLayout.OnMenuSelectedListener, NavigationView.OnNavigationItemSelectedListener {
    String nombres[] = {"categoría 1", "categoría 2", "categoría 3", "categoria 4", "catogoría 5"};
    CircleMenu cmCategoria;
    CursorWheelLayout wheel_image;
    List<ImageData> lstImage;
    DrawerLayout drawer;
    ImageView ivMenu;
    NavigationView nvMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        initViews();
        loadData();
        wheel_image.setOnMenuSelectedListener(this);

        //buscar objetos(componentes)
        drawer = (DrawerLayout) findViewById(R.id.dlMenu);
        ivMenu = (ImageView) findViewById(R.id.ivMenu);
        nvMenu = (NavigationView) findViewById(R.id.nvMenu);

        ivMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer.openDrawer(GravityCompat.START);
            }
        });
        nvMenu.setNavigationItemSelectedListener(this);
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
        lstImage.add(new ImageData(R.drawable.ic_android, "Bootcamp Android Developer"));
        lstImage.add(new ImageData(R.drawable.ic_excel, "Bootcamp Excel Pro"));
        lstImage.add(new ImageData(R.drawable.ic_java, "Desarrollo en Java para escritorio"));
        lstImage.add(new ImageData(R.drawable.ic_web, "Bootcamp diseñador web"));
        lstImage.add(new ImageData(R.drawable.ic_office, "Office Bootcamp"));
        lstImage.add(new ImageData(R.drawable.ic_hacking, "Hacking ético"));
        WheelImageAdapter adapter = new WheelImageAdapter(this, lstImage);
        wheel_image.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(CursorWheelLayout parent, View view, int pos) {
        if (parent.getId() == R.id.wheel_image) {
            Toast.makeText(this, "Selected: " + lstImage.get(pos).imageDescription, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        Intent intent;
        switch (id) {
            case R.id.nav_inicio:
                intent = new Intent(CategoriaActivity.this, CategoriaActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.nav_perfil:
                intent = new Intent(CategoriaActivity.this, PerfilActivity.class);
                startActivity(intent);
                finish();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}