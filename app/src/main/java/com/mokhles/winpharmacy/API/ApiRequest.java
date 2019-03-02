package com.mokhles.winpharmacy.API;

import com.mokhles.winpharmacy.Model.ResponseDataModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiRequest {
    /******************** Authentification Login*******************/
    @GET("Login.php")
    Call<ResponseDataModel> Login(@Query("pseudo") String pseudo);

    /******************** All Pharmacies*******************/
    @GET("AllPharmacies.php")
    Call<ResponseDataModel> getPharmacies();



    /*************** Inscrire *******************/
    @FormUrlEncoded
    @POST("Inscrire.php")
    Call<ResponseDataModel> Inscrire(
            @Field("nom") String nom,
            @Field("prenom") String prenom,
            @Field("email") String email,
            @Field("pseudo") String pseudo,
            @Field("password") String password
    );

    /*************** Upload Ordonnance *******************/
    @FormUrlEncoded
    @POST("uploadOrdonnance.php")
    Call<ResponseDataModel> UploadOrdonnance(
            @Field("titre") String titre,
            @Field("image") String image,
            @Field("id") String idUtilisateur
    );

    /*************** Demande Conseil *******************/
    @FormUrlEncoded
    @POST("DemandeConseil.php")
    Call<ResponseDataModel> DemandeConseil(
            @Field("id_utilisateur") String id_utilisateur,
            @Field("id_pharmacien") String id_pharmacien,
            @Field("question") String question
    );
}
