package br.senac.app_controledegastos.helper;

import android.app.Activity;
import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import br.senac.app_controledegastos.CadGasto;
import br.senac.app_controledegastos.EditGasto;
import br.senac.app_controledegastos.Model.Gasto;
import br.senac.app_controledegastos.R;

public class GastoHelper {

    private long idGasto;
    private EditText editData;
    private EditText editDescricao;
    private EditText editValor;
    private Spinner spinnerCategoria;
    private Gasto gasto;
    private Context activity;

    public GastoHelper(CadGasto activity) {
        carregaCampos(activity);
    }

    public void carregaCampos(CadGasto activity) {
        this.activity = activity;
        editData = activity.findViewById(R.id.dataCadGasto);
        editDescricao = activity.findViewById(R.id.descricaoCadGasto);
        spinnerCategoria = activity.findViewById(R.id.spinner_Cadcategoria);
        editValor = activity.findViewById(R.id.valorCadGasto);
    }

    public GastoHelper(EditGasto activity) {
        carregaCampos(activity);
    }

    public void carregaCampos(EditGasto activity) {
        editData = activity.findViewById(R.id.dataEditGasto);
        editDescricao = activity.findViewById(R.id.descricaoEditGasto);
        spinnerCategoria = activity.findViewById(R.id.spinner_Editcategoria);
        editValor = activity.findViewById(R.id.valorEditGasto);
    }

    public Gasto getGasto() {
        String data = editData.getText().toString();
        String descricao = editDescricao.getText().toString();
//        String categoria = editCategoria.getText().toString();
        Double valor = Double.parseDouble(editValor.getText().toString());

        if (gasto != null) {
            return new Gasto(gasto.getIdGasto(), data, descricao, valor);
        }
        return new Gasto(data, descricao, valor);
    }


    public void carregaCampos(Gasto gasto){
        this.gasto = gasto;
        editData.setText(gasto.getData());
        editDescricao.setText(gasto.getDescricao());
//        editCategoria.setText(gasto.getCategoria());
        editValor.setText(String.valueOf(gasto.getValor()));
    }

    private void carregaSpinner(){
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource
                (this.activity, activity.R.array.lista_categoria),
                android.R.layout.simple_spinner_item);
        spinnerCategoria.setAdapter(adapter);
    }

}
