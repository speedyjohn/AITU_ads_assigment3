package org.example;

import org.example.utils.classes.MyBST;

public class Main {
    public static void main(String[] args) {
        MyBST<Integer, Integer> bst = new MyBST<Integer, Integer>();

        bst.put(21, 21);
        bst.put(53, 53);
        bst.put(63, 63);
        bst.put(12, 12);
        bst.put(14, 14);
        bst.put(6, 6);
        bst.put(10, 10);
        bst.put(9, 9);

        bst.inOrder();
        System.out.println(bst.getSize());

        bst.delete(10);

        bst.inOrder();
        System.out.println(bst.getSize());

        for (var key : bst) {
            Integer value = bst.get(key);
            System.out.println("key is " + key + " and value is " + value);
        }
    }
}