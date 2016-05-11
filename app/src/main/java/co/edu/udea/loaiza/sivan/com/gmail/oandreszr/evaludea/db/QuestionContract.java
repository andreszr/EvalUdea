package co.edu.udea.loaiza.sivan.com.gmail.oandreszr.evaludea.db;

import android.provider.BaseColumns;

/**
 * Created by usurio on 10/03/2016.
 */
public class QuestionContract {

        public static final String DB_NAME = "simulaudea.db"; //Nombre de la DB
        public static final int DB_VERSION = 1; //Versión de la DB
        public static final String TABLE = "question"; //Nombre de la tabla
        /*public static final String DEFAULT_SORT = Column.CREATED_AT + " DESC"; /*Para ordenar
		descendentemente por fecha de creacion*/

        public class Column { //Columnas de la tabla
            public static final String ID = BaseColumns._ID; //Por convención se define así el ID
            public static final String STATEMENT = "statement";
            public static final String QUESTION = "question";
            public static final String QUESTIONIMG = "questionimg";
            public static final String ANSWER1 = "answer1";
            public static final String ANSWER2 = "answer2";
            public static final String ANSWER3 = "answer3";
            public static final String ANSWER4 = "answer4";
            public static final String ANSWER1IMG = "answer1img";
            public static final String ANSWER2IMG = "answer2img";
            public static final String ANSWER3IMG = "answer3img";
            public static final String ANSWER4IMG = "answer4img";
            public static final String CORRECTANSWER = "correctanswer";
        }
    }
