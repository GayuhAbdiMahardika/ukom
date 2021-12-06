package com.gayuh.cariguru.model;

public class GuruModel {
    private Integer id, user_id, role;
    private String email, nama, provinsi, kabupaten, alamat_lengkap, tanggal_lahir, pendidikan_terakhir, keahlian, whatsapp, no_rek, gender;
    public GuruModel(Integer id, Integer user_id, String nama, String provinsi, String kabupaten, String alamat_lengkap, String tanggal_lahir, String pendidikan_terakhir, String keahlian, String whatsapp, String no_rek, String gender) {
        this.id = id;
        this.user_id = user_id;
        this.nama = nama;
        this.provinsi = provinsi;
        this.kabupaten = kabupaten;
        this.alamat_lengkap = alamat_lengkap;
        this.tanggal_lahir = tanggal_lahir;
        this.pendidikan_terakhir = pendidikan_terakhir;
        this.keahlian = keahlian;
        this.whatsapp = whatsapp;
        this.no_rek = no_rek;
        this.gender = gender;
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

    public String getPendidikan_terakhir() {
        return pendidikan_terakhir;
    }

    public void setPendidikan_terakhir(String pendidikan_terakhir) {
        this.pendidikan_terakhir = pendidikan_terakhir;
    }

    public String getKeahlian() {
        return keahlian;
    }

    public void setKeahlian(String keahlian) {
        this.keahlian = keahlian;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }

    public String getNo_rek() {
        return no_rek;
    }

    public void setNo_rek(String no_rek) {
        this.no_rek = no_rek;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
