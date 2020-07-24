package bootcamp.core;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import org.json.JSONObject;

import static bootcamp.core.publico.Funciones.primero;
import static bootcamp.core.publico.Funciones.segundo;

public class RegistroActivity extends AppCompatActivity implements View.OnClickListener, View.OnFocusChangeListener {
    Button btnRegistro, btnAceptar;
    CheckBox chkTerminos;
    FrameLayout flayCargando;
    TextView tvTerminos;
    LinearLayout llayContenedor;
    ProgressBar pbCargando;
    TextInputEditText tietDni, tietApellidos, tietNombres, tietCelular, tietCorreo, tietDireccion;
    TextInputLayout tilDni, tilApellidos, tilNombres, tilCelular, tilCorreo, tilDireccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        initComponents();
        initListener();
        tietDni.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (tietDni.getText().length() == 8) {
                    flayCargando.setVisibility(View.VISIBLE);
                    validarDni();
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
        tietApellidos.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void afterTextChanged(Editable editable) {
                tietApellidos.setEnabled(false);
                tietNombres.setEnabled(false);
                flayCargando.setVisibility(View.GONE);
                tietCelular.requestFocus();
            }
        });
    }

    public void initComponents() {
        btnAceptar = (Button) findViewById(R.id.btnAceptar);
        btnRegistro = (Button) findViewById(R.id.btnRegistrarme);
        chkTerminos = (CheckBox) findViewById(R.id.chkTerminos);
        flayCargando = (FrameLayout) findViewById(R.id.flayCargando);
        llayContenedor = (LinearLayout) findViewById(R.id.llayContenedor);
        pbCargando = (ProgressBar) findViewById(R.id.pbCargando);
        tietApellidos = (TextInputEditText) findViewById(R.id.tietApellidos);
        tietCelular = (TextInputEditText) findViewById(R.id.tietCelular);
        tietCorreo = (TextInputEditText) findViewById(R.id.tietCorreo);
        tietDni = (TextInputEditText) findViewById(R.id.tietDni);
        tietDireccion = (TextInputEditText) findViewById(R.id.tietDireccion);
        tietNombres = (TextInputEditText) findViewById(R.id.tietNombres);
        tilApellidos = (TextInputLayout) findViewById(R.id.tilApellidos);
        tilCelular = (TextInputLayout) findViewById(R.id.tilCelular);
        tilCorreo = (TextInputLayout) findViewById(R.id.tilCorreo);
        tilDireccion = (TextInputLayout) findViewById(R.id.tilDireccion);
        tilDni = (TextInputLayout) findViewById(R.id.tilDni);
        tilNombres = (TextInputLayout) findViewById(R.id.tilNombres);
        tvTerminos = (TextView) findViewById(R.id.tvTerminos);
    }

    public void initListener() {
        btnAceptar.setOnClickListener(this);
        btnRegistro.setOnClickListener(this);
        chkTerminos.setOnClickListener(this);
        tvTerminos.setOnClickListener(this);
        btnAceptar.setOnClickListener(this);
        tietDni.setOnFocusChangeListener(this);
        tietApellidos.setOnFocusChangeListener(this);
        tietNombres.setOnFocusChangeListener(this);
        tietCelular.setOnFocusChangeListener(this);
        tietCorreo.setOnFocusChangeListener(this);
        tietDireccion.setOnFocusChangeListener(this);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(RegistroActivity.this, AccesoActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnRegistrarme:
                Toast.makeText(RegistroActivity.this, "Te damos la bienvenida como nuevo Kohai",
                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(RegistroActivity.this, CategoriaActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.chkTerminos:
                if (chkTerminos.isChecked()) {
                    btnRegistro.setEnabled(true);
                } else {
                    btnRegistro.setEnabled(false);
                }
                break;
            case R.id.tvTerminos:
                llayContenedor.setVisibility(View.VISIBLE);
                break;
            case R.id.btnAceptar:
                llayContenedor.setVisibility(View.GONE);
                break;
        }
    }

    @Override
    public void onFocusChange(View view, boolean b) {
        switch (view.getId()) {
            case R.id.tietDni:
                if (b) {
                    tilDni.setHelperText("Tu número de DNI");
                } else {
                    tilDni.setHelperText(" ");
                    if (tietDni.getText().toString().equals("")) {
                        tilDni.setError("DNI no puede quedar vacío");
                    } else if (tietDni.getText().toString().length() < 8) {
                        tilDni.setError("DNI debe contener 8 caracteres");
                    }
                }
                break;
            case R.id.tietApellidos:
                if (b) {
                    tilApellidos.setHelperText("Tus apellidos");
                } else {
                    tilApellidos.setHelperText(" ");
                    if (tietApellidos.getText().toString().equals("")) {
                        tilApellidos.setError("Sus apellidos son necesarios");
                    }
                }
                break;
            case R.id.tietNombres:
                if (tietNombres.isFocused()) {
                    tilNombres.setHelperText("Tus nombres");
                } else {
                    tilNombres.setHelperText(" ");
                    if (tietNombres.getText().toString().equals("")) {
                        tilNombres.setError("Sus nombres son necesarios");
                    }
                }
                break;
            case R.id.tietCelular:
                if (tietCelular.isFocused()) {
                    tilCelular.setHelperText("Tu número de celular");
                } else {
                    tilCelular.setHelperText(" ");
                    if (tietCelular.getText().toString().equals("")) {
                        tilCelular.setError("Celular es obligatorio");
                    } else if (tietCelular.getText().toString().length() < 9) {
                        tilCelular.setError("Celular debe contener 9 caracteres");
                    }
                }
                break;
            case R.id.tietCorreo:
                if (tietCorreo.isFocused()) {
                    tilCorreo.setHelperText("Tu correo electrónico Gmail/Hotmail/Outlook");
                } else {
                    tilCorreo.setHelperText(" ");
                    if (tietCorreo.getText().toString().equals("")) {
                        tilCorreo.setError("Necesitamos tu correo electrónico");
                    }
                }
                break;
            case R.id.tietDireccion:
                if (tietDireccion.isFocused()) {
                    tilDireccion.setHelperText("La dirección de tu actual domicilio");
                } else {
                    tilDireccion.setHelperText(" ");
                    if (tietDireccion.getText().toString().equals("")) {
                        tilDireccion.setError("Es necesario para el registro");
                    }
                }
                break;
        }
    }

    public void validarDni() {
        Log.i("validarDni", "RegistroActivity");
        Thread tr = new Thread() {
            @Override
            public void run() {
                final String result = primero("https://bootcampdojo.com/consulta_dni.php?dni=" + tietDni.getText().toString());
                Log.i("validarDni", result);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        int r = segundo(result);
                        if (r > 0) {
                            try {
                                JSONObject jsonObject = new JSONObject(result);
                                if (jsonObject.length() > 0) {
                                    String apellidoPaterno = jsonObject.getString("apellido_paterno");
                                    String apellidoMaterno = jsonObject.getString("apellido_materno");
                                    String nombres = jsonObject.getString("nombres");
                                    tietApellidos.setText(apellidoPaterno + " " + apellidoMaterno);
                                    tietNombres.setText(nombres);
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

    //guardar datos para persistencia (evitar que se pierdan)
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        String dni = tietDni.getText().toString();
        String apellidos = tietApellidos.getText().toString();
        String nombres = tietNombres.getText().toString();
        String celular = tietCelular.getText().toString();
        String correo = tietCorreo.getText().toString();
        String direccion = tietDireccion.getText().toString();
        outState.putString("dni", dni);
        outState.putString("apellidos", apellidos);
        outState.putString("nombres", nombres);
        outState.putString("celular", celular);
        outState.putString("correo", correo);
        outState.putString("direccion", direccion);
    }

    //recuperar datos de persistencia (evitar que se pierdan)
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        tietDni.setText(savedInstanceState.getString("dni"));
        tietApellidos.setText(savedInstanceState.getString("apellidos"));
        tietNombres.setText(savedInstanceState.getString("nombres"));
        tietCelular.setText(savedInstanceState.getString("celular"));
        tietCorreo.setText(savedInstanceState.getString("correo"));
        tietDireccion.setText(savedInstanceState.getString("direccion"));
    }
}
