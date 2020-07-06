package bootcamp.core;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RegistroActivity extends AppCompatActivity {
    Button btnRegistro, btnAceptar;
    CheckBox chkTerminos;
    TextView tvTerminos;
    LinearLayout llayContenedor;
    EditText etDni, etNombres, etApellidos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        btnRegistro = (Button) findViewById(R.id.btnRegistrarme);
        chkTerminos = (CheckBox) findViewById(R.id.chkTerminos);
        tvTerminos = (TextView) findViewById(R.id.tvTerminos);
        llayContenedor = (LinearLayout) findViewById(R.id.llayContenedor);
        btnAceptar = (Button) findViewById(R.id.btnAceptar);
        etDni = (EditText) findViewById(R.id.etDni);
        etApellidos = (EditText) findViewById(R.id.etApellidos);
        etNombres = (EditText) findViewById(R.id.etNombres);
        String dni = getIntent().getStringExtra("dni");
        String nombres = getIntent().getStringExtra("nombres");
        etDni.setText(dni);
        etApellidos.setText(nombres);
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
    }
}
