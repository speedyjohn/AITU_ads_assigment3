package org.example.utils.classes;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Utilities {
    static List<String> names;
    public static String getRandomName(){
        return getRandomNames(1)[0];
    }

    public static String[] getRandomNames(int count){
        if(names == null || names.isEmpty()) readNames();
        String[] res = new String[count];
        Random rand = new Random();
        for(int i = 0; i < count; i++) res[i] = names.get(rand.nextInt(names.size()));
        return res;
    }

    public static String getRandomKey(int length){
        StringBuilder res = new StringBuilder();
        Random rand = new Random();
        for(int i = 0; i < length; i++){
            char c = (char) (rand.nextInt(26) + (rand.nextBoolean() ? 65 : 97));
            res.append(c);
        }
        return res.toString();
    }

    public static Student studentGenerator(int id){
        Random random = new Random();
        double gpa = random.nextDouble() * 4;
        char gender = random.nextBoolean() ? 'M' : 'F';
        String name = getRandomName();
        return new Student(id, gpa, gender, name);
    }

    public static MyTestingClass testingClassGenerator(int id){
        return new MyTestingClass(id, getRandomKey(12));
    }

    static void readNames(){
        names = new ArrayList<>();
        File file = new File("src/main/resources/names.txt");
        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                names.add(scanner.nextLine());
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}