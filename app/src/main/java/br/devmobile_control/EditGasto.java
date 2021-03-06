package br.devmobile_control;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import br.devmobile_control.DAO.GastoDAO;
import br.devmobile_control.Model.Gasto;
import br.devmobile_control.adapters.GastoAdapter;
import br.devmobile_control.helper.GastoHelper;

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
        btnEditar = findViewById(R.id.EditGasto);
        helper = new GastoHelper(this);
        gastoDAO = new GastoDAO(this);

        Intent intent = getIntent();
        Gasto gasto = (Gasto) intent.getSerializableExtra(GastoAdapter.EDIT_GASTO);
        helper.preencheFormulario(gasto);

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

//        btnExcluir.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Gasto gasto = helper.getGasto();
//
//                if (gastoDAO.deletar(gasto.getIdGasto()) == LINHA_AFETADA) {
//                    Toast.makeText(EditGasto.this,"Funcionou!", Toast.LENGTH_LONG).show();
//                    finish();
//                } else {
//                    Toast.makeText(EditGasto.this,"Não funcionou!", Toast.LENGTH_LONG).show();
//                }
//            }
//        });
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