package br.senac.app_controledegastos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import br.senac.app_controledegastos.DAO.GastoDAO;
import br.senac.app_controledegastos.Model.Gasto;
import br.senac.app_controledegastos.helper.GastoHelper;

public class CadGasto extends AppCompatActivity {

    private GastoHelper helper;
    private GastoDAO gastoDAO;
    private Button btnCadGasto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadgasto);

        btnCadGasto = findViewById(R.id. btnCGasto);
        helper = new GastoHelper(this);
        gastoDAO = new GastoDAO(this);

        btnCadGasto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Gasto gasto = helper.getAluno();
                gastoDAO.inserir(gasto);
                if (gastoDAO.inserir(gasto) == -1) {
                    Toast.makeText(CadGasto.this,"Cadastro com sucesso", Toast.LENGTH_LONG).show();
                } else {
                    finish();
                }
            }
        });


    }
}
