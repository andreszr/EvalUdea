package co.edu.udea.loaiza.sivan.com.gmail.oandreszr.evaludea;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.Rect;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

/**
 * A placeholder fragment containing a simple view.
 */
public class simulatorActivityFragment extends Fragment {

    Button buttonAnterior, buttonSiguiente, buttonFinalizar;
    RadioGroup radioGroup;
    RadioButton RadioButton1, RadioButton2, RadioButton3, RadioButton4;
    View view;

    public simulatorActivityFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_simulator, container, false);

        this.radioGroup = (RadioGroup) view.findViewById(R.id.simulatorRadioGroup);
        this.RadioButton1 = (RadioButton) view.findViewById(R.id.simulatorRadioButton1);
        this.RadioButton2 = (RadioButton) view.findViewById(R.id.simulatorRadioButton2);
        this.RadioButton3 = (RadioButton) view.findViewById(R.id.simulatorRadioButton3);
        this.RadioButton4 = (RadioButton) view.findViewById(R.id.simulatorRadioButton4);
        this.buttonAnterior = (Button) view.findViewById(R.id.simulatorButton1);
        this.buttonSiguiente = (Button) view.findViewById(R.id.simulatorButton2);
        this.buttonFinalizar = (Button) view.findViewById(R.id.simulatorButton3);

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
        buttonFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickOmitir(view);
            }
        });

        radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.simulatorRadioButton1) {
                    Toast.makeText(getActivity().getApplicationContext(), "Respuesta 1", Toast.LENGTH_SHORT).show();
                } else if(checkedId == R.id.simulatorRadioButton2) {
                    Toast.makeText(getActivity().getApplicationContext(), "Respuesta 2", Toast.LENGTH_SHORT).show();
                } else if(checkedId == R.id.simulatorRadioButton3) {
                    Toast.makeText(getActivity().getApplicationContext(), "Respuesta 3", Toast.LENGTH_SHORT).show();
                } else if(checkedId == R.id.simulatorRadioButton4) {
                    Toast.makeText(getActivity().getApplicationContext(), "Respuesta 4", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //addRadioButtons(4);


        return view;
    }

    //metodo para añadir radioButtons dinamicamente
    /*public void addRadioButtons(int number) {

        for (int row = 0; row < 1; row++) {
            LinearLayout ll = new LinearLayout(getActivity());
            ll.setOrientation(LinearLayout.VERTICAL);

            for (int i = 1; i <= number; i++) {
                RadioButton rdbtn = new RadioButton(getActivity());
                rdbtn.setId((row * 2) + i);
                rdbtn.setText("Respuesta " + rdbtn.getId());
                ll.addView(rdbtn);
            }
            ((ViewGroup) view.findViewById(R.id.radiogroup)).addView(ll);
        }

    }*/

    public void onClickAnterior(View view) {
        Intent intent = new Intent(getActivity(), MainActivity.class);
        startActivity(intent);
        //getActivity().finish();
    }

    public void onClickSiguiente(View view) {
        Intent intent = new Intent(getActivity(), resultActivity.class);
        startActivity(intent);
    }

    public void onClickOmitir(View view) {
        Intent intent = new Intent(getActivity(), resultActivity.class);
        startActivity(intent);
    }

}


