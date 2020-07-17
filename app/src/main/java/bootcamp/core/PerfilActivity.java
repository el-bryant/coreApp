package bootcamp.core;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.material.navigation.NavigationView;
import static bootcamp.core.publico.Funciones.primero;
import static bootcamp.core.publico.Funciones.segundo;

public class PerfilActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    DrawerLayout drawer;
    EditText etNombres, etApellidoPaterno, etApellidoMaterno, etCelular, etCorreo, etDireccion;
    FrameLayout flayCargando;
    ImageView ivMenu, ivEditar, ivGuardar;
    NavigationView nvMenu;
    TextView tvNombres, tvApellidoPaterno, tvApellidoMaterno, tvCelular, tvCorreo, tvDireccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        initComponents();
        initListener();
        nvMenu.setNavigationItemSelectedListener(this);
    }

    private void initListener() {
        ivEditar.setOnClickListener(this);
        ivGuardar.setOnClickListener(this);
        ivMenu.setOnClickListener(this);
    }

    private void initComponents() {
        drawer = (DrawerLayout) findViewById(R.id.dlMenu);
        etApellidoMaterno = (EditText) findViewById(R.id.etApellidoMaterno);
        etApellidoPaterno = (EditText) findViewById(R.id.etApellidoPaterno);
        etCelular = (EditText) findViewById(R.id.etCelular);
        etCorreo = (EditText) findViewById(R.id.etCorreo);
        etDireccion = (EditText) findViewById(R.id.etDireccion);
        etNombres = (EditText) findViewById(R.id.etNombres);
        flayCargando = (FrameLayout) findViewById(R.id.flayCargando);
        ivEditar = (ImageView) findViewById(R.id.ivEditar);
        ivGuardar = (ImageView) findViewById(R.id.ivGuardar);
        ivMenu = (ImageView) findViewById(R.id.ivMenu);
        nvMenu = (NavigationView) findViewById(R.id.nvMenu);
        tvApellidoMaterno = (TextView) findViewById(R.id.tvApellidoMaterno);
        tvApellidoPaterno = (TextView) findViewById(R.id.tvApellidoPaterno);
        tvCelular = (TextView) findViewById(R.id.tvCelular);
        tvCorreo = (TextView) findViewById(R.id.tvCorreo);
        tvDireccion = (TextView) findViewById(R.id.tvDireccion);
        tvNombres = (TextView) findViewById(R.id.tvNombres);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        Intent intent;
        switch (id) {
            case R.id.nav_inicio:
                intent = new Intent(PerfilActivity.this, CategoriaActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.nav_perfil:
                intent = new Intent(PerfilActivity.this, PerfilActivity.class);
                startActivity(intent);
                finish();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
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
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ivMenu:
                drawer.openDrawer(GravityCompat.START);
                break;
            case R.id.ivEditar:
                etNombres.setVisibility(View.VISIBLE);
                etApellidoPaterno.setVisibility(View.VISIBLE);
                etApellidoMaterno.setVisibility(View.VISIBLE);
                etCelular.setVisibility(View.VISIBLE);
                etCorreo.setVisibility(View.VISIBLE);
                etDireccion.setVisibility(View.VISIBLE);
                ivGuardar.setVisibility(View.VISIBLE);
                tvNombres.setVisibility(View.GONE);
                tvApellidoPaterno.setVisibility(View.GONE);
                tvApellidoMaterno.setVisibility(View.GONE);
                tvCelular.setVisibility(View.GONE);
                tvCorreo.setVisibility(View.GONE);
                tvDireccion.setVisibility(View.GONE);
                ivEditar.setVisibility(View.GONE);
                break;
            case R.id.ivGuardar:
                flayCargando.setVisibility(View.VISIBLE);
                guardarCambios();
                break;
        }
    }

    public void guardarCambios() {
        Log.i("guardarCambios", "PerfilActivity");
        Thread tr = new Thread() {
            @Override
            public void run() {
                final String result = primero("https://bootcampdojo.com/core/wsApp/modificar_usuario.php?dni_usuario=" + "" + "&nombres=" + etNombres.getText().toString()
                        + "&apellido_paterno=" + etApellidoPaterno.getText().toString() + "&apellido_materno=" + etApellidoMaterno.getText().toString() + "&celular="
                        + etCelular.getText().toString() + "&correo=" + etCorreo.getText().toString() + "&direccion=" + etDireccion.getText().toString());
                Log.i("guardarCambios", result);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        int r = segundo(result);
                        if (r > 0) {
                            etNombres.setVisibility(View.GONE);
                            etApellidoPaterno.setVisibility(View.GONE);
                            etApellidoMaterno.setVisibility(View.GONE);
                            etCelular.setVisibility(View.GONE);
                            etCorreo.setVisibility(View.GONE);
                            etDireccion.setVisibility(View.GONE);
                            ivGuardar.setVisibility(View.GONE);
                            tvNombres.setVisibility(View.VISIBLE);
                            tvApellidoPaterno.setVisibility(View.VISIBLE);
                            tvApellidoMaterno.setVisibility(View.VISIBLE);
                            tvCelular.setVisibility(View.VISIBLE);
                            tvCorreo.setVisibility(View.VISIBLE);
                            tvDireccion.setVisibility(View.VISIBLE);
                            ivEditar.setVisibility(View.VISIBLE);
                            flayCargando.setVisibility(View.GONE);
                        }
                    }
                });
            }
        };
        tr.start();
    }
}