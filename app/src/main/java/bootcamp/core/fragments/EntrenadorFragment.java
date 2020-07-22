package bootcamp.core.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import bootcamp.core.DetallesActivity;
import bootcamp.core.R;

public class EntrenadorFragment extends Fragment {
    TextView tvTexto;

    public EntrenadorFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_entrenador, container, false);
        initComponents(view);
        tvTexto.setText(DetallesActivity.texto);
        return view;
    }

    public void initComponents(View view) {
        tvTexto = (TextView) view.findViewById(R.id.tvTexto);
    }
}
