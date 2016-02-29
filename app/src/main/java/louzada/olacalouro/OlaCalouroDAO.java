package louzada.olacalouro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import louzada.olacalouro.domain.Telefone;

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

    public List<Telefone> listarLocais(){
        Cursor cursor = getDb().query(DatabaseHelper.Telefone.TABELA,
                DatabaseHelper.Telefone.COLUNAS,
                null, null, null, null, null);
        List<Telefone> telefones = new ArrayList<Telefone>();
        while(cursor.moveToNext()){
            Telefone telefone = criarTelefone(cursor);
            telefones.add(telefone);
        }
        cursor.close();
        return telefones;
    }

    public Telefone buscarTelefonePorId(Long id){
        Cursor cursor = getDb().query(DatabaseHelper.Telefone.TABELA, DatabaseHelper.Telefone.COLUNAS, DatabaseHelper.Telefone._ID + "=?", new String[]{id.toString()},
                null, null, null);

        Log.i("MSG","apartir daqui");
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            Log.i("MSG", "apartir daqui2");
            Telefone telefone = criarTelefone(cursor);
            cursor.close();
            Log.i("MSG", "Aqui");
            return telefone;
        }
        return null;
    }

    public long inserir(Telefone telefone){
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.Telefone.NOME,
                telefone.getNome());

        values.put(DatabaseHelper.Telefone.TELEFONE,
                telefone.getTelefone());

        values.put(DatabaseHelper.Telefone.DESCRICAO,
                telefone.getDescricao());

        values.put(DatabaseHelper.Telefone.CATEGORIA,
                telefone.getCategoria());

        return getDb().insert(DatabaseHelper.Telefone.TABELA,
                null, values);
    }

    public boolean removerTelefone(Long id){
        String whereClause = DatabaseHelper.Telefone._ID + " = ?";
        String[] whereArgs = new String[]{id.toString()};
        int removidos = getDb().delete(DatabaseHelper.Telefone.TABELA,
                whereClause, whereArgs);
        return removidos > 0;
    }

    private Telefone criarTelefone(Cursor cursor) {
        Log.i("ID",String.valueOf(cursor.getColumnIndex(DatabaseHelper.Telefone._ID)));
        Log.i("TEL",String.valueOf(cursor.getColumnIndex(DatabaseHelper.Telefone.TELEFONE)));
        Log.i("CAT",String.valueOf(cursor.getColumnIndex(DatabaseHelper.Telefone.CATEGORIA)));
        Log.i("DESC",String.valueOf(cursor.getColumnIndex(DatabaseHelper.Telefone.DESCRICAO)));
        Log.i("NOME",String.valueOf(cursor.getColumnIndex(DatabaseHelper.Telefone.NOME)));
        Telefone telefone = new Telefone(cursor.getLong(cursor.getColumnIndex(DatabaseHelper.Telefone._ID)),
                cursor.getString(cursor.getColumnIndex(DatabaseHelper.Telefone.NOME)),
                cursor.getString(cursor.getColumnIndex(DatabaseHelper.Telefone.TELEFONE)),
                cursor.getString(cursor.getColumnIndex(DatabaseHelper.Telefone.DESCRICAO)),
                cursor.getInt(cursor.getColumnIndex(DatabaseHelper.Telefone.CATEGORIA)));
        return telefone;
    }
}

