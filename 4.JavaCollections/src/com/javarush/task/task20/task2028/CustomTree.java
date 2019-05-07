package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/* 
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {

    Entry<String> root;

    private List<Entry> list = new ArrayList<>();

    static class Entry<T> implements Serializable {
        String elementName;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            availableToAddLeftChildren = true;
            availableToAddRightChildren = true;
        }

        public void checkChildren() {
            if (leftChild != null) availableToAddLeftChildren = false;
            if (rightChild != null) availableToAddRightChildren = false;
        }

        public boolean isAvailableToAddChildren() {
            return availableToAddLeftChildren || availableToAddRightChildren;
        }

    }

    public CustomTree() {
        this.root = new Entry<>("0");
        list.add(0, root);
    }

    public String getParent(String s) {
        String parent = null;
        for (Entry e: list) {
            if (e.elementName.equals(s)) parent = e.parent.elementName;
        }
        return parent;
    }

    @Override
    public boolean add(String elementName) {
        Entry current;
        Entry newEntry = new Entry(elementName);
        for (int i=0; i<list.size(); i++) {
            current = list.get(i);
            if (current.isAvailableToAddChildren()) {
                if(current.leftChild==null) {
                    current.leftChild = newEntry;
                }
                else current.rightChild = newEntry;
                newEntry.parent=current;
                current.checkChildren();
                list.add(newEntry);
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        int count=0;
        for(Entry e: this.list) {
            if (e!=null) {
                count++;
            }
        }
        return count-1;
    }

    @Override
    public String get(int i) {
        throw new UnsupportedOperationException();
    }
    @Override
    public String set(int i, String s) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int i, String s) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int i, int i1) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int i, int i1) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int i, Collection<? extends String> collection) {
        throw new UnsupportedOperationException();
    }
}
