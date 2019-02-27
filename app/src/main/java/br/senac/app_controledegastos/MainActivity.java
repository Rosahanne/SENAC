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

import br.senac.app_controledegastos.DAO.CustosDAO;

public class MainActivity extends AppCompatActivity {

    private ListView listViewGastos;
    private FloatingActionButton fabAddGasto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewGastos=(findViewById(R.id.main_listViewGastos));
        fabAddGasto=(findViewById(R.id.main_fabAddGastos));

        fabAddGasto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Cadastro.class);
                startActivity(intent);
            }
        });

        @Override
        protected void onResume() {
            super.onResume();
            CustosDAO custosDAO = new CustosDAO(this);
            List<Gasto> gasto = CustosDAO.listaTodosGastos();
            ArrayAdapter<Gasto> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, gasto);
            listViewGastos.setAdapter(adapter);
        }



    }
}
