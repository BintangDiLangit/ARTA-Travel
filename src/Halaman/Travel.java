/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Halaman;

/**
 *
 * @author BintangDiLangit
 */
public class Travel {

    private int id;
    private int hash;
    private String nama;
    private String alamat;
    private String nohp;
    private String paket;
    private String jmlorang;
    private String tgl;
    private String total;
    private String lunas;
    public Travel next;
    public Travel rightChild;
    public Travel leftChild;

    public Travel(int id, int hash, String nama, String alamat, String nohp, String paket, String jmlorang, String tgl, String total) {
        this.id = id;
        this.hash = hash;
        this.nama = nama;
        this.alamat = alamat;
        this.nohp = nohp;
        this.paket = paket;
        this.jmlorang = jmlorang;
        this.tgl = tgl;
        this.total = total;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNohp() {
        return nohp;
    }

    public void setNohp(String nohp) {
        this.nohp = nohp;
    }

    public String getPaket() {
        return paket;
    }

    public void setPaket(String paket) {
        this.paket = paket;
    }

    public String getJmlorang() {
        return jmlorang;
    }

    public void setJmlorang(String jmlorang) {
        this.jmlorang = jmlorang;
    }

    public void setTgl(String tgl) {
        this.tgl = tgl;
    }

    public String getTgl() {
        return tgl;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getTotal() {
        return total;
    }
    public void setLunas(String lunas) {
        this.lunas = lunas;
    }

    public String getLunas() {
        return lunas;
    }

    public int getHash() {
        return hash;
    }

    public int getId() {
        return id;
    }

}
