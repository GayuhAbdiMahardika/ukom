package com.gayuh.cariguru.model;

public class Promo {
    private String judul, mapel, jumlahPertemuan, waktu, hargaAsli, diskon;

    public Promo(String judul, String mapel, String jumlahPertemuan, String waktu, String hargaAsli, String diskon ) {
        this.judul = judul;
        this.mapel = mapel;
        this.jumlahPertemuan = jumlahPertemuan;
        this.waktu = waktu;
        this.hargaAsli = hargaAsli;
        this.diskon = diskon;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getMapel() {
        return mapel;
    }

    public void setMapel(String mapel) {
        this.mapel = mapel;
    }

    public String getJumlahPertemuan() {
        return jumlahPertemuan;
    }

    public void setJumlahPertemuan(String jumlahPertemuan) {
        this.jumlahPertemuan = jumlahPertemuan;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public String getHargaAsli() {
        return hargaAsli;
    }

    public void setHargaAsli(String hargaAsli) {
        this.hargaAsli = hargaAsli;
    }

    public String getDiskon() {
        return diskon;
    }

    public void setDiskon(String diskon) {
        this.diskon = diskon;
    }
}
