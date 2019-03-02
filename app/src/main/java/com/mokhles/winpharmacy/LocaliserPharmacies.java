package com.mokhles.winpharmacy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.mokhles.winpharmacy.API.ApiRequest;
import com.mokhles.winpharmacy.API.RetrofitServer;
import com.mokhles.winpharmacy.Adapter.PharmacyAdapter;
import com.mokhles.winpharmacy.Model.DataModel;
import com.mokhles.winpharmacy.Model.ResponseDataModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LocaliserPharmacies extends AppCompatActivity {

    private RecyclerView RecycleLayout;
    private RecyclerView.LayoutManager RecycleManager;
    private RecyclerView.Adapter pharmacyAdapter;
String btnClicked,idUtilisateur;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_localiser_pharmacies);
        RecycleLayout = findViewById(R.id.recyclerview);

        Bundle data = getIntent().getExtras();
        if (data != null) {
            btnClicked = data.getString("btnClicked");
            idUtilisateur=data.getString("idUtilisateur");

        }


        ApiRequest api = RetrofitServer.getClient().create(ApiRequest.class);
        Call<ResponseDataModel> getPharmacies=api.getPharmacies();
        getPharmacies.enqueue(new Callback<ResponseDataModel>() {
            @Override
            public void onResponse(Call<ResponseDataModel> call, Response<ResponseDataModel> response) {
                String code = response.body().getCode();
                List<DataModel> item = response.body().getResult();
                if (code.equals("1")) {
                    RecycleManager = new LinearLayoutManager(LocaliserPharmacies.this, LinearLayoutManager.VERTICAL, false);

                    RecycleLayout.setLayoutManager(RecycleManager);

                    pharmacyAdapter = new PharmacyAdapter(item, LocaliserPharmacies.this,btnClicked,idUtilisateur);

                    RecycleLayout.setAdapter(pharmacyAdapter);
                }
            }

            @Override
            public void onFailure(Call<ResponseDataModel> call, Throwable t) {
                Toast.makeText(LocaliserPharmacies.this, "Problem Connexion", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
