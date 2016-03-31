package co.edu.udea.loaiza.sivan.com.gmail.oandreszr.evaludea;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A placeholder fragment containing a simple view.
 */
public class answersActivityFragment extends Fragment {

    Button buttonContinuar, buttonOmitidas, buttonMarcadas;
    View view;

    public answersActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_answers, container, false);

        this.buttonContinuar = (Button) view.findViewById(R.id.answersButtonContinuar);
        this.buttonOmitidas = (Button) view.findViewById(R.id.answersButtonOmitidas);
        this.buttonMarcadas = (Button) view.findViewById(R.id.answersButtonMarcadas);

        buttonContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {onClickContinuar(view);          }
        });
        buttonOmitidas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickOmitidas(view);
            }
        });
        buttonMarcadas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickMarcadas(view);
            }
        });

        return view;
    }

    public void onClickContinuar(View view) {
        Intent intent = new Intent(getActivity(), simulatorActivity.class);
        startActivity(intent);
        //getActivity().finish();
    }

    public void onClickOmitidas(View view) {

    }

    public void onClickMarcadas(View view) {

    }

}
