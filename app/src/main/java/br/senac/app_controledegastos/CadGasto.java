package br.senac.app_controledegastos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import br.senac.app_controledegastos.DAO.GastoDAO;
import br.senac.app_controledegastos.Model.Gasto;
import br.senac.app_controledegastos.helper.GastoHelper;

public class CadGasto extends AppCompatActivity {

    private GastoHelper helper;
    private GastoDAO gastoDAO;
    private Button btnCadEnviar;
    private TextView titCadGasto;



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
}
