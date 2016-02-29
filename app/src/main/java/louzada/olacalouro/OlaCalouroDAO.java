package louzada.olacalouro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import louzada.olacalouro.domain.Local;

/**
 * Created by amanda on 25/02/16.
 */
public class OlaCalouroDAO {
    private  DatabaseHelper helper;
    private SQLiteDatabase db;

    public  OlaCalouroDAO(Context context){
        helper = new DatabaseHelper(context);
    }

    private SQLiteDatabase getDb() {
        if (db == null) {
            db = helper.getWritableDatabase();
        }
        return db;
    }

    public void close(){
        helper.close();
    }

    public List<Local> listarLocais(){
        Cursor cursor = getDb().query(DatabaseHelper.Local.TABELA,
                DatabaseHelper.Local.COLUNAS,
                null, null, null, null, null);
        List<Local> locais = new ArrayList<Local>();
        while(cursor.moveToNext()){
            Local local = criarLocal(cursor);
            locais.add(local);
        }
        cursor.close();
        return locais;
    }

    public Local buscarLocalPorId(Long id){
        Cursor cursor = getDb().query(DatabaseHelper.Local.TABELA, DatabaseHelper.Local.COLUNAS, DatabaseHelper.Local._ID + "=?", new String[]{id.toString()},
                null, null, null);

        Log.i("MSG","apartir daqui");
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            Log.i("MSG", "apartir daqui2");
            Local local = criarLocal(cursor);
            cursor.close();
            Log.i("MSG", "Aqui");
            return local;
        }
        return null;
    }

    public long inserir(Local local){
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.Local.NOME,
                local.getNome());

        values.put(DatabaseHelper.Local.TELEFONE,
                local.getTelefone());

        values.put(DatabaseHelper.Local.DESCRICAO,
                local.getDescricao());

        values.put(DatabaseHelper.Local.CATEGORIA,
                local.getCategoria());

        return getDb().insert(DatabaseHelper.Local.TABELA,
                null, values);
    }

    public boolean removerLocal(Long id){
        String whereClause = DatabaseHelper.Local._ID + " = ?";
        String[] whereArgs = new String[]{id.toString()};
        int removidos = getDb().delete(DatabaseHelper.Local.TABELA,
                whereClause, whereArgs);
        return removidos > 0;
    }

    private Local criarLocal(Cursor cursor) {
        Log.i("ID",String.valueOf(cursor.getColumnIndex(DatabaseHelper.Local._ID)));
        Log.i("TEL",String.valueOf(cursor.getColumnIndex(DatabaseHelper.Local.TELEFONE)));
        Log.i("CAT",String.valueOf(cursor.getColumnIndex(DatabaseHelper.Local.CATEGORIA)));
        Log.i("DESC",String.valueOf(cursor.getColumnIndex(DatabaseHelper.Local.DESCRICAO)));
        Log.i("NOME",String.valueOf(cursor.getColumnIndex(DatabaseHelper.Local.NOME)));
        Local local = new Local(cursor.getLong(cursor.getColumnIndex(DatabaseHelper.Local._ID)),
                cursor.getString(cursor.getColumnIndex(DatabaseHelper.Local.NOME)),
                cursor.getString(cursor.getColumnIndex(DatabaseHelper.Local.TELEFONE)),
                cursor.getString(cursor.getColumnIndex(DatabaseHelper.Local.DESCRICAO)),
                cursor.getInt(cursor.getColumnIndex(DatabaseHelper.Local.CATEGORIA)));
        return local;
    }
}

