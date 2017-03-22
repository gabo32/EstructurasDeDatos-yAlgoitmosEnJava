/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juan.org.estructurasdedatosyalgoritmosenjava.cap01.vectores;

/**
 *
 * @author JuanVaio
 */
public class Node implements Cloneable{
    String name;
    int age;
    
    Node(String n,int a){
        name = n;
        age = a;
    }
    
    Node(){
        this("",0);
    }
    
    public Object clone(){
        return new Node(name, age);
    }
    
    public boolean equals(Node n){
        return name.equals(n.name) && age == n.age;
    }
}
