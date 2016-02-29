package louzada.olacalouro;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.google.android.gms.maps.model.LatLng;


/**
 * Created by amanda on 25/02/16.
 */
public class DatabaseHelper extends SQLiteOpenHelper {



    private static final String BANCO_DADOS = "OlaCalouro";
    private static int VERSAO = 1;


    public  static  class  Local {
        public static final  String TABELA = "local";
        public static final  String _ID = "_id";
        public static final  String NOME = "nome";
        public static final  String TELEFONE = "telefone";
        public static final  String DESCRICAO = "descricao";
        public static final  String CATEGORIA = "categoria";

        public static final String[] COLUNAS = new String[]{
                _ID, NOME, TELEFONE, DESCRICAO, CATEGORIA
        };
    }

    public DatabaseHelper(Context context) {
        super(context, BANCO_DADOS, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE LOCAL (_id INTEGER PRIMARY KEY," +
                "nome TEXT, telefone TEXT, descricao TEXT, categoria INTEGER);");
        db.execSQL("INSERT INTO LOCAL (nome, telefone, descricao, categoria) values('Proest', '321855871', 'Assuntos estudantis', 1);");
        db.execSQL("INSERT INTO LOCAL (nome, telefone, descricao, categoria) values('DICOM', '321855871', 'Comunicação', 2);");
        db.execSQL("INSERT INTO LOCAL (nome, telefone, descricao, categoria) values('DTI', '321855871', 'Tecnologia da informação',3);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

