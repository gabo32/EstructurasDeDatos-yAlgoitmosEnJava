package com.juan.org.edyaj.cap01.casoestudio.aleatorio;

import com.juan.org.edyaj.cap01.entradasalida.EntradaSalida;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JuanVaio
 */
public class Personal extends EntradaSalida implements DbObject{
    protected final int nameLen = 10, cityLen = 10;
    protected String  name, city;
    protected int SSN,year;
    protected long salary;
    protected final int size = 4 + nameLen*2 +cityLen*2+4+8;
    
    Scanner kb = new java.util.Scanner(System.in);
    
    Personal(){}
    
    Personal(int ssn,String n, String c, int y, long s){
        this.SSN = ssn;
        this.name = n;
        this.city =c;
        this.year = y;
        this.salary = s;
    }

    @Override
    public void writeToFile(RandomAccessFile out) throws IOException {
        out.writeInt(SSN);
        writeString(name,out);
        writeString(city,out);
        out.writeInt(year);
        out.writeLong(salary);
    }

    @Override
    public void readFromFile(RandomAccessFile in) throws IOException {
        SSN = in.readInt();
        name = readString (nameLen,in);
        city = readString (cityLen,in);
        year = in.readInt();
        salary = in.readLong();
        
    }

    @Override
    public void readFromConsole() throws IOException {
        System.out.print("Enter SSN: ");
        SSN = kb.nextInt();
        System.out.print("Name: ");
        name = kb.next();
        for (int i = name.length(); i < nameLen; i++) {
            name += " ";
        }
        System.out.print("City: ");
        city = kb.next();
        for (int i = city.length(); i < cityLen; i++) {
            city += " ";
        }
        System.out.println("Birthyear: ");
        year = kb.nextInt();
        System.out.print("Salary: ");
        salary = kb.nextLong();
    }

    @Override
    public void writeLegibly() throws IOException {
        System.out.println("SSN= "+SSN+", name= "+name.trim()+", city="+city.trim()+", year= "+year+", salary= "+salary);
    }

    @Override
    public void readKey() throws IOException {
        System.out.println("Enter SSN: ");
        SSN = kb.nextInt();
    }

    @Override
    public void copy(DbObject[] d) {
        d[0] = new Personal(SSN, name, city, year, salary);
    }

    @Override
    public int size() {
        return size;
    }
    
    
    
    @Override
    public boolean equals(Object pr){
        return SSN==(((Personal)pr).SSN);
    }
    
}
