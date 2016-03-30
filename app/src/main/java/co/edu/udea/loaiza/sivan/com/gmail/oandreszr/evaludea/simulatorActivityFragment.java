package co.edu.udea.loaiza.sivan.com.gmail.oandreszr.evaludea;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * A placeholder fragment containing a simple view.
 */
public class simulatorActivityFragment extends Fragment {

    Button buttonAnterior;
    Button buttonAceptar;
    Button buttonOmitir;

    public simulatorActivityFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_simulator, container, false);

        this.buttonAnterior = (Button) view.findViewById(R.id.simulatorButton1);
        this.buttonAceptar = (Button) view.findViewById(R.id.simulatorButton2);
        this.buttonOmitir = (Button) view.findViewById(R.id.simulatorButton3);

        buttonAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {onClickAnterior(view);          }
        });
        buttonAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickAceptar(view);
            }
        });
        buttonOmitir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickOmitir(view);
            }
        });

        return view;
    }

    public void onClickAnterior(View view) {
        Intent intent = new Intent(getActivity(), MainActivity.class);
        startActivity(intent);
    }

    public void onClickAceptar(View view) {
        Intent intent = new Intent(getActivity(), resultActivity.class);
        startActivity(intent);
    }

    public void onClickOmitir(View view) {
        Intent intent = new Intent(getActivity(), resultActivity.class);
        startActivity(intent);
    }

}
