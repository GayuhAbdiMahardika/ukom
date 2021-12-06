package com.gayuh.cariguru.model;

import java.util.List;

public class ResponsesLogin{
    private String message;
    private Boolean ok;
    private Data data;

    public ResponsesLogin(String message, Boolean ok, Data data) {
        this.message = message;
        this.ok = ok;
        this.data = data;
    }
    public Integer getRole(){return this.data.getRole();}

    public SiswaModel getSiswa(){return this.data.getSiswa().get(0);}

    public GuruModel getGuru(){return this.data.getGuru().get(0);}

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getOk() {
        return ok;
    }

    public void setOk(Boolean ok) {
        this.ok = ok;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}

class Data{
    private Integer id,role;
    private String email,created_at,updated_at,password;
    private List<GuruModel> guru;
    private List<SiswaModel> siswa;

    public Data(Integer id, Integer role, String email, String created_at, String updated_at, String password, List<GuruModel> guru, List<SiswaModel> siswa) {
        this.id = id;
        this.role = role;
        this.email = email;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.password = password;
        this.guru = guru;
        this.siswa = siswa;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public List<GuruModel> getGuru() {
        return guru;
    }

    public void setGuru(List<GuruModel> guru) {
        this.guru = guru;
    }

    public List<SiswaModel> getSiswa() {
        return siswa;
    }

    public void setSiswa(List<SiswaModel> siswa) {
        this.siswa = siswa;
    }
}
