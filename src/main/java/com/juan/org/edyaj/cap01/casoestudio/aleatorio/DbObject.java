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
public interface DbObject {
    public void writeToFile(RandomAccessFile out)throws IOException;
    public void readFromFile(RandomAccessFile in)throws IOException;
    public void readFromConsole()throws IOException;
    public void writeLegibly()throws IOException;
    public void readKey()throws IOException;
    public void copy(DbObject[] db);
    public int compareTo(Object d);
    public int size();
}
