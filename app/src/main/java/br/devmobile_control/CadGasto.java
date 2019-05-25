package br.devmobile_control;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import br.devmobile_control.DAO.GastoDAO;
import br.devmobile_control.Model.Gasto;
import br.devmobile_control.helper.GastoHelper;

public class CadGasto extends AppCompatActivity {

    private GastoHelper helper;
    private GastoDAO gastoDAO;
    private Button btnCadEnviar;
    private TextView titCadGasto;
    private MenuItem cadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadgasto);

        titCadGasto = findViewById(R.id. tCadGasto);
        btnCadEnviar = findViewById(R.id. btnCad_Enviar);
        helper = new GastoHelper(this);
        gastoDAO = new GastoDAO(this);

        btnCadEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Gasto gasto = helper.getGasto();

                if (gastoDAO.inserir(gasto) == -1) {
                    Toast.makeText(CadGasto.this,"Não funcionou", Toast.LENGTH_LONG).show();
                } else {
                    finish();
                }
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_controlegasto, menu);
        return super.onCreateOptionsMenu(menu);
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
