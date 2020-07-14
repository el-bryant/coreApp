package bootcamp.core;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class RegistroActivity extends AppCompatActivity {
    Button btnRegistro, btnAceptar;
    CheckBox chkTerminos;
    TextView tvTerminos;
    LinearLayout llayContenedor;
    TextInputEditText tietDni, tietApellidos, tietNombres, tietCelular, tietCorreo, tietDireccion;
    TextInputLayout tilDni, tilApellidos, tilNombres, tilCelular, tilCorreo, tilDireccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        btnRegistro = (Button) findViewById(R.id.btnRegistrarme);
        chkTerminos = (CheckBox) findViewById(R.id.chkTerminos);
        tvTerminos = (TextView) findViewById(R.id.tvTerminos);
        llayContenedor = (LinearLayout) findViewById(R.id.llayContenedor);
        btnAceptar = (Button) findViewById(R.id.btnAceptar);
        tietDni = (TextInputEditText) findViewById(R.id.tietDni);
        tietApellidos = (TextInputEditText) findViewById(R.id.tietApellidos);
        tietNombres = (TextInputEditText) findViewById(R.id.tietNombres);
        tietCelular = (TextInputEditText) findViewById(R.id.tietCelular);
        tietCorreo = (TextInputEditText) findViewById(R.id.tietCorreo);
        tietDireccion = (TextInputEditText) findViewById(R.id.tietDireccion);
        tilDni = (TextInputLayout) findViewById(R.id.tilDni);
        tilApellidos = (TextInputLayout) findViewById(R.id.tilApellidos);
        tilNombres = (TextInputLayout) findViewById(R.id.tilNombres);
        tilCelular = (TextInputLayout) findViewById(R.id.tilCelular);
        tilCorreo = (TextInputLayout) findViewById(R.id.tilCorreo);
        tilDireccion = (TextInputLayout) findViewById(R.id.tilDireccion);
        String dni = getIntent().getStringExtra("dni");
        String nombres = getIntent().getStringExtra("nombres");
        tietDni.setText(dni);
        tietApellidos.setText(nombres);
        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(RegistroActivity.this, "Te damos la bienvenida como nuevo Kohai",
                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(RegistroActivity.this, CategoriaActivity.class);
                startActivity(intent);
                finish();
            }
        });
        chkTerminos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (chkTerminos.isChecked()) {
                    btnRegistro.setEnabled(true);
                } else {
                    btnRegistro.setEnabled(false);
                }
            }
        });
        tvTerminos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                llayContenedor.setVisibility(View.VISIBLE);
            }
        });
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                llayContenedor.setVisibility(View.GONE);
            }
        });
        tietDni.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (tietDni.isFocused()) {
                    tilDni.setHelperText("Tu número de DNI");
                } else {
                    tilDni.setHelperText(" ");
                    if (tietDni.getText().toString().equals("")) {
                        tilDni.setError("DNI no puede quedar vacío");
                    } else if (tietDni.getText().toString().length() < 8) {
                        tilDni.setError("DNI debe contener 8 caracteres");
                    }
                }
            }
        });
        tietApellidos.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (tietApellidos.isFocused()) {
                    tilApellidos.setHelperText("Tus apellidos");
                } else {
                    tilApellidos.setHelperText(" ");
                    if (tietApellidos.getText().toString().equals("")) {
                        tilApellidos.setError("Sus apellidos son necesarios");
                    }
                }
            }
        });
        tietNombres.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (tietNombres.isFocused()) {
                    tilNombres.setHelperText("Tus nombres");
                } else {
                    tilNombres.setHelperText(" ");
                    if (tietNombres.getText().toString().equals("")) {
                        tilNombres.setError("Sus nombres son necesarios");
                    }
                }
            }
        });
        tietCelular.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
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
            }
        });
        tietCorreo.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (tietCorreo.isFocused()) {
                    tilCorreo.setHelperText("Tu correo electrónico Gmail/Hotmail/Outlook");
                } else {
                    tilCorreo.setHelperText(" ");
                    if (tietCorreo.getText().toString().equals("")) {
                        tilCorreo.setError("Necesitamos tu correo electrónico");
                    }
                }
            }
        });
        tietDireccion.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (tietDireccion.isFocused()) {
                    tilDireccion.setHelperText("La dirección de tu actual domicilio");
                } else {
                    tilDireccion.setHelperText(" ");
                    if (tietDireccion.getText().toString().equals("")) {
                        tilDireccion.setError("Es necesario para el registro");
                    }
                }
            }
        });
    }
}
