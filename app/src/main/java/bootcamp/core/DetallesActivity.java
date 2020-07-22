package bootcamp.core;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import bootcamp.core.fragments.ContenidosFragment;
import bootcamp.core.fragments.EntrenadorFragment;

public class DetallesActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    FrameLayout flayContenedor;
    BottomNavigationView bnvMenuDetalle;
    ContenidosFragment contenidos;
    EntrenadorFragment entrenador;
    public static String texto = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);
        flayContenedor = (FrameLayout) findViewById(R.id.flayContenedor);
        bnvMenuDetalle = (BottomNavigationView) findViewById(R.id.bnvMenuDetalle);
        contenidos = new ContenidosFragment();
        entrenador = new EntrenadorFragment();
        bnvMenuDetalle.setOnNavigationItemSelectedListener(this);
        setFragment(contenidos);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_detalles:
                texto = "Detalles";
                setFragment(contenidos);
                break;
            case R.id.nav_entrenador:
                texto = "Entrenador";
                setFragment(entrenador);
                break;
        }
        return false;
    }

    public void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.flayContenedor, fragment);
        fragmentTransaction.commit();
    }
}