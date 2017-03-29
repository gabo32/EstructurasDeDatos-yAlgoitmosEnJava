/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juan.org.edyaj.cap01.herencia.basepackage;

/**
 *
 * @author JuanVaio
 */
public class BaseClass {
    public BaseClass(){
        
    }
    
    public void f(String s){
        System.out.println("Metodo f() es BaseClass llamado desde "+s);
        h("BaseCLass");
    }
    
    protected void g(String s){
        System.out.println("Metodo g() en BaseClass llamado desde "+s);
    }
    
    private void h(String s){
        System.out.println("Metodo h() en BaseCLass llamado desde "+s);
    }
    
    void k(String s){
        System.out.println("Metodo k() en BaseClass llamado desde "+s);
    }
}
