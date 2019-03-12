package br.senac.app_controledegastos.adapters;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;

import java.util.List;

import br.senac.app_controledegastos.MainActivity;
import br.senac.app_controledegastos.Model.Gasto;
import br.senac.app_controledegastos.R;


public class GastoAdapter extends BaseAdapter {

    private final List<Gasto>gastoList;
    private final Activity act;


    public GastoAdapter(List<Gasto> gastoList, Activity act) {
        this.gastoList = gastoList;
        this.act = act;
    }
        @Override
        public int getCount() {
            return gastoList.size();
        }

        @Override
        public Object getItem(int position) {
            return gastoList.get(position);
        }

        @Override
        public long getItemId(int position) {
            Gasto gasto = gastoList.get(position);
            return gasto.getIdGasto();}

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = act.getLayoutInflater()
                    .inflate(R.layout.list_gastos_personalizada, parent, false);
            Gasto gasto = gastoList.get(position);

            EditText data = (EditText)
            view.findViewById(R.id.editText_Data);
            EditText descricao = (EditText)
            view.findViewById(R.id.editText_Descricao);
            EditText categoria = (EditText)
            view.findViewById(R.id.editText_Categoria);
            EditText valor = (EditText)
            view.findViewById(R.id.editText_Valor);


            data.setText(gasto.getData());
            descricao.setText(gasto.getDescricao());
            categoria.setText(gasto.getCategoria());
            valor.setText(String.valueOf(gasto.getValor()));

            return view;
        }

}
