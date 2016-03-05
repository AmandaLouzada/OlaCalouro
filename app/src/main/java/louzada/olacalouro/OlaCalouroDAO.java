package louzada.olacalouro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import louzada.olacalouro.domain.Aresta;
import louzada.olacalouro.domain.Local;
import louzada.olacalouro.domain.Telefone;
import louzada.olacalouro.domain.Vertice;

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

    public Local buscarLocalPorNome(String nome){
        Cursor cursor = getDb().query(DatabaseHelper.Local.TABELA, DatabaseHelper.Local.COLUNAS, DatabaseHelper.Local.NOME + "=?", new String[]{nome.toString()},
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
        Local local = new Local(cursor.getLong(cursor.getColumnIndex(DatabaseHelper.Local._ID)),
                cursor.getString(cursor.getColumnIndex(DatabaseHelper.Local.NOME)),
                cursor.getDouble(cursor.getColumnIndex(DatabaseHelper.Local.LATITUDE)),
                cursor.getDouble(cursor.getColumnIndex(DatabaseHelper.Local.LONGITUDE)),
                cursor.getString(cursor.getColumnIndex(DatabaseHelper.Local.DESCRICAO)),
                cursor.getInt(cursor.getColumnIndex(DatabaseHelper.Local.TIPO)));
        return local;
    }

    //Metodos da Classe Vertice

    public List<Vertice> listarVertices(){
        Cursor cursor = getDb().query(DatabaseHelper.Vertice.TABELA,
                DatabaseHelper.Vertice.COLUNAS,
                null, null, null, null, null);
        Log.i("ID", String.valueOf(cursor.getColumnIndex(DatabaseHelper.Vertice._ID)));
        Log.i("NOME", String.valueOf(cursor.getColumnIndex(DatabaseHelper.Vertice.NOME)));
        Log.i("LAT", String.valueOf(cursor.getColumnIndex(DatabaseHelper.Vertice.LATITUDE)));
        Log.i("LNG", String.valueOf(cursor.getColumnIndex(DatabaseHelper.Vertice.LONGITUDE)));

        List<Vertice> vertices = new ArrayList<Vertice>();
        while(cursor.moveToNext()){
            Vertice vertice = criarVertice(cursor);
            vertices.add(vertice);
        }
        cursor.close();
        return vertices;
    }

    public Vertice buscarVerticePorId(Long id){
        Cursor cursor = getDb().query(DatabaseHelper.Vertice.TABELA, DatabaseHelper.Vertice.COLUNAS, DatabaseHelper.Vertice._ID + "=?", new String[]{id.toString()},
                null, null, null);

        if(cursor.moveToNext()){
            Vertice vertice = criarVertice(cursor);
            cursor.close();
            return vertice;
        }
        return null;
    }

    public Vertice buscarVerticePorLocalId(Long id){
        Cursor cursor = getDb().query(DatabaseHelper.Vertice.TABELA, DatabaseHelper.Vertice.COLUNAS, DatabaseHelper.Vertice.ID_LOCAL + "=?", new String[]{id.toString()},
                null, null, null);
        if(cursor.moveToNext()){
            Vertice vertice = criarVertice(cursor);
            cursor.close();
            return vertice;
        }
        return null;
    }

    private Vertice criarVertice (Cursor cursor) {

        Log.i("ID", String.valueOf(cursor.getColumnIndex(DatabaseHelper.Vertice._ID)));
        Log.i("NOME", String.valueOf(cursor.getColumnIndex(DatabaseHelper.Vertice.NOME)));
        Log.i("LAT", String.valueOf(cursor.getColumnIndex(DatabaseHelper.Vertice.LATITUDE)));
        Log.i("LNG", String.valueOf(cursor.getColumnIndex(DatabaseHelper.Vertice.LONGITUDE)));

        Vertice vertice = new Vertice(cursor.getLong(cursor.getColumnIndex(DatabaseHelper.Vertice._ID)),
                cursor.getString(cursor.getColumnIndex(DatabaseHelper.Vertice.NOME)),
                cursor.getDouble(cursor.getColumnIndex(DatabaseHelper.Vertice.LATITUDE)),
                cursor.getDouble(cursor.getColumnIndex(DatabaseHelper.Vertice.LONGITUDE)));
        return vertice;
    }

    //METODOS ARESTA

    public ArrayList<Aresta> listarArestas(){
        Cursor cursor = getDb().query(DatabaseHelper.Aresta.TABELA,
                DatabaseHelper.Aresta.COLUNAS,
                null, null, null, null, null);
        ArrayList<Aresta> arestas = new ArrayList<Aresta>();
        while(cursor.moveToNext()){
            Aresta aresta = criarAresta(cursor);
            arestas.add(aresta);
        }
        cursor.close();
        return arestas;
    }

    public Aresta buscarArestaPorId(Long id){
        Log.i("chegou aqui","MSG");
        Cursor cursor = getDb().query(DatabaseHelper.Aresta.TABELA, DatabaseHelper.Aresta.COLUNAS, DatabaseHelper.Aresta._ID + "=?", new String[]{id.toString()},
                null, null, null);

        if(cursor.getCount()>0){
            cursor.moveToFirst();
            Aresta aresta = criarAresta(cursor);
            cursor.close();
            return aresta;
        }
        return null;
    }

    private Aresta criarAresta (Cursor cursor) {
        Vertice origem = buscarVerticePorId(cursor.getLong(cursor.getColumnIndex(DatabaseHelper.Aresta.ID_VERTICE_ORIGEM)));
        Vertice destino = buscarVerticePorId(cursor.getLong(cursor.getColumnIndex(DatabaseHelper.Aresta.ID_VERTICE_DESTINO)));
        Aresta aresta = new Aresta(cursor.getLong(cursor.getColumnIndex(DatabaseHelper.Aresta._ID)),
                origem,
                destino,
                cursor.getDouble(cursor.getColumnIndex(DatabaseHelper.Aresta.PESO)));
        return aresta;
    }
}

