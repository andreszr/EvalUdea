package co.edu.udea.loaiza.sivan.com.gmail.oandreszr.evaludea.db;

import android.provider.BaseColumns;

/**
 * Created by usurio on 10/03/2016.
 */
public class StatementContract {

        public static final String DB_NAME = "simulaudea.db"; //Nombre de la DB
        public static final int DB_VERSION = 1; //Versión de la DB
        public static final String TABLE = "statement"; //Nombre de la tabla
        /*public static final String DEFAULT_SORT = Column.CREATED_AT + " DESC"; /*Para ordenar
		descendentemente por fecha de creacion*/

        public class Column { //Columnas de la tabla
            public static final String ID = BaseColumns._ID; //Por convención se define así el ID
            public static final String STATEMENT = "statement";
            public static final String COMPONENT = "component";
        }
    }
