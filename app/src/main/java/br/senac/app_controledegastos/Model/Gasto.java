package br.senac.app_controledegastos.Model;

import android.widget.Button;
import android.widget.EditText;

public class Gasto {

    private long idGasto;
    private EditText editData;
    private EditText editDescricao;
    private EditText editCategoria;
    private
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

    public void setIdGasto(long idGasto) {
        this.idGasto = idGasto;
    }

    public EditText getEditData() {
        return editData;
    }

    public void setEditData(EditText editData) {
        this.editData = editData;
    }

    public EditText getEditDescricao() {
        return editDescricao;
    }

    public void setEditDescricao(EditText editDescricao) {
        this.editDescricao = editDescricao;
    }

    public EditText getEditCategoria() {
        return editCategoria;
    }

    public void setEditCategoria(EditText editCategoria) {
        this.editCategoria = editCategoria;
    }

    public Button getBtnEnviar() {
        return btnEnviar;
    }

    public void setBtnEnviar(Button btnEnviar) {
        this.btnEnviar = btnEnviar;
    }
}
