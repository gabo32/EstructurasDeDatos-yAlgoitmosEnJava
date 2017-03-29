/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juan.org.edyaj.cap01.herencia;

import com.juan.org.edyaj.cap01.herencia.basepackage.BaseClass;

/**
 *
 * @author JuanVaio
 */
class Derived1Level1 extends BaseClass{
    public void f(String s){
        System.out.println("Metodo f() en Derive1leve1 llamado desde "+s);
        g("DerivedLevel1");
    }
    
    public void h(String s){
        System.out.println("Metodo h() en Derived1Level1 llamado desde "+s);
    }
    
    void k(String s){
        System.out.println("Metodo k() en Derived1Level1 llamado desde "+s);
    }
}

class Derived2Level1 extends BaseClass{
    public void f(String s){
        System.out.println("Metodo f() en Derived2Level1 llamado desde "+s);
        //h("Derived2Level1");
        //k("Derived2Level1");
    }
}

class Derived2Level2 extends BaseClass{
    public void f(String s){
        System.out.println("Metodo f() en DerivedLeve2 llamado desde "+s);
        g("DerivedLevel2");
        //h("DerivedLevel2");
        //k("DerivedLevel2");
        super.f("DerivedLevel2");
    }
}

public class TestInheritance{
    void run(){
        BaseClass bc = new BaseClass();
        Derived1Level1  d111 = new Derived1Level1();
        Derived2Level1 d211 = new Derived2Level1();
        Derived2Level2 d12 = new Derived2Level2();
        bc.f("main(1)");
        //bc.g("main(2)");
        //bc.h("main(3)");
        //bc.k("main(4)");
        
        d111.f("main(5)");
//        d111.g("main(7)");
        d111.h("main(8)");
        
                
        d211.f("main(10)");
//        d211.g("main(11)");
//        d211.h("main(12)");
        
        d12.f("main(13)");
//        d12.g("main(14)");
//        d12.h("main(14)");
        
        
    }
    
    public static void main(String[] args) {
        (new TestInheritance()).run();
    }
}
