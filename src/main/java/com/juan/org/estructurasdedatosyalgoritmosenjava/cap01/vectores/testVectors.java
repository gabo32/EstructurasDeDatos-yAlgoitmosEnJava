/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juan.org.estructurasdedatosyalgoritmosenjava.cap01.vectores;

import java.util.Vector;

/**
 *
 * @author JuanVaio
 */
public class testVectors {
    public static void main(String[] args) {
        Vector<Integer> v1 = new Vector<>();
        for (int j = 1; j <= 5; j++) {
            v1.addElement(new Integer(j));
        }
        System.out.println("v1 = "+v1);
        Integer i = new Integer(3);
        System.out.println(v1.indexOf(i)+" "+v1.indexOf(i,4));
        System.out.println(v1.contains(i)+"  "+v1.lastIndexOf(i));
        Vector v2 = new Vector(3, 4);
        for (int j = 4; j <= 8; j++) {
            v2.addElement(new Integer(j));
        }
        
        v2.ensureCapacity(9);
        
        Vector v3 = new Vector(2);
        v3.setSize(4);
        
        v3.setElementAt(new Integer(9), 1);
        v3.setElementAt(new Integer(5), 3);
        v3.insertElementAt(v3.elementAt(3), 1);
        
        v3.ensureCapacity(9);
        
        v3.removeElement(new Integer(9));
        v3.removeElementAt(v3.size()-2);
        java.util.Enumeration ev = v3.elements();
        while(ev.hasMoreElements()){
            System.out.print(ev.nextElement() +" ");
        }
        System.out.println();
        v3.removeElementAt(0);
        v3.addAll(v1);
        v3.removeAll(v2);
        v3.addAll(2, v1);
        v3.retainAll(v2);
        v1.subList(1, 3).clear();
        Vector v4 = new Vector(),v5;
        v4.addElement(new Node("jill",23));
        v5 = (Vector)v4.clone();
        ((Node)v5.firstElement()).age = 34;
        
    }
}
