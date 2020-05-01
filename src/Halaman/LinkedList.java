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
public class LinkedList {
    private Travel head;
    public LinkedList() {
        head = null;
    }
    
    public void insert(Travel newLink) {
        newLink.next = head;
        head = newLink;
    }
    
    public void edit(int id, String nama, String alamat, String nohp, String paket, String jmlorang, String tgl, String lunas) {
        Travel current = head;
        while(current != null) {
            if (current.getId() == id) {
                current.setNama(nama);
                current.setAlamat(alamat);
                current.setNohp(nohp);
                current.setPaket(paket);
                current.setJmlorang(jmlorang);
                current.setTgl(tgl);
                current.setLunas(lunas);
            }
            current = current.next;
        }
    }
    
    public void delete(int key) {
        Travel current = head;
        Travel previous = head;
        
        while(current.getId() != key) {
            if (current.next == null) {
                break;
            } else {
                previous = current;
                current = current.next;
            }
        }
    }
    
    public Travel find(String key) {
        Travel current = head;
        while(current != null) {
            if (current.getNama().equals(key)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }
    
    public void displayList() {
        Travel current = head;
        while(current != null) {
            //current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }
}
