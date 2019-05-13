package com.javarush.task.task37.task3707;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class AmigoSet<E> extends AbstractSet<E> implements Set<E>, Serializable, Cloneable {

    private static final Object PRESENT = new Object();
    private transient HashMap<E, Object> map;

    public AmigoSet() {
        map = new HashMap<>();
    }

    public AmigoSet(int capacity) {
        map = new HashMap<>(capacity);
    }

    public AmigoSet(Collection<? extends E> c) {
        map = new HashMap<>(Math.max((int) (c.size() / .75f) + 1, 16));
        addAll(c);
    }

    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public void forEach(Consumer<? super E> consumer) {

    }

    @Override
    public boolean removeIf(Predicate<? super E> predicate) {
        return false;
    }

    @Override
    public Spliterator<E> spliterator() {
        return null;
    }

    @Override
    public Stream<E> stream() {
        return null;
    }

    @Override
    public Stream<E> parallelStream() {
        return null;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean add(E e) {
        return map.put(e, PRESENT) == null;
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Object clone() {
        try {
            AmigoSet amigoSet = (AmigoSet) super.clone();
            amigoSet.map = (HashMap) map.clone();
            return amigoSet;
        }
        catch (Exception e) {
            throw new InternalError();
        }
    }

    private void writeObject(ObjectOutputStream oos)
    {
        try
        {
            oos.defaultWriteObject();

            oos.writeObject(map.keySet().size());
            for (E elem : map.keySet())
            {
                oos.writeObject(elem);
            }

            oos.writeObject(HashMapReflectionHelper.callHiddenMethod(map, "capacity"));
            oos.writeObject(HashMapReflectionHelper.callHiddenMethod(map, "loadFactor"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private void readObject(ObjectInputStream ois)
    {
        try
        {
            ois.defaultReadObject();

            Set<E> set = new HashSet<>();
            int size = (int) ois.readObject();
            for (int i = 0; i < size; i++)
            {
                set.add((E) ois.readObject());
            }

            int capacity = (int) ois.readObject();
            float loadFactor = (float) ois.readObject();
            map = new HashMap<>(capacity, loadFactor);
            for (E elem : set)
            {
                map.put(elem, PRESENT);
            }
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}
