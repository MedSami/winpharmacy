package com.mokhles.winpharmacy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mokhles.winpharmacy.API.ApiRequest;
import com.mokhles.winpharmacy.API.RetrofitServer;
import com.mokhles.winpharmacy.Model.ResponseDataModel;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
EditText edtPseudo,edtPassword;
Button btnEntrer,btnInscrire;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        edtPseudo=findViewById(R.id.edtPseudo);
        edtPassword=findViewById(R.id.edtPassword);

        btnEntrer=findViewById(R.id.btnEntrer);
        btnInscrire=findViewById(R.id.btnInscrire);
        btnEntrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (edtPseudo.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "Saisir votre pseudo SVP", Toast.LENGTH_SHORT).show();
                }else if (edtPassword.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "Saisir votre Mot De Passe SVP", Toast.LENGTH_SHORT).show();
                }else {
                    String CryptPass=convertPassMd5(edtPassword.getText().toString());
                    ApiRequest api= RetrofitServer.getClient().create(ApiRequest.class);
                    Call<ResponseDataModel> Login=api.Login(
                            edtPseudo.getText().toString());
                    Login.enqueue(new Callback<ResponseDataModel>() {
                        @Override
                        public void onResponse(Call<ResponseDataModel> call, Response<ResponseDataModel> response) {
                            if(response.isSuccessful()){
                                if(response.body().getResult().get(0).getPseudo().equals(edtPseudo.getText().toString())){
                                    if(response.body().getResult().get(0).getPassword().equals(CryptPass)){


                                        Intent intent=new Intent(MainActivity.this,MenuPrincipal.class);
                                        intent.putExtra("idUtilisateur",""+response.body().getResult().get(0).getId());
                                        startActivity(intent);




                                    }else {
                                        Toast.makeText(MainActivity.this, "Mot De Passe Incorrect", Toast.LENGTH_SHORT).show();
                                    }
                                }else {
                                    Toast.makeText(MainActivity.this, "Pseudo Incorrect", Toast.LENGTH_SHORT).show();

                                }
                            }else {
                                Toast.makeText(MainActivity.this, "Pseudo Incorrect", Toast.LENGTH_SHORT).show();
                            }                        }

                        @Override
                        public void onFailure(Call<ResponseDataModel> call, Throwable t) {
                            Toast.makeText(MainActivity.this, "Problem Connexion", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });

        btnInscrire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,Inscrire.class);
                startActivity(i);
            }
        });

    }


    public static String convertPassMd5(String pass) {
        String password = null;
        MessageDigest mdEnc;
        try {
            mdEnc = MessageDigest.getInstance("MD5");
            mdEnc.update(pass.getBytes(), 0, pass.length());
            pass = new BigInteger(1, mdEnc.digest()).toString(16);
            while (pass.length() < 32) {
                pass = "0" + pass;
            }
            password = pass;
        } catch (NoSuchAlgorithmException e1) {
            e1.printStackTrace();
        }
        return password;
    }
}
