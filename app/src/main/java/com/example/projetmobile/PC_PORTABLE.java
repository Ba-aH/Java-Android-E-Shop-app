package com.example.projetmobile;

public class PC_PORTABLE {
    String des,image;
    int prix;
    String reference,surl;
    int stock;

    public String getSurl() {
        return surl;
    }

    public void setSurl(String surl) {
        this.surl = surl;
    }



    PC_PORTABLE(){

    }

    public PC_PORTABLE(String des, String image, int prix, String reference, String surl, int stock) {
        this.des = des;
        this.image = image;
        this.prix = prix;
        this.reference = reference;
        this.surl = surl;
        this.stock = stock;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
