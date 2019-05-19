package com.javarush.task.task35.task3512;

public class Generator<T> {
    Class<T> tClass;

    public Generator(Class<T> tClass) {
        this.tClass = tClass;
    }

    T newInstance() throws IllegalAccessException, InstantiationException {
        T t = tClass.newInstance();
        return t;
    }

}