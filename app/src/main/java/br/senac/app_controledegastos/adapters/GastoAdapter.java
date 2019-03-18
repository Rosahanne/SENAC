package br.senac.app_controledegastos.adapters;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import br.senac.app_controledegastos.CadGasto;
import br.senac.app_controledegastos.DAO.GastoDAO;
import br.senac.app_controledegastos.EditGasto;
import br.senac.app_controledegastos.MainActivity;
import br.senac.app_controledegastos.Model.Gasto;
import br.senac.app_controledegastos.R;



public class GastoAdapter extends BaseAdapter {

    public static final double LINHA_AFETADA = 1;
    public static final String EDIT_GASTO = "EditarDado";
    private GastoDAO gastoDAO;
    private final List<Gasto>gastoList;
    private final Activity act;
    private FloatingActionButton fabExcGasto;
    private FloatingActionButton fabEditGasto;


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
        public View getView(final int position, View convertView, ViewGroup parent) {
            View view = act.getLayoutInflater()
                    .inflate(R.layout.list_gastos_personalizada, parent, false);
            Gasto gasto = gastoList.get(position);
            gastoDAO = new GastoDAO(act);

            TextView data = (TextView)
            view.findViewById(R.id.textView_Data);
            TextView descricao = (TextView)
            view.findViewById(R.id.textView_Descricao);
            TextView categoria = (TextView)
            view.findViewById(R.id.textView_Categoria);
            TextView valor = (TextView)
            view.findViewById(R.id.textView_Valor);

            fabExcGasto = view.findViewById(R.id.ExcGasto);
            fabEditGasto = view.findViewById(R.id.EditGasto);

            data.setText(gasto.getData());
//          categoria.setText(gasto.getCarregaSpinner(Array.lista_categoria));
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
                    intent.putExtra("EditarDado", gastoList.get(position));
                    act.startActivity(intent);

                }
            });

            fabEditGasto.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(act, EditGasto.class);
                    intent.putExtra("EditarDado", gastoList.get(position));
                    act.startActivity(intent);
                }
            });


            fabExcGasto.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (gastoDAO.deletar(getItemId(position)) == LINHA_AFETADA) {
                        Toast.makeText(act,"Funcionou!", Toast.LENGTH_LONG).show();

                    } else {
                        Toast.makeText(act,"Não funcionou!", Toast.LENGTH_LONG).show();
                    }
                }
            });


               return view;
        }




}
