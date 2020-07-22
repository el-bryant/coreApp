package bootcamp.core.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import bootcamp.core.DetallesActivity;
import bootcamp.core.R;

public class ContenidosFragment extends Fragment {
    TextView tvTexto;

    public ContenidosFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        container.removeView(getView());
        View view = inflater.inflate(R.layout.fragment_contenidos, container, false);
        initComponents(view);
        tvTexto.setText(DetallesActivity.texto);
        return view;
    }

    public void initComponents(View v) {
        tvTexto = (TextView) v.findViewById(R.id.tvTexto);
    }
}
