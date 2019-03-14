package br.senac.app_controledegastos.adapters;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;

import br.senac.app_controledegastos.CadGasto;
import br.senac.app_controledegastos.EditGasto;
import br.senac.app_controledegastos.MainActivity;
import br.senac.app_controledegastos.Model.Gasto;
import br.senac.app_controledegastos.R;


public class GastoAdapter extends BaseAdapter {

    private final List<Gasto>gastoList;
    private final Activity act;
    public static final String MAIN_GASTO = "main_gasto";


    public GastoAdapter(List<Gasto> gastoList, Activity act) {
        this.gastoList = gastoList;
        this.act = act;
    }

    public GastoAdapter(List<Gasto> gastoList, MainActivity mainActivity){
        this.gastoList = gastoList;
        this.act = mainActivity;
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
            return gastoList.get(position).getIdGasto();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = act.getLayoutInflater()
                    .inflate(R.layout.list_gastos_personalizada, parent, false);
            Gasto gasto = gastoList.get(position);

            TextView data = (TextView)
            view.findViewById(R.id.textView_Data);
            TextView descricao = (TextView)
            view.findViewById(R.id.textView_Descricao);
            TextView categoria = (TextView)
            view.findViewById(R.id.textView_Categoria);
            TextView valor = (TextView)
            view.findViewById(R.id.textView_Valor);
            FloatingActionButton cadastrar = (FloatingActionButton)
            view.findViewById(R.id.AddGastos);
            FloatingActionButton editar = (FloatingActionButton)
            view.findViewById(R.id.EditGastos);

            data.setText(gasto.getData());
//            categoria.setText(gasto.getCarregaSpinner(Array.lista_categoria));
            descricao.setText(gasto.getDescricao());
            valor.setText(String.valueOf(gasto.getValor()));


            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(act, CadGasto.class);
                    act.startActivity(intent);
                }
            });


            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent =  new Intent(act, EditGasto.class);
                    act.startActivity(intent);

                }
            });



            return view;
        }




}
