package br.senac.app_controledegastos.helper;

import android.app.Activity;
import android.widget.EditText;
import br.senac.app_controledegastos.EditGasto;
import br.senac.app_controledegastos.Model.Gasto;
import br.senac.app_controledegastos.R;

public class GastoHelper {

    private long idGasto;
    private EditText editData;
    private EditText editDescricao;
    private EditText editCategoria;
    private Gasto gasto;

    public GastoHelper(Gasto activity) {
        carregaCampos(activity);
    }

    public GastoHelper(EditGasto activity) {
        carregaCampos(activity);
    }

    public void carregaCampos(Activity activity) {
        editData = activity.findViewById(R.id.cadAlunoTxtNome);
        editDescricao = activity.findViewById(R.id.cadAlunoTxtTelefone);
        editCategoria = activity.findViewById(R.id.cadAlunoTxtEmail);

    }

    public Gasto getGasto() {
        String data = editData.getText().toString();
        String descricao = editDescricao.getText().toString();
        String categoria = editCategoria.getText().toString();

        return new Gasto(gasto.getIdGasto(), data, descricao, categoria);
    }

    public void carregaCampos(Gasto gasto) {
        this.gasto = gasto;
        editData.setText(gasto.getData());
        editDescricao.setText(gasto.getDescricao());
        editCategoria.setText(gasto.getCategoria());

    }

}
