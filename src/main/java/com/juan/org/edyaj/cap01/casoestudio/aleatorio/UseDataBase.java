/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juan.org.edyaj.cap01.casoestudio.aleatorio;

import java.io.IOException;

/**
 *
 * @author JuanVaio
 */
public class UseDataBase {
    public static void main(String[] args) throws IOException{
        (new Database()).run(new Personal());
        
        
    }
   
}
