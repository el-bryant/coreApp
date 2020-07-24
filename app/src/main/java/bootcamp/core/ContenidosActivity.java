package bootcamp.core;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.kodmap.library.kmrecyclerviewstickyheader.KmRecyclerView;

public class ContenidosActivity extends AppCompatActivity {
    KmRecyclerView krvContenidos;
    static String idBootcamp = "";
    TextView tvTitulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contenidos);
        if (getIntent().getExtras() != null) {
            idBootcamp = getIntent().getStringExtra("id_bootcamp");
        }
        initComponents();
    }

    public void initComponents() {
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ContenidosActivity.this, CategoriaActivity.class);
        startActivity(intent);
        finish();
    }
}