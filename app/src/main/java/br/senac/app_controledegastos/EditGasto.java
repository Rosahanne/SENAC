package br.senac.app_controledegastos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import br.senac.app_controledegastos.DAO.GastoDAO;
import br.senac.app_controledegastos.Model.Gasto;
import br.senac.app_controledegastos.helper.GastoHelper;

public class EditGasto extends AppCompatActivity {

    private GastoHelper helper;
    private GastoDAO gastoDAO;
    private Button btnEditar;
    private TextView titEditGastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_gasto);

        titEditGastro = findViewById(R.id.tEdGasto);
        btnEditar = findViewById(R.id. btnEdit);
        helper = new GastoHelper(this);
        gastoDAO = new GastoDAO(this);

        Intent intent = getIntent();
        Gasto gasto = (Gasto) intent.getSerializableExtra(MainActivity.MAIN_GASTO);
        helper.carregaCampos(gasto);


        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Gasto gasto = helper.getGasto();

                if (gastoDAO.editar(gasto) > 0) {
                    Toast.makeText(EditGasto.this,"Funcionou!", Toast.LENGTH_LONG).show();
                    finish();
                } else {
                    Toast.makeText(EditGasto.this,"Não funcionou!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}