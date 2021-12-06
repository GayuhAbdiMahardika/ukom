package com.gayuh.cariguru.model;

public class PenawaranModel {
    private Integer id, user_id, jumlah_pertemuan, menit_per_pertemuan,harga_asli,disko;
    private String judul, mapel, jenjang;
    private GuruModel guru;

    public PenawaranModel(Integer id, Integer user_id, Integer jumlah_pertemuan, Integer menit_per_pertemuan, Integer harga_asli, Integer disko, String judul, String mapel, String jenjang, GuruModel guru) {
        this.id = id;
        this.user_id = user_id;
        this.jumlah_pertemuan = jumlah_pertemuan;
        this.menit_per_pertemuan = menit_per_pertemuan;
        this.harga_asli = harga_asli;
        this.disko = disko;
        this.judul = judul;
        this.mapel = mapel;
        this.jenjang = jenjang;
        this.guru = guru;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getJumlah_pertemuan() {
        return jumlah_pertemuan;
    }

    public void setJumlah_pertemuan(Integer jumlah_pertemuan) {
        this.jumlah_pertemuan = jumlah_pertemuan;
    }

    public Integer getMenit_per_pertemuan() {
        return menit_per_pertemuan;
    }

    public void setMenit_per_pertemuan(Integer menit_per_pertemuan) {
        this.menit_per_pertemuan = menit_per_pertemuan;
    }

    public Integer getHarga_asli() {
        return harga_asli;
    }

    public void setHarga_asli(Integer harga_asli) {
        this.harga_asli = harga_asli;
    }

    public Integer getDisko() {
        return disko;
    }

    public void setDisko(Integer disko) {
        this.disko = disko;
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

    public String getJenjang() {
        return jenjang;
    }

    public void setJenjang(String jenjang) {
        this.jenjang = jenjang;
    }

    public GuruModel getGuru() {
        return guru;
    }

    public void setGuru(GuruModel guru) {
        this.guru = guru;
    }
}
