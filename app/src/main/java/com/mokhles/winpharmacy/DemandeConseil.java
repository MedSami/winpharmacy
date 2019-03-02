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

public class DemandeConseil extends AppCompatActivity {
String idUtilisateur,idPharmacien;
EditText edtQuestion;
Button btnEnvoyer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demande_conseil);

        edtQuestion=findViewById(R.id.edtQuestion);
        btnEnvoyer=findViewById(R.id.btnEnvoyer);

        Bundle data = getIntent().getExtras();
        if (data != null) {
            idPharmacien = data.getString("idPharmacien");
            idUtilisateur=data.getString("idUtilisateur");

        }
        Toast.makeText(this, idPharmacien+"-"+idUtilisateur, Toast.LENGTH_SHORT).show();

        btnEnvoyer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtQuestion.getText().toString().equals("")){
                    Toast.makeText(DemandeConseil.this, "Saisr Votre Question SVP", Toast.LENGTH_SHORT).show();
                }else {
                    ApiRequest api = RetrofitServer.getClient().create(ApiRequest.class);
                    Call<ResponseDataModel> demandeConseil=api.DemandeConseil(idUtilisateur,idPharmacien,edtQuestion.getText().toString());
                demandeConseil.enqueue(new Callback<ResponseDataModel>() {
                    @Override
                    public void onResponse(Call<ResponseDataModel> call, Response<ResponseDataModel> response) {
                        Toast.makeText(DemandeConseil.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<ResponseDataModel> call, Throwable t) {
                        Toast.makeText(DemandeConseil.this, "Problem Connexion", Toast.LENGTH_SHORT).show();
                    }
                });
                }
            }
        });

    }
}
