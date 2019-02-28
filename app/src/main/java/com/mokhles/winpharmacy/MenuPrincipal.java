package com.mokhles.winpharmacy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MenuPrincipal extends AppCompatActivity {
Button btnLocaliser,btnEnvoyerOrdonnance,btnDemandeConseil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        btnDemandeConseil=findViewById(R.id.btnDemandeConseil);
        btnEnvoyerOrdonnance=findViewById(R.id.btnEnvoyer);
        btnLocaliser=findViewById(R.id.btnLocaliser);


        btnDemandeConseil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnEnvoyerOrdonnance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnLocaliser
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });

    }
}
