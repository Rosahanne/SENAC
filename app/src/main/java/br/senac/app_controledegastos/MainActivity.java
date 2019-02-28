package br.senac.app_controledegastos;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import br.senac.app_controledegastos.DAO.GastoDAO;
import br.senac.app_controledegastos.Model.Gasto;

public class MainActivity extends AppCompatActivity {

    private ListView listViewGastos;
    private FloatingActionButton fabAddGasto;
    public static final String MAIN_GASTO = "main_gasto";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewGastos=(findViewById(R.id.main_listViewGastos));
        fabAddGasto=(findViewById(R.id.main_fabAddGastos));

        fabAddGasto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CadGasto.class);
                startActivity(intent);
            }
        });

        listViewGastos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, CadGasto.class);
                Gasto gasto = (Gasto)parent.getItemAtPosition(position);
                intent.putExtra(MAIN_GASTO, gasto);
                startActivity(intent);
            }
        });
     }

        @Override
        protected void onResume(){
            super.onResume();
            GastoDAO gastoDAO = new GastoDAO(this);
            List<Gasto> gasto = GastoDAO.listaTodosGastos();
            ArrayAdapter<Gasto> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, gasto);
            listViewGastos.setAdapter(adapter);
        }




}
