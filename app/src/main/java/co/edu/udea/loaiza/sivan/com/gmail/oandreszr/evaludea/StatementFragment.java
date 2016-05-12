package co.edu.udea.loaiza.sivan.com.gmail.oandreszr.evaludea;

import android.app.Fragment;
import android.app.LoaderManager;
import android.content.Context;
import android.content.Loader;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import co.edu.udea.loaiza.sivan.com.gmail.oandreszr.evaludea.db.DbHelper;
import co.edu.udea.loaiza.sivan.com.gmail.oandreszr.evaludea.db.QuestionContract;
import co.edu.udea.loaiza.sivan.com.gmail.oandreszr.evaludea.db.StatementContract;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link StatementFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link StatementFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StatementFragment extends Fragment{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private static final String[] FROM = {
            QuestionContract.Column.QUESTION, QuestionContract.Column.QUESTIONIMG,
            QuestionContract.Column.ANSWER1,  QuestionContract.Column.ANSWER1IMG,
            QuestionContract.Column.ANSWER2,  QuestionContract.Column.ANSWER2IMG,
            QuestionContract.Column.ANSWER3,  QuestionContract.Column.ANSWER3IMG,
            QuestionContract.Column.ANSWER4,  QuestionContract.Column.ANSWER4IMG
    }; //Nombres de columnas que mapean a la tabla

    private static final int[] TO = {
            R.id.question, R.id.questionImg,
            R.id.answer1, R.id.answer1img,
            R.id.answer2, R.id.answer2img,
            R.id.answer3, R.id.answer3img,
            R.id.answer4, R.id.answer4img   }; /* Identificadores de las vistas
            a las cuales se enlazarán los datos (se definieron en list_item.xml*/

    private ListView questionListView;
    private SimpleCursorAdapter adapter; //adapter a utilizar
    private DbHelper dbHelper;
    private TextView statementTextView;

    public StatementFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment StatementFragment.
     */
    // TODO: Rename and change types and number of parameters
   /* public static StatementFragment newInstance(String param1, String param2) {
        StatementFragment fragment = new StatementFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }*/

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_statement, container, false);

        return rootView;
        // Inflate the layout for this fragment
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //getStatement();
        statementTextView=(TextView)getActivity().findViewById(R.id.statement);
        questionListView = (ListView)getActivity().findViewById(R.id.question_list_view);

        adapter = new SimpleCursorAdapter(getActivity(), R.layout.list_item,
                getQuestions(), FROM, TO, 0); /*Crear objeto de SimpleCursor adapter, parámetros:
                Contexto, Vista del elemento de lista, cursor a utilizar, origen de los datos,
                vistas de destino de los datos, bandera (no se utiliza en este caso)*/

        questionListView.setAdapter(adapter);
    }

    public String getStatement(){
        dbHelper = new DbHelper(getActivity()); //Instancia de DbHelper
        SQLiteDatabase db = dbHelper.getReadableDatabase(); /*Obtener instancia de la BD (lectura)*/
        String sql= "SELECT * FROM statement WHERE _id = ?";
        String where = StatementContract.Column.ID+"=?";
        String[] whereArgs = new String[] {
                "1"
        };
        Cursor cursor = db.rawQuery(sql,whereArgs);
        //Cursor cursor = db.query(StatementContract.TABLE, null, where, whereArgs, null, null, null);
                /* Hace consulta en la BD
                Parámetros: tabla, columnas (null=todas), selection (null=todas las filas),
                selectionArgs (los ? del where), groupBy, having, orderBy*/
        Log.d("TAG", cursor.toString());
        Log.d("TAG",Integer.toString(cursor.getColumnIndex(StatementContract.Column.STATEMENT)));
        //Log.d("TAG",cursor.getString(cursor.getColumnIndex(StatementContract.Column.STATEMENT)));
        return "l";//statement;
    }

    public Cursor getQuestions () {
        dbHelper = new DbHelper(getActivity()); //Instancia de DbHelper
        SQLiteDatabase db = dbHelper.getReadableDatabase(); /*Obtener instancia de la BD (lectura)*/
        String sql= "SELECT * FROM question WHERE statement = ? ORDER BY _id ASC";
        String where = QuestionContract.Column.STATEMENT+"=?";
        String[] whereArgs = new String[] {
                "1"
        };
        String orderBy = QuestionContract.Column.ID+" ASC";
        Cursor cursor = db.rawQuery(sql,whereArgs);
       // Cursor cursor = db.query(QuestionContract.TABLE, null, where, whereArgs, null, null, orderBy);
                /* Hace consulta en la BD
                Parámetros: tabla, columnas (null=todas), selection (null=todas las filas),
                selectionArgs (los ? del where), groupBy, having, orderBy*/
        Log.d("TAG", cursor.toString());
        return cursor;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
