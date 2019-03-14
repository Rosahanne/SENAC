package br.senac.app_controledegastos;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;
import br.senac.app_controledegastos.DAO.GastoDAO;
import br.senac.app_controledegastos.Model.Gasto;
import br.senac.app_controledegastos.adapters.GastoAdapter;

public class MainActivity extends AppCompatActivity {

    private ListView listViewGastos;
//    private FloatingActionButton fabAddGasto;
    private FloatingActionButton fabAddGasto;
    private FloatingActionButton fabEditGasto;
    public static final String MAIN_GASTO = "main_gasto";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewGastos=(findViewById(R.id.main_listViewGastos));
//        fabAddGasto=(findViewById(R.id.main_fabAddGastos));
//
//        fabAddGasto.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, CadGasto.class);
//                startActivity(intent);
//            }
//        });

        listViewGastos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, EditGasto.class);
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
            List<Gasto> gastoList = gastoDAO.listaTodosGastos();
//            ArrayAdapter<Gasto> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, gasto);
//            listViewGastos.setAdapter(adapter);
            GastoAdapter adapter = new GastoAdapter(gastoList, this);
            listViewGastos.setAdapter(adapter);
        }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Intent intent;

        switch (item.getItemId()) {
            case R.id.menu_cadastrar:
                intent = new Intent(this, CadGasto.class);
                startActivity(intent);
                return true;

            case R.id.menu_listar:
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                return true;

            default:
                Toast.makeText(this, "Houve um erro!!!", Toast.LENGTH_SHORT).show();
        }
        return false;
    }




}
