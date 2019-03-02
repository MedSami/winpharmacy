package com.mokhles.winpharmacy;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.mokhles.winpharmacy.API.ApiRequest;
import com.mokhles.winpharmacy.API.RetrofitServer;
import com.mokhles.winpharmacy.Model.ResponseDataModel;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EnvoyerOrdonnance extends AppCompatActivity {

    EditText TitreImage;
    Button btnChoisir,btnUpload;
    ImageView img;
    String idUtilisateur;
    private static  final int img_request=777;
    private Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_envoyer_ordonnance);

            TitreImage=findViewById(R.id.edtTitre);
            img=findViewById(R.id.imageView2);
            btnChoisir=findViewById(R.id.btnChoisir);
            btnUpload=findViewById(R.id.btnUpload);


        Bundle data = getIntent().getExtras();
        if (data != null) {
            idUtilisateur = data.getString("idUtilisateur");

        }
        Toast.makeText(this, idUtilisateur, Toast.LENGTH_SHORT).show();
        btnChoisir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectImage();
            }
        });

        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uploadImage();
            }
        });

    }



    private  void selectImage(){
        Intent intent =new Intent();
        intent.setType("image/*");
        intent.setAction(intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,img_request);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==img_request && resultCode==RESULT_OK && data !=null){
            Uri path= data.getData();
            try {
                bitmap= MediaStore.Images.Media.getBitmap(getContentResolver(),path);
                img.setImageBitmap(bitmap);
                img.setVisibility(View.VISIBLE);
                TitreImage.setVisibility(View.VISIBLE);
                btnChoisir.setEnabled(false);
                btnUpload.setEnabled(true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void uploadImage(){
        String image=imageToString();
        String image_titre=TitreImage.getText().toString();

        if(image_titre.equals("")){
            Toast.makeText(this, "Saisir titre Image", Toast.LENGTH_SHORT).show();
            return;
        }

        ApiRequest api= RetrofitServer.getClient().create(ApiRequest.class);
        Call<ResponseDataModel> upload=api.UploadOrdonnance(image_titre,image,idUtilisateur);
        upload.enqueue(new Callback<ResponseDataModel>() {
            @Override
            public void onResponse(Call<ResponseDataModel> call, Response<ResponseDataModel> response) {
                if (response.isSuccessful()){
                    Toast.makeText(EnvoyerOrdonnance.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    img.setVisibility(View.GONE);
                    TitreImage.setText("");
                    TitreImage.setVisibility(View.GONE);

                    btnChoisir.setEnabled(true);
                    btnUpload.setEnabled(false);

                }else {
                    Toast.makeText(EnvoyerOrdonnance.this, "n'est pas enregistrer", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<ResponseDataModel> call, Throwable t) {
                Toast.makeText(EnvoyerOrdonnance.this, "Problem Connexion", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private String imageToString(){
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
        byte[] imgByte=byteArrayOutputStream.toByteArray();
        return Base64.encodeToString(imgByte,Base64.DEFAULT);

    }
}
