/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Halaman;

class Stack {
    private int maxSize;
    private Travel[] stackArray;
    private int top;
    
    public Stack(int max) {
        maxSize = max;
        stackArray = new Travel[max];
        top = -1;
    }
    
    public void push(Travel item) {
        stackArray[++top] = item;
    }
    
    public Travel pop() {
        return stackArray[top--];
    }
    
    public Travel peek() {
        return stackArray[top];
    }
    
    public boolean isEmpty() {
        return (top == -1);
    }
    
    public boolean isFull() {
        return (top == maxSize - 1);
    }
    public static void main(String[] args) {
        System.out.println(4^30);
        System.out.println(30^2);
    }
}

