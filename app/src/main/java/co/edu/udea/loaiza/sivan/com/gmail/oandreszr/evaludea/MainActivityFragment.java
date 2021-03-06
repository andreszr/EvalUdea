package co.edu.udea.loaiza.sivan.com.gmail.oandreszr.evaludea;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Fragment;
import android.widget.Button;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    Button buttonSimulator;
    Button buttonLearning;
    Button buttonHistory;

    //Button buttonQuery;

    public MainActivityFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        this.buttonSimulator = (Button) view.findViewById(R.id.mainButtonSimulator);
        this.buttonLearning = (Button) view.findViewById(R.id.mainButtonLearning);
        this.buttonHistory = (Button) view.findViewById(R.id.mainButtonHistory);

        //this.buttonQuery = (Button) view.findViewById(R.id.mainButtonQuery);
        /*buttonQuery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                StatementFragment fragment = new StatementFragment();
                fragmentTransaction.replace(R.id.fragment, fragment);
                fragmentTransaction.commit();   }
        });*/

        buttonSimulator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {onClickSimulator(view);          }
        });
        buttonLearning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {onClickLearning(view);          }
        });
        buttonHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickHistory(view);
            }
        });
        return view;
    }

    public void onClickLearning(View view){
        Intent intent = new Intent(getActivity(), learningActivity.class);
        startActivity(intent);
    }

    public void onClickSimulator(View view){
        Intent intent = new Intent(getActivity(), simulatorActivity.class);
        startActivity(intent);
    }

    public void onClickHistory(View view){
        Intent intent = new Intent(getActivity(), historyActivity.class);
        startActivity(intent);
    }
}
