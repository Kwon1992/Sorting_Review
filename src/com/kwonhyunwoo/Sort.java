package com.kwonhyunwoo;

import java.util.Arrays;
import java.util.Random;

public abstract  class Sort {
    static Random random = new Random();
    protected int[] arr;

    public void randInit() {
        int size = random.nextInt(20);
        if (size < 5) {
            size = 5;
        }
        arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }

    }

    public String print() {
        return Arrays.toString(arr);
    }

    abstract public void sort() ;
}
