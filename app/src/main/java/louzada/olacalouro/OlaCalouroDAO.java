package louzada.olacalouro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import louzada.olacalouro.domain.Local;
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

    public List<Telefone> listarTelefones(){
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


        if(cursor.getCount()>0){
            cursor.moveToFirst();
            Telefone telefone = criarTelefone(cursor);
            cursor.close();
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
//        Log.i("ID",String.valueOf(cursor.getColumnIndex(DatabaseHelper.Telefone._ID)));
//        Log.i("TEL", String.valueOf(cursor.getColumnIndex(DatabaseHelper.Telefone.TELEFONE)));
//        Log.i("CAT", String.valueOf(cursor.getColumnIndex(DatabaseHelper.Telefone.CATEGORIA)));
//        Log.i("DESC", String.valueOf(cursor.getColumnIndex(DatabaseHelper.Telefone.DESCRICAO)));
//        Log.i("NOME", String.valueOf(cursor.getColumnIndex(DatabaseHelper.Telefone.NOME)));
        Telefone telefone = new Telefone(cursor.getLong(cursor.getColumnIndex(DatabaseHelper.Telefone._ID)),
                cursor.getString(cursor.getColumnIndex(DatabaseHelper.Telefone.NOME)),
                cursor.getString(cursor.getColumnIndex(DatabaseHelper.Telefone.TELEFONE)),
                cursor.getString(cursor.getColumnIndex(DatabaseHelper.Telefone.DESCRICAO)),
                cursor.getInt(cursor.getColumnIndex(DatabaseHelper.Telefone.CATEGORIA)));
        return telefone;
    }

    // Metodos classe LOCAL

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

        if(cursor.getCount()>0){
            cursor.moveToFirst();
            Local local = criarLocal(cursor);
            cursor.close();
            return local;
        }
        return null;
    }

    public long inserir(Local local){
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.Local.NOME,
                local.getNome());

        values.put(DatabaseHelper.Local.LATITUDE,
                local.getLat());

        values.put(DatabaseHelper.Local.LONGITUDE,
                local.getLng());

        values.put(DatabaseHelper.Local.DESCRICAO,
                local.getDescricao());

        values.put(DatabaseHelper.Local.TIPO,
                local.getTipo());

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

    private Local criarLocal (Cursor cursor) {
        Log.i("ID",String.valueOf(cursor.getColumnIndex(DatabaseHelper.Local._ID)));
        Log.i("NOME", String.valueOf(cursor.getColumnIndex(DatabaseHelper.Local.NOME)));
        Log.i("LAT", String.valueOf(cursor.getColumnIndex(DatabaseHelper.Local.LATITUDE)));
        Log.i("LNG", String.valueOf(cursor.getColumnIndex(DatabaseHelper.Local.LONGITUDE)));
        Log.i("DESC", String.valueOf(cursor.getColumnIndex(DatabaseHelper.Local.DESCRICAO)));
        Log.i("INT", String.valueOf(cursor.getColumnIndex(DatabaseHelper.Local.TIPO)));

        Local local = new Local(cursor.getLong(cursor.getColumnIndex(DatabaseHelper.Local._ID)),
                cursor.getString(cursor.getColumnIndex(DatabaseHelper.Local.NOME)),
                cursor.getDouble(cursor.getColumnIndex(DatabaseHelper.Local.LATITUDE)),
                cursor.getDouble(cursor.getColumnIndex(DatabaseHelper.Local.LONGITUDE)),
                cursor.getString(cursor.getColumnIndex(DatabaseHelper.Local.DESCRICAO)),
                cursor.getInt(cursor.getColumnIndex(DatabaseHelper.Local.TIPO)));
        return local;
    }
}

