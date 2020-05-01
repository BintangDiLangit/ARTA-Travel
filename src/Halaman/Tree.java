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
public class Tree {

    Travel root;
    String[] data, dataName;
    int size;

    public Tree() {
        size = new CRUD().count();
        root = null;
        data = new String[size];
        dataName = new String[size];
    }

    public void insert(int id, String nama, String alamat, String nohp, String paket, String jmlorang, String tgl, String total) {
        Travel newTravel = new Travel(id, 0, nama, alamat, nohp, paket, jmlorang, tgl,total);
        if (root == null) {
            root = newTravel;
        } else {
            Travel current = root;
            Travel parent;
            while (true) {
                parent = current;
                if (current.getId() == id) {
                    System.out.println("Cant insert," + id + " already exist ");
                }
                if (id < current.getId()) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = newTravel;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = newTravel;
                        return;
                    }
                }
            }
        }
    }

    public Travel edit(int id, String nama, String alamat, String nohp, String paket, String jmlorang, String tgl,String lunas) {
        Travel current = root;
        if (root.getId() == id) {
            current.setNama(nama);
            current.setAlamat(alamat);
            current.setNohp(nohp);
            current.setPaket(paket);
            current.setJmlorang(jmlorang);
            current.setTgl(tgl);
            current.setLunas(lunas);
        }
        while (current.getId() != id) {
            if (id < current.getId()) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
            if (current == null) {
                break;
            }
            if (current.getId() == id) {
                current.setNama(nama);
                current.setAlamat(alamat);
                current.setNohp(nohp);
                current.setPaket(paket);
                current.setJmlorang(jmlorang);
                current.setTgl(tgl);
                current.setLunas(lunas);
            }
        }
        return current;
    }

    public void delete(int key) {
        Travel current = root;
        Travel parent = root;
        boolean isLeftChild = true;
        while (current.getId() != key) {
            parent = current;
            if (key < current.getId()) {
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.rightChild;
            }
            if (current == null) {
                break;
            }
        }
        if (current.leftChild == null && current.rightChild == null) {
            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                parent.leftChild = current.leftChild;
            } else {
                parent.rightChild = current.rightChild;
            }
        } else if (current.rightChild == null) {
            if (current == root) {
                root = current.leftChild;
            } else if (isLeftChild) {
                parent.leftChild = current.leftChild;
            } else {
                parent.rightChild = current.rightChild;
            }
        } else if (current.leftChild == null) {
            if (current == root) {
                root = current.rightChild;
            } else if (isLeftChild) {
                parent.leftChild = current.leftChild;
            } else {
                parent.rightChild = current.rightChild;
            }
        } else {
            Travel successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.leftChild = successor;
            } else {
                parent.rightChild = successor;
            }
            successor.leftChild = current.leftChild;
        }
    }

    private Travel getSuccessor(Travel delTrav) {
        Travel successorParent = delTrav;
        Travel successor = delTrav;
        Travel current = delTrav.leftChild;
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        if (successor != delTrav.rightChild) {
            successorParent.leftChild = delTrav.rightChild;
            successor.rightChild = delTrav.rightChild;
        }
        return successor;
    }

    public String[][] search(String term) {
        int i = 0;
        Stack stack = new Stack(size);
        String[] result[] = new String[size][7];
        
        
        stack.push(root);
        while (!stack.isEmpty()) {
            Travel current = stack.pop();
            if (current.getNama().contains(term) || current.getAlamat().contains(term) || current.getNohp().contains(term) || current.getPaket().contains(term) || current.getJmlorang().contains(term) || current.getTgl().contains(term) || current.getTotal().contains(term) ) {
                String[] data = {current.getNama(), current.getAlamat(), current.getNohp(), current.getPaket(), current.getJmlorang(), current.getTgl(), current.getTotal()};
                result[i++] = data;
            }
            if (current.leftChild != null) {
                stack.push(current.leftChild);
            }
            if (current.rightChild != null) {
                stack.push(current.rightChild);
            }
        }
        i = 0;
        return result;
    }

}
