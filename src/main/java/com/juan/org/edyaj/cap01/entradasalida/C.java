/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juan.org.edyaj.cap01.entradasalida;

import java.io.Serializable;

/**
 *
 * @author JuanVaio
 */
public class C implements Serializable{
    int i;
    char ch;
    C(int j, char c){
        i = j;
        ch = c;
    }
    @Override
    public String toString(){
        return "("+i+" "+ch+ " )";
    }
}
