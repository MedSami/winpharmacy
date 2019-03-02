package com.mokhles.winpharmacy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MenuPrincipal extends AppCompatActivity {
Button btnLocaliser,btnEnvoyerOrdonnance,btnDemandeConseil;
String idUtilisateur;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        btnDemandeConseil=findViewById(R.id.btnDemandeConseil);
        btnEnvoyerOrdonnance=findViewById(R.id.btnEnvoyer);
        btnLocaliser=findViewById(R.id.btnLocaliser);
        Bundle data = getIntent().getExtras();
        if (data != null) {
            idUtilisateur = data.getString("idUtilisateur");

        }

        btnDemandeConseil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MenuPrincipal.this,LocaliserPharmacies.class);
                i.putExtra("btnClicked","conseil");
                i.putExtra("idUtilisateur",idUtilisateur);
                startActivity(i);
            }
        });

        btnEnvoyerOrdonnance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent i=new Intent(MenuPrincipal.this,EnvoyerOrdonnance.class);
            i.putExtra("idUtilisateur",idUtilisateur);
            startActivity(i);
            }
        });

        btnLocaliser
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                     Intent i=new Intent(MenuPrincipal.this,LocaliserPharmacies.class);
                     i.putExtra("btnClicked","localiser");
                        i.putExtra("idUtilisateur",idUtilisateur);

                        startActivity(i);
                    }
                });

    }
}
