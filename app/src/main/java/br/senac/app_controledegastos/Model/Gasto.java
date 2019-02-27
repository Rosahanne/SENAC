package br.senac.app_controledegastos.Model;

import android.widget.Button;
import android.widget.EditText;

public class Gasto {

    private long idGasto;
    private EditText editData;
    private EditText editDescricao;
    private EditText editCategoria;
    private Button btnEnviar;

    public Gasto(long idGasto, EditText editData, EditText editDescricao, EditText editCategoria, Button btnEnviar) {
        this.idGasto = idGasto;
        this.editData = editData;
        this.editDescricao = editDescricao;
        this.editCategoria = editCategoria;
        this.btnEnviar = btnEnviar;
    }

    public Gasto(EditText editData, EditText editDescricao, EditText editCategoria, Button btnEnviar) {
        this.editData = editData;
        this.editDescricao = editDescricao;
        this.editCategoria = editCategoria;
        this.btnEnviar = btnEnviar;
    }

    public long getIdGasto() {
        return idGasto;
    }

    public EditText getEditData() {
        return editData;
    }

    public EditText getEditDescricao() {
        return editDescricao;
    }

    public EditText getEditCategoria() {
        return editCategoria;
    }

    public Button getBtnEnviar() {
        return btnEnviar;
    }
}
