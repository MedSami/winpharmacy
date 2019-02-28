package com.mokhles.winpharmacy.Model;

public class DataModel {
   int id;
   String nom, prenom, email, pseudo, password
     ,tel, latitude, longitude, type, id_pharmacien;

    public DataModel(int id, String nom, String prenom, String email, String pseudo, String password, String tel, String latitude, String longitude, String type, String id_pharmacien) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.pseudo = pseudo;
        this.password = password;
        this.tel = tel;
        this.latitude = latitude;
        this.longitude = longitude;
        this.type = type;
        this.id_pharmacien = id_pharmacien;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public String getPseudo() {
        return pseudo;
    }

    public String getPassword() {
        return password;
    }

    public String getTel() {
        return tel;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getType() {
        return type;
    }

    public String getId_pharmacien() {
        return id_pharmacien;
    }
}
