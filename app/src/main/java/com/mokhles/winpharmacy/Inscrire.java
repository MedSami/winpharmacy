package com.mokhles.winpharmacy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mokhles.winpharmacy.API.ApiRequest;
import com.mokhles.winpharmacy.API.RetrofitServer;
import com.mokhles.winpharmacy.Model.ResponseDataModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Inscrire extends AppCompatActivity {
EditText edtNom,edtPrenom,edtEmail,edtPseudo,edtPassword;
Button btnInscrire,btnAnnuler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscrire);
    edtNom=findViewById(R.id.edtNom);
    edtPrenom=findViewById(R.id.edtPrenom);
    edtEmail=findViewById(R.id.edtEmail);
    edtPseudo=findViewById(R.id.edtPseudo);
    edtPassword=findViewById(R.id.edtPassword);
    btnInscrire=findViewById(R.id.btnInscrire);
    btnAnnuler=findViewById(R.id.btnAnnuler);

    btnInscrire.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(edtNom.getText().toString().equals("")){
                Toast.makeText(Inscrire.this, "Saisir votre Nom SVP", Toast.LENGTH_SHORT).show();
            }else if (edtPrenom.getText().toString().equals("")){
                Toast.makeText(Inscrire.this, "Saisir votre Prenom SVP", Toast.LENGTH_SHORT).show();
            }else if (edtEmail.getText().toString().equals("")){
                Toast.makeText(Inscrire.this, "Saisir votre Email SVP", Toast.LENGTH_SHORT).show();
            }else if (edtPseudo.getText().toString().equals("")){
                Toast.makeText(Inscrire.this, "Saisir votre pseudo SVP", Toast.LENGTH_SHORT).show();
            }else if (edtPassword.getText().toString().equals("")){
                Toast.makeText(Inscrire.this, "Saisir votre Mot De Passe SVP", Toast.LENGTH_SHORT).show();
            }else {
                ApiRequest api= RetrofitServer.getClient().create(ApiRequest.class);
                Call<ResponseDataModel> Inscrire=api.Inscrire(edtNom.getText().toString(),
                        edtPrenom.getText().toString(),
                        edtEmail.getText().toString(),
                        edtPseudo.getText().toString(),
                        edtPassword.getText().toString());

                Inscrire.enqueue(new Callback<ResponseDataModel>() {
                    @Override
                    public void onResponse(Call<ResponseDataModel> call, Response<ResponseDataModel> response) {
                        Toast.makeText(Inscrire.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<ResponseDataModel> call, Throwable t) {
                        Toast.makeText(Inscrire.this, "Problem Connexion", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        }
    });

    btnAnnuler.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            edtNom.setText("");
            edtPassword.setText("");
            edtPseudo.setText("");
            edtPrenom.setText("");
            edtEmail.setText("");
        }
    });

    }
}
