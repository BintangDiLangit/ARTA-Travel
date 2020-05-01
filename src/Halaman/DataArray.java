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
public class DataArray {
    public Travel[] tmb;
    private int nElemen;
    
    public DataArray(int max) {
        tmb = new Travel[max];
        nElemen = 0;
    }
    
    public void insert(int id, String nama, String alamat, String nohp, String paket, String jmlorang,String tgl,String total) {
        tmb[nElemen] = new Travel(id, 0, nama, alamat, nohp,paket,jmlorang,tgl,total);
        nElemen++;
    }
    
    public void edit(int id, String nama, String alamat, String nohp, String paket, String jmlorang, String tgl,String lunas) {
        int i;
        for (i = 0; i < nElemen; i++) {
            if (tmb[i].getId() == id) {
                break;
            }
        }
        if (i != nElemen) {
            tmb[i].setNama(nama);
            tmb[i].setAlamat(alamat);
            tmb[i].setNohp(nohp);
            tmb[i].setPaket(paket);
            tmb[i].setJmlorang(jmlorang);
            tmb[i].setTgl(tgl);
            tmb[i].setLunas(lunas);
        }
    }
    
    public void delete(int id){
        int i;
        for (i = 0; i < nElemen; i++) {
            if (tmb[i].getId() == id) {
                break;
            }
        }
        if (i != nElemen) {
            for (int j = i; j < nElemen; j++) {
                tmb[j] = tmb[j + 1];
            }
            nElemen--;
        }
        
        tmb[id] = null;
    }
    
    public String[][] Array() {
        String result[][] = new String[nElemen][8];
        for (int i = 0; i < nElemen; i++) {
            String[] data = {tmb[i].getNama(), tmb[i].getAlamat(), tmb[i].getNohp(), tmb[i].getPaket(), tmb[i].getJmlorang(), tmb[i].getTgl(),tmb[i].getTotal(),tmb[i].getLunas()};
            result[i] = data;
        }
        return result;
    }
    
    public void SelectionSort() {
        int start, i, min;
        
        for (start = 0; start < nElemen-1; start++) {
            min = start;
            for (i = start + 1; i < nElemen; i++) {
                if (tmb[i].getTgl().compareTo(tmb[min].getTgl())< 0) {
                    min = i;
                }
            }
            swap(start, min);
        }
    }
    
    public void swap(int key1, int key2) {
        Travel temp = tmb[key1];
        tmb[key1] = tmb[key2];
        tmb[key2] = temp;
    }
}
