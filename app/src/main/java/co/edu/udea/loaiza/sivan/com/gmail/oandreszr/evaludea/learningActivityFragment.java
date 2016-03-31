package co.edu.udea.loaiza.sivan.com.gmail.oandreszr.evaludea;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class learningActivityFragment extends Fragment {


    Button buttonAnterior, buttonSiguiente, buttonRespuesta;
    TextView textViewResputa;
    boolean answerInvisible = true;
    View view;

    public learningActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_learning, container, false);
        this.buttonAnterior = (Button) view.findViewById(R.id.learningButton1);
        this.buttonSiguiente = (Button) view.findViewById(R.id.learningButton2);
        this.buttonRespuesta = (Button) view.findViewById(R.id.learningButton3);
        this.textViewResputa = (TextView) view.findViewById(R.id.learningTextView6);

        buttonAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {onClickAnterior(view);          }
        });
        buttonSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickSiguiente(view);
            }
        });
        buttonRespuesta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickRespuesta(view);
            }
        });
        return view;
    }

    public void onClickAnterior(View view) {
        Intent intent = new Intent(getActivity(), MainActivity.class);
        startActivity(intent);
        getActivity().finish();
    }

    public void onClickSiguiente(View view) {

    }

    public void onClickRespuesta(View view) {
        if(answerInvisible){
            answerInvisible = false;
            textViewResputa.setVisibility(view.VISIBLE);
        }else{
            answerInvisible = true;
            textViewResputa.setVisibility(view.GONE);
        }
    }

}
