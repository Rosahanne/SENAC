package br.devmobile_control.helper;

import android.app.Activity;
import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import br.devmobile_control.CadGasto;
import br.devmobile_control.EditGasto;
import br.devmobile_control.Model.Gasto;
import br.devmobile_control.R;

public class GastoHelper {

    private long idGasto;
    private EditText editData;
    private EditText editDescricao;
    private EditText editValor;
    private Spinner spinnerCategoria;
    private Gasto gasto;
    private Context activity;

    public GastoHelper(CadGasto activity) {
        this.activity = activity;
        carregaCampos(activity);
        carregaSpinner(activity);
    }

    public void carregaCampos(CadGasto activity) {
        this.activity = activity;
        editData = activity.findViewById(R.id.dataCadGasto);
        editDescricao = activity.findViewById(R.id.descricaoCadGasto);
        editValor = activity.findViewById(R.id.valorCadGasto);
    }

    public GastoHelper(EditGasto activity) {
        carregaCampos(activity);
        carregaSpinner(activity);
    }

    public void carregaCampos(EditGasto activity) {
        editData = activity.findViewById(R.id.dataEditGasto);
        editDescricao = activity.findViewById(R.id.descricaoEditGasto);
        editValor = activity.findViewById(R.id.valorEditGasto);
    }

    public Gasto getGasto() {
        String data = editData.getText().toString();
        String descricao = editDescricao.getText().toString();
        String categoria = spinnerCategoria.getSelectedItem().toString();
        Double valor = Double.parseDouble(editValor.getText().toString());

        if (gasto != null) {
            return new Gasto(gasto.getIdGasto(), data, descricao, categoria,valor);
        }
        return new Gasto(data, descricao, categoria,valor);
    }


    public void preencheFormulario(Gasto gasto){
        this.gasto = gasto;
        editData.setText(gasto.getData());
        editDescricao.setText(gasto.getDescricao());
        spinnerCategoria.setSelection(pegaIndexdaCategoria(gasto.getCategoria()));
        editValor.setText(String.valueOf(gasto.getValor()));
    }

    private void carregaSpinner(EditGasto activity){
        spinnerCategoria = activity.findViewById(R.id.spinner_Editcategoria);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource
                (activity,R.array.lista_categoria,android.R.layout.simple_spinner_item);
                spinnerCategoria.setAdapter(adapter);
    }

    private void carregaSpinner(CadGasto activity){
        spinnerCategoria = activity.findViewById(R.id.spinner_Cadcategoria);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource
                (activity,R.array.lista_categoria,android.R.layout.simple_spinner_item);
                spinnerCategoria.setAdapter(adapter);
    }

    private int pegaIndexdaCategoria(String categoria){
        String [] arrayCategoria =  activity.getResources().getStringArray(R.array.lista_categoria);
        List<String> categoriaList = Arrays.asList(arrayCategoria);
        return  ((List) categoriaList).indexOf(categoria);
    }

}
