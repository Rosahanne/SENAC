package br.devmobile_control.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;
import br.devmobile_control.Model.Gasto;

public class GastoDAO extends SQLiteOpenHelper {


    public GastoDAO(Context context) {
        super(context, "ContoleCustos", null, 1);
    }

    // chamado quendo o BD é criado pela primeira vez
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table Gasto(" +
                "idGasto INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "data TEXT not null," +
                "descricao TEXT not null," +
                "categoria TEXT not null," +
                "valor DECIMAL not null)";
        db.execSQL(sql);
    }

    // chamado quendo o BD precisar ser atualizado
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public long inserir(Gasto gasto) {
        //Inserir registros com rocedimento de segureança
        ContentValues dados = getContentValues(gasto);
        SQLiteDatabase db = getWritableDatabase();
        return db.insert("Gasto", null, dados);}

    private ContentValues getContentValues(Gasto gasto) {
        ContentValues dados = new ContentValues();
        dados.put("data", gasto.getData());
        dados.put("descricao", gasto.getDescricao());
        dados.put("categoria", gasto.getCategoria());
        dados.put("valor", gasto.getValor());
        return dados;
    }

    public List<Gasto> listaTodosGastos() {
        SQLiteDatabase db = getReadableDatabase();
        List<Gasto> listaGastos = new ArrayList<>();

        String sql = "SELECT 'idGasto', * FROM Gasto";
        Cursor cursor = db.rawQuery(sql, null);

        while (cursor.moveToNext()) {
            long idGasto = cursor.getLong(cursor.getColumnIndex("idGasto"));
            String data = cursor.getString(cursor.getColumnIndex("data"));
            String descricao = cursor.getString(cursor.getColumnIndex("descricao"));
            String categoria = cursor.getString(cursor.getColumnIndex("categoria"));
            float valor = cursor.getFloat(cursor.getColumnIndex("valor"));

            Gasto gasto = new Gasto(idGasto, data, descricao, categoria, valor);
            listaGastos.add(gasto);
        }
        return listaGastos;
    }

//    public double getValorTotaldeGastos(){
//
//    }

    public int editar(Gasto gasto) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = getContentValues(gasto);
        String selection = "idGasto = ?";
        String[] args = {String.valueOf(gasto.getIdGasto())};

        int resultado = db.update("Gasto", dados, selection, args);
        db.close();
        return resultado;
    }

    public int deletar(long idGasto) {
        SQLiteDatabase db = getWritableDatabase();
        String selection = "idGasto = ?";
        String[] args = {String.valueOf(idGasto)};

        int resultado = db.delete("Gasto", selection, args);
        db.close();
        return resultado;

    }
}


