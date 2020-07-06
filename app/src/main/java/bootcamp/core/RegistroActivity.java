package bootcamp.core;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RegistroActivity extends AppCompatActivity {
    Button btnRegistro, btnAceptar;
    RadioButton rbtDama, rbtCaballero;
    CheckBox chkTerminos;
    TextView tvTerminos;
    LinearLayout llayContenedor;
    EditText etDni, etNombres, etApellidos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        btnRegistro = (Button) findViewById(R.id.btnRegistrarme);
        rbtCaballero = (RadioButton) findViewById(R.id.rbtCaballero);
        rbtDama = (RadioButton) findViewById(R.id.rbtDama);
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
                Toast.makeText(RegistroActivity.this, "Bienvenido a Core, en 24 horas se habilitará su cuenta",
                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(RegistroActivity.this, AccesoActivity.class);
                startActivity(intent);
                finish();
            }
        });
        rbtDama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rbtCaballero.setChecked(false);
                rbtDama.setChecked(true);
            }
        });
        rbtCaballero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rbtDama.setChecked(false);
                rbtCaballero.setChecked(true);
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
