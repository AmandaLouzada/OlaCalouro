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
    private static int VERSAO = 4;


    public  static  class  Telefone {
        public static final  String TABELA = "telefone";
        public static final  String _ID = "_id";
        public static final  String NOME = "nome";
        public static final  String TELEFONE = "telefone";
        public static final  String DESCRICAO = "descricao";
        public static final  String CATEGORIA = "categoria";

        public static final String[] COLUNAS = new String[]{
                _ID, NOME, TELEFONE, DESCRICAO, CATEGORIA
        };
    }

    public  static  class  Local {
        public static final  String TABELA = "local";
        public static final String _ID = "_id";
        public static final String NOME = "nome";
        public static final String DESCRICAO = "descricao";
        public static final String LATITUDE = "latitude";
        public static final String LONGITUDE = "longitude";
        public static final String TIPO = "tipo";

        public static final String[] COLUNAS = new String[]{
                _ID, NOME, DESCRICAO, LATITUDE, LONGITUDE, TIPO
        };
    }

    public DatabaseHelper(Context context) {
        super(context, BANCO_DADOS, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE TELEFONE (_id INTEGER PRIMARY KEY," +
                "nome TEXT, telefone TEXT, descricao TEXT, categoria INTEGER);");
        db.execSQL("INSERT INTO TELEFONE (nome, telefone, descricao, categoria) values('Proest', '321855871', 'Assuntos estudantis', 1);");
        db.execSQL("INSERT INTO TELEFONE (nome, telefone, descricao, categoria) values('DICOM', '321855871', 'Comunicação', 2);");
        db.execSQL("INSERT INTO TELEFONE (nome, telefone, descricao, categoria) values('DTI', '321855871', 'Tecnologia da informação',3);");

        db.execSQL("CREATE TABLE LOCAL (_id INTEGER PRIMARY KEY," +
                "nome TEXT, latitude REAL, longitude REAL, descricao TEXT, tipo INTEGER);");
        db.execSQL("INSERT INTO LOCAL (nome, latitude, longitude, descricao, tipo) values('RU', -10.177970, -48.358580, 'Restaurante Universitário', 5);");
        db.execSQL("INSERT INTO LOCAL (nome, latitude, longitude, descricao, tipo) values('Bloco B',-10.180177, -48.360549, 'Salas de aula', 1);");
        db.execSQL("INSERT INTO LOCAL (nome, latitude, longitude, descricao, tipo) values('Bloco IV', -10.176671, -48.361853, 'Reitoria', 1);");
        db.execSQL("INSERT INTO LOCAL (nome, latitude, longitude, descricao, tipo) values('Lanchonete', -10.178678, -48.361316, 'Lanchonete cara', 5);");
        db.execSQL("INSERT INTO LOCAL (nome, latitude, longitude, descricao, tipo) values('Bloco I', -10.178171, -48.361831, 'Laboratórios e Caixas Eletrônico', 1);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE TELEFONE;");
        db.execSQL("DROP TABLE LOCAL;");
        onCreate(db);
    }
}

