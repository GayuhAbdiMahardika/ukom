package com.gayuh.cariguru.model;

public class RegisterSiswaForm {
    private String email,password,nama,provinsi,kabupaten,alamat_lengkap,tanggal_lahir,whatsapp,gender;
    private Integer role;

    public RegisterSiswaForm(String email, String password, String nama, String provinsi, String kabupaten, String alamat_lengkap, String tanggal_lahir, String whatsapp, String gender, Integer role) {
        this.email = email;
        this.password = password;
        this.nama = nama;
        this.provinsi = provinsi;
        this.kabupaten = kabupaten;
        this.alamat_lengkap = alamat_lengkap;
        this.tanggal_lahir = tanggal_lahir;
        this.whatsapp = whatsapp;
        this.gender = gender;
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }
}
