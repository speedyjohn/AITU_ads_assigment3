package org.example.utils.classes;


import org.example.utils.interfaces.MyBSTInterface;

import java.util.Iterator;
import java.util.Stack;

public class MyBST<K extends Comparable<K>, V> implements MyBSTInterface<K,V> {
    private Node root;
    private int size;

    private class Node{

        private K key;
        private V value;
        private Node left, right;

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public Node(K key, V value){
            this.key = key;
            this.value = value;
        }
    }

    public MyBST(){
        root = null;
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        root = put(root, key, value);
    }

    private Node put(Node node, K key, V value){
        if(node == null){
            node = new Node(key, value);
            size++;
            return node;
        }
        if(node.key.equals(key)){
            node.value = value;
            return node;
        }
        if(node.key.compareTo(key) > 0) node.left = put(node.left, key, value);
        else node.right = put(node.right, key, value);
        return node;
    }

    @Override
    public V get(K key) {
        return get(root, key);
    }

    private V get(Node node, K key){
        if(node == null) return null;
        if(node.key.equals(key)) return node.value;
        if(node.key.compareTo(key) > 0) return get(node.left, key);
        return get(node.right, key);
    }

    @Override
    public void delete(K key) {
        root = delete(root, key);
    }

    private Node delete(Node node, K key){
        if(node == null) return null;
        if(node.key.compareTo(key) > 0) node.left = delete(node.left, key);
        else if(node.key.compareTo(key) < 0) node.right = delete(node.right, key);
        else{
            if(node.left == null && node.right == null) return null;
            if(node.left == null) return node.right;
            if(node.right == null) return node.left;
            K min = findMinKey(node.left);
            node.key = min;
            node.left = delete(node.left, min);
        }
        size--;
        return node;
    }

    @Override
    public void inOrder() {
        inOrder(root);
        System.out.println();
    }

    private void inOrder(Node node){
        if(node != null){
            inOrder(node.left);
            System.out.print(node.value + " ");
            inOrder(node.right);
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    private K findMinKey(Node node){
        return node.left == null ? node.key : findMinKey(node.right);
    }

    private class MyIterator implements Iterator<K> {
        private Stack<Node> stack = new Stack<>();

        public MyIterator() {
            pushLeft(root);
        }

        private void pushLeft(Node node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public K next() {
            Node node = stack.pop();
            K result = node.key;
            if (node.right != null) {
                pushLeft(node.right);
            }
            return result;
        }
    }

    public Iterator<K> iterator(){
        return new MyIterator();
    }

}