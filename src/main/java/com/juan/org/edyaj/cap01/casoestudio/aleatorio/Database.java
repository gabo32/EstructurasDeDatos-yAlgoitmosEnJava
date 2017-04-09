package com.juan.org.edyaj.cap01.casoestudio.aleatorio;


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
public class Database {

    private RandomAccessFile database;
    private String fName = new String();
    private Scanner kb = new Scanner(System.in);

    Database(){
    }

    private void add(DbObject d) throws IOException {
        database = new RandomAccessFile(fName, "rw");
        database.seek(database.length());
        d.writeToFile(database);
        database.close();
    }

    private void modify(DbObject d) throws IOException {
        DbObject[] tmp = new DbObject[1];
        d.copy(tmp);
        database = new RandomAccessFile(fName, "rw");
        while (database.getFilePointer() < database.length()) {
            tmp[0].readFromFile(database);
            if (tmp[0].equals(d)) {
                tmp[0].readFromConsole();
                database.seek(database.getFilePointer() - d.size());
                tmp[0].writeToFile(database);
                database.close();
                return;
            }
        }
        database.close();
        System.out.println("El registro que se va a modificiar no esta en la base de datos");
    }

    private boolean find(DbObject d) throws IOException {
        DbObject[] tmp = new DbObject[1];
        d.copy(tmp);
        database = new RandomAccessFile(fName, "r");
        while (database.getFilePointer() < database.length()) {
            tmp[0].readFromFile(database);
            if (tmp[0].equals(d)) {
                database.close();
                return true;
            }
        }
        database.close();
        return false;
    }

    private void printDB(DbObject d) throws IOException {
        database = new RandomAccessFile(fName, "r");
        while (database.getFilePointer() < database.length()) {
            d.readFromFile(database);
            d.writeLegibly();
            System.out.println();
        }
        database.close();
    }

    public void run(DbObject rec) throws IOException {
        String option;
        System.out.print("File name: ");
        fName = kb.next();
        System.out.println("1. Añadir. 2 buscar. 3 modificar un registro. 4 salir");
        System.out.println("Introduzca una opcion");
        option = kb.next();
        while (true) {
            if (option.charAt(0) == '1') {
                rec.readFromConsole();
                add(rec);
            } else if (option.charAt(0) == '2') {
                rec.readKey();
                System.out.println("El registro es: ");
                if (find(rec) == false) {
                    System.out.println("no ");
                }
                System.out.println("En la base de datos");
            }else if(option.charAt(0)=='3'){
                rec.readKey();
                modify(rec);
            }else if(option.charAt(0)!='4'){
                System.out.println("Opcion incorrecta");
            }else{
                return;
            }
            
            printDB(rec);
            System.out.println("Introducza una opcion");
            option = kb.next();
        }
    }

}
