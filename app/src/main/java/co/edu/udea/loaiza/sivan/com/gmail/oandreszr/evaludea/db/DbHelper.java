package co.edu.udea.loaiza.sivan.com.gmail.oandreszr.evaludea.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by usurio on 02/05/2016.
 */
public class DbHelper extends SQLiteOpenHelper { //
    private static final String TAG = DbHelper.class.getSimpleName();

    public DbHelper(Context context) {
        super(context, StatementContract.DB_NAME, null, StatementContract.DB_VERSION);
    }

    //Se llama solamente cuando se crea la BD por primer vez
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = String
                .format("create table %s (%s int primary key, %s text, %s text)",
                        StatementContract.TABLE, StatementContract.Column.ID,
                        StatementContract.Column.COMPONENT, StatementContract.Column.STATEMENT);
        //Sentencia para crear tabla
        Log.d(TAG, "onCreate with SQL: " + sql);
        db.execSQL(sql); //Ejecución de la sentencia
        sql = String
                .format("create table %s (%s int, %s int, %s text, %s text, %s text, %s text,%s text, %s text,%s text, %s text,%s text, %s text, %s int, foreign key(%s) references %s(%s),primary key(%s,%s))",
                        QuestionContract.TABLE,
                        QuestionContract.Column.STATEMENT,
                        QuestionContract.Column.ID,
                        QuestionContract.Column.QUESTION,
                        QuestionContract.Column.QUESTIONIMG,
                        QuestionContract.Column.ANSWER1,
                        QuestionContract.Column.ANSWER2,
                        QuestionContract.Column.ANSWER3,
                        QuestionContract.Column.ANSWER4,
                        QuestionContract.Column.ANSWER1IMG,
                        QuestionContract.Column.ANSWER2IMG,
                        QuestionContract.Column.ANSWER3IMG,
                        QuestionContract.Column.ANSWER4IMG,
                        QuestionContract.Column.CORRECTANSWER,
                        QuestionContract.Column.STATEMENT, StatementContract.TABLE, StatementContract.Column.ID,
                        QuestionContract.Column.STATEMENT, QuestionContract.Column.ID
                );
        //Sentencia para crear tabla
        Log.d(TAG, "onCreate with SQL: " + sql);
        db.execSQL(sql); //Ejecución de la sentencia

    }

    //Se llama cada que el schema cambie (nueva version)
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        /* Por simplicidad se borran los datos y se crea la tabla de nuevo. Usualmente se haría un ALTER TABLE para cambiar la estructura de la base de datos sin borrar los existentes */
        db.execSQL("drop table if exists " + QuestionContract.TABLE); //Borrar tabla
        db.execSQL("drop table if exists " + StatementContract.TABLE);
        onCreate(db);//Crear tabla de nuevo
    }
}