package com.mokhles.winpharmacy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MenuPrincipal extends AppCompatActivity {
Button btnLocaliser,btnEnvoyerOrdonnance,btnDemandeConseil,btnTraitement;
String idUtilisateur;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        btnDemandeConseil=findViewById(R.id.btnDemandeConseil);
        btnEnvoyerOrdonnance=findViewById(R.id.btnEnvoyer);
        btnTraitement=findViewById(R.id.btnTraitement);
        btnLocaliser=findViewById(R.id.btnLocaliser);
        Bundle data = getIntent().getExtras();
        if (data != null) {
            idUtilisateur = data.getString("idUtilisateur");

        }
btnTraitement.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent i=new Intent(MenuPrincipal.this,Traitement.class);
        startActivity(i);
    }
});
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
