package com.juan.org.edyaj.cap01.casoestudio.aleatorio;

import com.juan.org.edyaj.cap01.entradasalida.EntradaSalida;
import java.io.IOException;
import java.io.RandomAccessFile;

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
    protected String SSN, name, city;
    protected int year;
    protected long salary;
    protected final int size = 9*2 + nameLen*2 +cityLen*2+4+8;
    
    Personal(){}
    
    Personal(String ssn,String n, String c, int y, long s){
        this.SSN = ssn;
        this.name = n;
        this.city =c;
        this.year = y;
        this.salary = s;
    }

    @Override
    public void writeToFile(RandomAccessFile out) throws IOException {
        writeString(SSN,out);
        writeString(name,out);
        writeString(city,out);
        out.writeInt(year);
        out.writeLong(salary);
    }

    @Override
    public void readFromFile(RandomAccessFile in) throws IOException {
        SSN = readString (9,in);
        name = readString (nameLen,in);
        city = readString (cityLen,in);
        year = in.readInt();
        salary = in.readLong();
        
    }

    @Override
    public void readFromConsole() throws IOException {
        System.out.print("Enter SSN: ");
        SSN = readLine();
        System.out.print("Name: ");
        name = readLine();
        for (int i = name.length(); i < nameLen; i++) {
            name += " ";
        }
        System.out.print("City: ");
        city = readLine();
        for (int i = city.length(); i < cityLen; i++) {
            city += " ";
        }
        System.out.println("Birthyear: ");
        year = Integer.valueOf(readLine().trim()).intValue();
        System.out.print("Salary: ");
        salary = Long.valueOf(readLine().trim()).intValue();
    }

    @Override
    public void writeLegibly() throws IOException {
        System.out.println("SSN= "+SSN+", name= "+name.trim()+", city="+city.trim()+", year= "+year+", salary= "+salary);
    }

    @Override
    public void readKey() throws IOException {
        System.out.println("Enter SSN: ");
        SSN = readLine();
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
        return SSN.equals(((Personal)pr).SSN);
    }
    
}
