package org.example.utils.classes;


public class Student {
    private int id;
    private double gpa;
    private char gender;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public Student(char gender, String name){
        this(0, 0, gender, name);
    }

    public Student(double gpa, char gender, String name){
        this(0, gpa, gender, name);
    }

    public Student(int id, double gpa, char gender, String name){
        this.id = id;
        this.gpa = gpa;
        this.gender = gender;
        this.name = name;
    }

    @Override
    public int hashCode(){
        int hash = 0;
        for(char c : name.toCharArray()){
            hash = c + (31 * hash);
        }
        return hash;
    }
}