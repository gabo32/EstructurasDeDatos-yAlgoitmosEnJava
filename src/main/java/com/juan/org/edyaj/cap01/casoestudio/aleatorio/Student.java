/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juan.org.edyaj.cap01.casoestudio.aleatorio;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author JuanVaio
 */
public class Student extends Personal{
    
    protected String major;
    protected final int majorLen = 10;
    
    Student(){
        super();
    }
    
    Student(int ssn,String n,String c,int y,long s, String m){
        super(ssn, n, c, y, s);
        major = m;
    }
    
    @Override
    public int size(){
        return super.size() + majorLen*2;
    }
    
    @Override
    public void writeToFile(RandomAccessFile out)throws IOException{
        super.writeToFile(out);
        writeString(major,out);
    }
    
    @Override
    public void readFromFile(RandomAccessFile in)throws IOException{
        super.readFromFile(in);
        major = readString(majorLen,in);
    }
    
    @Override
    public void readFromConsole()throws IOException{
        super.readFromConsole();
        System.out.print("Introduzca una asignatura principal: ");
        major= kb.next();
        for (int i = major.length(); i < majorLen; i++) {
            major += " ";
        }
    }
    
    @Override
    public void writeLegibly() throws IOException{
        super.writeLegibly();
        System.out.print(", major= "+major.trim());
    }
    
    @Override
    public void copy(DbObject[] d){
        d[0] = new Student(SSN, name, city, year, salary, major);
    }
}
