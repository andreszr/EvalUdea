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
public class historyActivityFragment extends Fragment {

    Button buttonHistory1, buttonHistory2, buttonHistory3;
    View view;

    public historyActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_history, container, false);
        this.buttonHistory1 = (Button) view.findViewById(R.id.historyButton1);
        this.buttonHistory2 = (Button) view.findViewById(R.id.historyButton2);
        this.buttonHistory3 = (Button) view.findViewById(R.id.historyButton3);

        buttonHistory1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {onClickHistory(view);          }
        });
        buttonHistory2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {onClickHistory(view);          }
        });
        buttonHistory3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickHistory(view);
            }
        });
        return view;
    }

    public void onClickHistory(View view){
        Intent intent = new Intent(getActivity(), resultActivity.class);
        startActivity(intent);
    }
}
