package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* 
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {

    Entry<String> root;

    private final List<Entry<String>> list = new ArrayList<>();

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
            return (availableToAddLeftChildren || availableToAddRightChildren);
        }

        public boolean noChildren() {
            return leftChild == null & rightChild == null;
        }
    }

    public CustomTree() {
        this.root = new Entry<>("0");
        list.add(0, root);
    }

    @Override
    public boolean add(String elementName) {
        Entry<String> current;
        Entry<String> newEntry = new Entry<>(elementName);
        for (int i = 0; i < list.size(); i++) {
            current = list.get(i);
            if (current.isAvailableToAddChildren()) {
                if (current.leftChild == null) {
                    current.leftChild = newEntry;
                } else current.rightChild = newEntry;
                newEntry.parent = current;
                current.checkChildren();
                list.add(newEntry);
                return true;
            }
        }
        return false;
    }

    public boolean remove(Object o) {
        String elementName;
        if (!(o instanceof String)) {
            throw new UnsupportedOperationException();
        } else {
            elementName = String.valueOf(o);
        }
        List<Entry<String>> entryForRemove = new ArrayList<>();
        for (Entry<String> entry : list) {
            String entryElementName = entry.elementName;
            if (elementName.equals(entryElementName)) {
                if (entry.parent.leftChild.elementName.equals(entryElementName)) {
                    entry.parent.availableToAddLeftChildren = true;
                } else {
                    entry.parent.availableToAddRightChildren = true;
                }
                entryForRemove = getChildren(entry);
            }
        }

//        System.out.println(entryForRemove);

        if (entryForRemove.size() > 0) {
            for (Entry<String> entry : entryForRemove) {
                list.remove(entry);
            }
            return true;
        }

        return false;
    }

    private List<Entry<String>> getChildren(Entry<String> entry) {
        List<Entry<String>> result = new ArrayList<>();
        List<Entry<String>> leftChild = new ArrayList<>();
        List<Entry<String>> rightChild = new ArrayList<>();

        if (entry.noChildren()) {
            result.add(entry);
            return result;
        } else if (entry.leftChild == null) {
            leftChild.add(entry);
            rightChild = getChildren(entry.rightChild);
        } else if (entry.rightChild == null) {
            leftChild = getChildren((entry.leftChild));
            rightChild.add(entry);
        } else {
            leftChild = getChildren((entry.leftChild));
            rightChild = getChildren(entry.rightChild);
            leftChild.add(entry);
        }

        result = joinLists(leftChild, rightChild);

        return result;
    }

    @Override
    public String get(int i) {
        throw new UnsupportedOperationException();
    }

    public String getParent(String s) {
        return list.stream()
                .filter(entry -> s.equals(entry.elementName))
                .findFirst()
                .map(entry -> String.valueOf(entry.parent.elementName))
                .orElse(null);
    }

    @Override
    public int size() {
        int count = 0;
        for (Entry<String> e : this.list) {
            if (e != null) {
                count++;
            }
        }
        return count - 1;
    }

    public static <T> ArrayList<T> joinLists(
            final List<? extends T> listA,
            final List<? extends T> listB) {

        boolean aEmpty = (listA == null) || listA.isEmpty();
        boolean bEmpty = (listB == null) || listB.isEmpty();
        //побитное И!
        if (aEmpty & bEmpty) {
            // оба пустые — отдаем новый пустой список
            return new ArrayList<>();
        } else if (aEmpty) {
            // один пустой — отдаем копию другого, содержащую все его элементы
            return new ArrayList<>(listB);
        } else if (bEmpty) {
            return new ArrayList<>(listA);
        } else {
            // оба непустые — объединяем
            ArrayList<T> result = new ArrayList<>(
                    listA.size() + listB.size());
            result.addAll(listA);
            result.addAll(listB);
            return result;
        }
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

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
