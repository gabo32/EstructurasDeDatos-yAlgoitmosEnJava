package com.juan.org.edyaj.cap01.casoestudio.aleatorio;

import java.io.*;

public class Personal extends DbObject {

    protected final int nameLen = 10, cityLen = 10;
    protected String name, city;
    protected int SSN, year;
    protected long salary;
    protected final int size = 4 + nameLen * 2 + cityLen * 2 + 4 + 8;

    Personal() {
    }

    Personal(int ssn, String n, String c, int y, long s) {
        SSN = ssn;
        name = n;
        city = c;
        year = y;
        salary = s;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean equals(Object pr) {
        return SSN == ((Personal) pr).SSN;
    }

    @Override
    public void writeToFile(RandomAccessFile out) throws IOException {
        out.writeInt(SSN);
        writeString(name, out);
        writeString(city, out);
        out.writeInt(year);
        out.writeLong(salary);
    }

    @Override
    public void writeLegibly() {
        System.out.print("SSN = " + SSN + ", name = " + name.trim()
                + ", city = " + city.trim() + ", year = " + year
                + ", salary = " + salary);
    }

    @Override
    public void readFromFile(RandomAccessFile in) throws IOException {
        SSN = in.readInt();
        name = readString(nameLen, in);
        city = readString(cityLen, in);
        year = in.readInt();
        salary = in.readLong();
    }

    @Override
    public void readKey() {
        System.out.print("Enter SSN: ");
        SSN = kb.nextInt();
    }

    @Override
    public void readFromConsole() {
        System.out.print("Enter SSN: ");
        SSN = kb.nextInt();
        System.out.print("Name: ");
        name = kb.next();
        for (int i = name.length(); i < nameLen; i++) {
            name += ' ';
        }
        System.out.print("City: ");
        city = kb.next();
        for (int i = city.length(); i < cityLen; i++) {
            city += ' ';
        }
        System.out.print("Birthyear: ");
        year = kb.nextInt();
        System.out.print("Salary: ");
        salary = kb.nextLong();
    }

    @Override
    public void copy(DbObject[] d) {
        d[0] = new Personal(SSN, name, city, year, salary);
    }

    public int compareTo(Object pr) {
        System.out.println("comparando " + SSN + " con " + ((Personal) pr).SSN + " bres " + Integer.compare(SSN, (((Personal) pr).SSN)));
        return Integer.compare(SSN, (((Personal) pr).SSN));
    }

}
