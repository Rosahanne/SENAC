package br.senac.app_controledegastos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.TextView;

public class Menu extends AppCompatActivity {

    private TextView titMenu;
    private CheckBox cbCadGasto;
    private CheckBox cbEditDados;
    private CheckBox cbVerDados;
    private CheckBox cbExcGasto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        titMenu = findViewById(R.id. menu_titulo);
        cbCadGasto = findViewById(R.id. menu_cadDados);
        cbEditDados = findViewById(R.id. menu_editDados);
        cbVerDados = findViewById(R.id. menu_verDados);
        cbExcGasto = findViewById(R.id. menu_excDados);

        


    }
}
