package br.senac.app_controledegastos.helper;

import android.app.Activity;
import android.widget.EditText;
import br.senac.app_controledegastos.CadGasto;
import br.senac.app_controledegastos.EditGasto;
import br.senac.app_controledegastos.Model.Gasto;
import br.senac.app_controledegastos.R;

public class GastoHelper {

    private long idGasto;
    private EditText editData;
    private EditText editDescricao;
    private EditText editCategoria;
    private EditText editValor;
    private Gasto gasto;

    public GastoHelper(CadGasto activity) {
        carregaCampos(activity);
    }

    public void carregaCampos(CadGasto activity) {
        editData = activity.findViewById(R.id.dataCadGasto);
        editDescricao = activity.findViewById(R.id.descricaoCadGasto);
        editCategoria = activity.findViewById(R.id.categoriaCadGasto);
        editValor = activity.findViewById(R.id.valorCadGasto);
    }

    public GastoHelper(EditGasto activity) {
        carregaCampos(activity);
    }

    public void carregaCampos(EditGasto activity) {
        editData = activity.findViewById(R.id.dataEditGasto);
        editDescricao = activity.findViewById(R.id.descricaoEditGasto);
        editCategoria = activity.findViewById(R.id.categoriaEditGasto);
        editValor = activity.findViewById(R.id.valorEditGasto);
    }

    public Gasto getGasto() {
        String data = editData.getText().toString();
        String descricao = editDescricao.getText().toString();
        String categoria = editCategoria.getText().toString();
        Double valor = Double.parseDouble(editValor.getText().toString());

        return new Gasto(data, descricao, categoria, valor);
    }

    public void carregaCampos(Gasto gasto) {
        this.gasto = gasto;
        editData.setText(gasto.getData());
        editDescricao.setText(gasto.getDescricao());
        editCategoria.setText(gasto.getCategoria());
        editValor.setText(String.valueOf(gasto.getValor()));
    }

}
