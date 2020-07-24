package bootcamp.core;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.andexert.library.RippleView;
import com.google.android.material.navigation.NavigationView;
import org.json.JSONArray;
import java.util.ArrayList;
import bootcamp.core.adapter.WheelImageAdapter;
import bootcamp.core.entity.Bootcamp;
import bootcamp.core.publico.PrefUtil;
import github.hellocsl.cursorwheel.CursorWheelLayout;
import static bootcamp.core.publico.Funciones.primero;
import static bootcamp.core.publico.Funciones.segundo;

public class CategoriaActivity extends AppCompatActivity implements CursorWheelLayout.OnMenuSelectedListener, NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    ArrayList<Bootcamp> lstImage;
    Button btnMasInformacion;
    CursorWheelLayout wheel_image;
    DrawerLayout drawer;
    ImageView ivMenu;
    NavigationView nvMenu;
    PrefUtil prefUtil;
    RippleView rpvMasInformacion;
    static String idBootcamp = "";
    TextView tvDescripcion, tvNombreBootcamp;
    LinearLayout llayCerrarSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        prefUtil = new PrefUtil(CategoriaActivity.this);
        initComponents();
        initListener();
        cargarBootcamps();
        tvDescripcion.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                animacion(tvDescripcion);
            }
            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
        tvNombreBootcamp.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                animacion(tvNombreBootcamp);
                btnMasInformacion.setVisibility(View.VISIBLE);

            }
            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
        rpvMasInformacion.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {
            @Override
            public void onComplete(RippleView rippleView) {
                Log.d("CategoriaActivity", "rpvMasInformacion completed");
            }
        });
    }

    public void initComponents() {
        btnMasInformacion = (Button) findViewById(R.id.btnMasInformacion);
        drawer = (DrawerLayout) findViewById(R.id.dlMenu);
        ivMenu = (ImageView) findViewById(R.id.ivMenu);
        llayCerrarSesion = (LinearLayout) findViewById(R.id.llayCerrarSesion);
        nvMenu = (NavigationView) findViewById(R.id.nvMenu);
        rpvMasInformacion = (RippleView) findViewById(R.id.rpvmasInformacion);
        tvDescripcion = (TextView) findViewById(R.id.tvDescripcion);
        tvNombreBootcamp = (TextView) findViewById(R.id.tvNombreBootcamp);
        wheel_image = (CursorWheelLayout) findViewById(R.id.wheel_image);
    }

    public void initListener() {
        btnMasInformacion.setOnClickListener(this);
        ivMenu.setOnClickListener(this);
        llayCerrarSesion.setOnClickListener(this);
        nvMenu.setNavigationItemSelectedListener(this);
    }

    public void cargarBootcamps() {
        Log.i("cargarBootcamps", "CategoriaActivity");
        lstImage = new ArrayList<>();
        Thread tr = new Thread() {
            @Override
            public void run() {
                final String result = primero("https://bootcampdojo.com/core/wsApp/obtener_bootcamps.php");
                Log.i("cargarBootcamps", result);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        int r = segundo(result);
                        if (r > 0) {
                            try {
                                JSONArray jsonArray = new JSONArray(result);
                                if (jsonArray.length() > 0) {
                                    for (int i = 0; i < jsonArray.length(); i++) {
                                        idBootcamp = jsonArray.getJSONObject(i).getString("id_bootcamp");
                                        String nombre = jsonArray.getJSONObject(i).getString("nombre");
                                        String descripcion = jsonArray.getJSONObject(i).getString("descripcion");
                                        String icono = jsonArray.getJSONObject(i).getString("icono");
                                        String imagen = jsonArray.getJSONObject(i).getString("imagen");
                                        String idCategoria = jsonArray.getJSONObject(i).getString("id_categoria");
                                        lstImage.add(new Bootcamp(idBootcamp, nombre, descripcion, icono, imagen, idCategoria));
                                        WheelImageAdapter adapter = new WheelImageAdapter(CategoriaActivity.this, lstImage);
                                        wheel_image.setAdapter(adapter);
                                        wheel_image.setOnMenuSelectedListener(CategoriaActivity.this);
                                        wheel_image.setVisibility(View.VISIBLE);
                                    }
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
            }
        };
        tr.start();
    }

    @Override
    public void onItemSelected(CursorWheelLayout parent, View view, int pos) {
        if (parent.getId() == R.id.wheel_image) {
           tvDescripcion.setText(lstImage.get(pos).getDescripcion());
           tvNombreBootcamp.setText(lstImage.get(pos).getNombre());
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
            case R.id.nav_informacion:
                intent = new Intent(CategoriaActivity.this, ContenidosActivity.class);
                startActivity(intent);
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void animacion(View view) {
        ObjectAnimator animatorAlpha = ObjectAnimator.ofFloat(view, View.ALPHA, 0.0f, 1.0f);
        long animationDuration = 1000;
        animatorAlpha.setDuration(animationDuration);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(animatorAlpha);
        animatorSet.start();
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.btnMasInformacion:
                intent = new Intent(CategoriaActivity.this, ContenidosActivity.class);
                intent.putExtra("id_bootcamp", idBootcamp);
                startActivity(intent);
                finish();
                break;
            case R.id.ivMenu:
                drawer.openDrawer(GravityCompat.START);
                break;
            case R.id.llayCerrarSesion:
                prefUtil.clearAll();
                intent = new Intent(CategoriaActivity.this, AccesoActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}