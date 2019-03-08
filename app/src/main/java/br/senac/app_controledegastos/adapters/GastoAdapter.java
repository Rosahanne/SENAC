package br.senac.app_controledegastos.adapters;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.List;
import br.senac.app_controledegastos.Model.Gasto;


public class GastoAdapter extends BaseAdapter {

    private final List<Gasto>gastoList;
    private Gasto gasto;

    public GastoAdapter(List<Gasto> gastoList, Activity act) {
        this.gastoList = gastoList;
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
            gasto = new Gasto(this);
            return gasto.getIdGasto();

        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return null;
        }

}
