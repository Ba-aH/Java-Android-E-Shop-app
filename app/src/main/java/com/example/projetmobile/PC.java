package com.example.projetmobile;

public class PC {
    String des,reference,prix,img;

    public PC(String des, String reference, String prix, String img) {
        this.des = des;
        this.reference = reference;
        this.prix = prix;
        this.img = img;
    }

    public String getImg() {
        return img;
    }

    public String getDes() {
        return des;
    }

    public String getReference() {
        return reference;
    }

    public String getPrix() {
        return prix;
    }
}
