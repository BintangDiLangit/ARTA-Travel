/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Halaman;

public class HashTable {

    private LinkedList[] hashArray;
    private int size;

    public HashTable(int size) {
        this.size = size;
        hashArray = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            hashArray[i] = new LinkedList();
        }
    }

    public int convKey(String str) {
        char[] chr_arr = str.toCharArray();
        int result = 0;
        for (int i = 0; i < chr_arr.length; i++) {
            result += (int) chr_arr[i];
        }
        return result;
    }

    public int hashFunc(int pointer) {
        return pointer % size;
    }

    public void displayTable() {
        System.out.println("Table: ");
        for(int j = 0; j < size; j++) {
            System.out.print(" " + j + ". ");
            hashArray[j].displayList();
        }
    }
    
    public void put(int id, String nama, String alamat, String nohp, String paket, String jmlorang, String tgl, String total) {
        int hash = hashFunc(convKey(nohp));
        Travel theLink = new Travel(id, hash, nama, alamat, nohp,paket, jmlorang, tgl,total);
        int hashVal = hashFunc(convKey(nohp));
        hashArray[hashVal].insert(theLink);
    }
    

    public Travel get(String key) {
        int hashVal = hashFunc(convKey(key));
        Travel theLink = hashArray[hashVal].find(key);
        return theLink;
    }
    
    public void edit(int id, String nama, String alamat, String nohp, String paket, String jmlorang, String tgl,String lunas) {
        int hashVal = hashFunc(convKey(nama));
        hashArray[hashVal].edit(id, nama, alamat, nohp,paket, jmlorang, tgl,lunas);
    }
    
    public void delete(int id, String nama) {
        int hashVal = hashFunc(convKey(nama));
        hashArray[hashVal].delete(id); 
    }
    
}

