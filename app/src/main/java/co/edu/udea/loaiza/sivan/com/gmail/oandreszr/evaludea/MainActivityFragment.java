package co.edu.udea.loaiza.sivan.com.gmail.oandreszr.evaludea;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Fragment;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import static android.R.layout.simple_spinner_item;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private String[] arraySpinner;

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

        /*this.arraySpinner = new String[] {
                "Básico", "Intermedio", "Real"
        };
        Spinner spinner = (Spinner) view.findViewById(R.id.mainSpinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(), simple_spinner_item, arraySpinner);
        spinner.setAdapter(adapter);*/

        return view;
    }
}
