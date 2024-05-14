package org.example.utils.classes;

public class MyTestingClass {
    private int id;
    private String key;

    public MyTestingClass(int id, String key){
        this.id = id;
        this.key = key;
    }

    public int getId() {
        return id;
    }

    public String getKey() {
        return key;
    }

    @Override
    public int hashCode(){
        int hash = 0;
        for(char c : key.toCharArray()){
            hash = c + (31 * hash);
        }
        hash = (17 * id) + (31 * hash);
        return hash;
    }
}