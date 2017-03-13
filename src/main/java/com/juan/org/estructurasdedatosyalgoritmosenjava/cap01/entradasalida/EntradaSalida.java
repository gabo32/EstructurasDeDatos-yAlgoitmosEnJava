/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juan.org.estructurasdedatosyalgoritmosenjava.cap01.entradasalida;

import com.sun.corba.se.impl.io.IIOPInputStream;
import com.sun.corba.se.impl.io.IIOPOutputStream;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.StringTokenizer;

/**
 *
 * @author JuanVaio
 */
public class EntradaSalida {
    public String readLine(){
        int ch;
        String s= "";
        while(true){
            try{
                ch = System.in.read();
                if(ch == -1 || (char) ch == '\n')
                    break;
                else if((char)ch != '\r')
                    s = s+ (char)ch;
            }catch(IOException e){
                
            }
        }
        
        return s;
    }
    
    void readBytes1(String fInName, String fOutName) throws IOException{
        FileInputStream fIn = new FileInputStream(fInName);
        FileOutputStream fOut = new FileOutputStream(fOutName);
        int i;
        while((i= fIn.read()) != -1){
            fOut.write(i);
        }
        fIn.close();
        fOut.close();
    }
    
    void readBytes2(String fInName, String fOutName)throws IOException{
        BufferedInputStream fIn = new BufferedInputStream(new FileInputStream(fInName));
        BufferedOutputStream fOut = new BufferedOutputStream(new FileOutputStream(fOutName));
        
        int i;
        while((i= fIn.read())!= -1){
            System.out.println(i+" ");
            fOut.write(i);
        }
        fIn.close();
        fOut.close();
    }
    
    void readLines(String fInName,String fOutName)throws IOException{
        BufferedReader fIn = new BufferedReader(new FileReader(fInName));
        PrintWriter fOut = new PrintWriter(new FileWriter(fOutName));
        String s;
        while((s = fIn.readLine())!= null){
            System.out.println(s);
            fOut.println(s);
        }
        fIn.close();
        fOut.close();
    }
    
    void readTokens(String fInName)throws IOException{
        StreamTokenizer fIn = new StreamTokenizer(new BufferedReader(new FileReader(fInName)));
        fIn.nextToken();
        String s;
        while(fIn.ttype != StreamTokenizer.TT_EOF){
            if(fIn.ttype == StreamTokenizer.TT_WORD)
                s = "word";
            else if(fIn.ttype == StreamTokenizer.TT_NUMBER)
                s = "number";
            else s = "other";
            System.out.println(s + ":\t" + fIn);
            fIn.nextToken();
        }
    }
    
    void readTokens2(String fInName)throws IOException{
        BufferedReader fIn = new BufferedReader(new FileReader(fInName));
        String s;
        while((s = fIn.readLine())!= null){
            java.util.StringTokenizer line = new StringTokenizer(s);
            while(line.hasMoreTokens()){
                System.out.println(line.nextToken());
            }
        }
        fIn.close();
    }
    
    void writePrimitives(String fOutName)throws IOException{
        DataOutputStream fOut = new DataOutputStream(new FileOutputStream(fOutName));
        fOut.writeBoolean(5<6);
        fOut.writeChar('A');
        fOut.writeDouble(1.2);
        fOut.writeFloat(3.4f);
        fOut.writeShort(56);
        fOut.writeInt(78);
        fOut.writeLong(90);
        fOut.writeUTF("abc");
        fOut.close();
    }
    
    void readPrimitives(String fInName)throws IOException{
        DataInputStream fIn = new DataInputStream(new FileInputStream(fInName));
        System.out.println(fIn.readBoolean()+" "+
                fIn.readChar()+" "+
                fIn.readDouble()+" "+
                fIn.readFloat()+" "+
                fIn.readShort()+" "+
                fIn.readInt()+" "+
                fIn.readLong()+" "+
                fIn.readByte()+" "+
                fIn.readUTF());
    }
    
    void writeObjects(String fOutName)throws IOException{
        C c1 = new C(10, 'C'), c2 = new C(20, 'b');
        ObjectOutputStream fOut = new ObjectOutputStream(new FileOutputStream(fOutName));
        fOut.writeObject(c1);
        fOut.writeObject(c2);
        fOut.close();
    }  
    
    void readObjects(String fInName)throws IOException{
        C c1 = new C(10, 'a'), c2= c1;
        ObjectInputStream fIn = new ObjectInputStream(new FileInputStream(fInName));
        try{
            c1 = (C)fIn.readObject();
            c2 = (C)fIn.readObject();
        }catch(ClassNotFoundException e){
            
        }
        System.out.println(c1 +" "+c2);
    }
    
}
