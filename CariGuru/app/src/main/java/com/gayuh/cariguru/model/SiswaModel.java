package com.gayuh.cariguru.model;

public class SiswaModel {
    private String email, nama, provinsi, kabupaten, alamat_lengkap, tanggal_lahir, whatsapp, gender, gambar, created_at, updated_at;
    private Integer role;
    public SiswaModel(String nama, String provinsi, String kabupaten, String alamat_lengkap, String tanggal_lahir, String whatsapp, String gender, String gambar, String created_at, String updated_at) {
        this.nama = nama;
        this.provinsi = provinsi;
        this.kabupaten = kabupaten;
        this.alamat_lengkap = alamat_lengkap;
        this.tanggal_lahir = tanggal_lahir;
        this.whatsapp = whatsapp;
        this.gender = gender;
        this.gambar = gambar;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(String provinsi) {
        this.provinsi = provinsi;
    }

    public String getKabupaten() {
        return kabupaten;
    }

    public void setKabupaten(String kabupaten) {
        this.kabupaten = kabupaten;
    }

    public String getAlamat_lengkap() {
        return alamat_lengkap;
    }

    public void setAlamat_lengkap(String alamat_lengkap) {
        this.alamat_lengkap = alamat_lengkap;
    }

    public String getTanggal_lahir() {
        return tanggal_lahir;
    }

    public void setTanggal_lahir(String tanggal_lahir) {
        this.tanggal_lahir = tanggal_lahir;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
