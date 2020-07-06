package bootcamp.core;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AccesoActivity extends AppCompatActivity {
    TextView tvRegistro;
    Button btnAcceder;
    EditText etNombreUsuario, etClave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceso);
        tvRegistro = (TextView) findViewById(R.id.tvRegistro);
        btnAcceder = (Button) findViewById(R.id.btnAcceder);
        etNombreUsuario = (EditText) findViewById(R.id.etNombreUsuario);
        etClave = (EditText) findViewById(R.id.etClave);
        tvRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AccesoActivity.this, RegistroActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btnAcceder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AccesoActivity.this, "Bienvenido de nuevo", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(AccesoActivity.this, CategoriaActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}